package controller;

import dao.BrandDAO;
import entity.Brand;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class BrandBean implements Serializable {

    private Brand entity;

    @EJB
    private BrandDAO dao;

    private List<Brand> list;
    private int pageNumber = 1; // Başlangıç sayfa numarası
    private int pageSize = 10; // Sayfa başına maksimum kayıt sayısı

    public BrandBean() {
        entity = new Brand();
    }

    public void create() {
        dao.create(entity);
        entity = new Brand(); // Yeni bir Brand nesnesi oluştur
        pageNumber = 1; // Sayfa numarasını sıfırla
        updateList(); // Listeyi güncelle

    }

    public void update() {
        dao.update(entity);
        entity = new Brand();
    }

    public void delete() {
        dao.delete(entity);
        entity = new Brand(); // Silinen kategori için yeni bir Brand nesnesi oluştur
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

    public Brand getEntity() {
        return entity;
    }

    public void setEntity(Brand entity) {
        this.entity = entity;
    }

    public List<Brand> getList() {
        if (list == null) {
            updateList();
        }
        return list;
    }

    public void setList(List<Brand> list) {
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