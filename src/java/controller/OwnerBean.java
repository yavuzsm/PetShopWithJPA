package controller;

import dao.OwnerDAO;
import entity.Owner;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class OwnerBean implements Serializable {

    private Owner entity;

    @EJB
    private OwnerDAO dao;

    private List<Owner> list;
    private int pageNumber = 1; // Başlangıç sayfa numarası
    private int pageSize = 10; // Sayfa başına maksimum kayıt sayısı

    public OwnerBean() {
        entity = new Owner();
    }

    public void create() {
        dao.create(entity);
        entity = new Owner(); // Yeni bir Category nesnesi oluştur
        pageNumber = 1; // Sayfa numarasını sıfırla
        updateList(); // Listeyi güncelle

    }

    public void update() {
        dao.update(entity);
        entity = new Owner();
    }

    public void delete() {
        dao.delete(entity);
        entity = new Owner(); // Silinen kategori için yeni bir Category nesnesi oluştur
        pageNumber = 1; // Sayfa numarasını sıfırla
        updateList(); // Listeyi güncelle
    }

    public void nextPage() {
        pageNumber++;
        updateList();
    }

    public void previousPage() {
        if (pageNumber > 1) {
            pageNumber--;
            updateList();
        }
    }

    private void updateList() {
        list = dao.findCategoriesWithPagination(pageNumber, pageSize);
    }

    public Owner getEntity() {
        return entity;
    }

    public void setEntity(Owner entity) {
        this.entity = entity;
    }

    public List<Owner> getList() {
        if (list == null) {
            updateList();
        }
        return list;
    }

    public void setList(List<Owner> list) {
        this.list = list;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}