package controller;

import dao.CategoryDAO;
import entity.Category;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class CategoryBean implements Serializable {

    private Category entity;

    @EJB
    private CategoryDAO dao;

    private List<Category> list;
    private int pageNumber = 1; // Başlangıç sayfa numarası
    private int pageSize = 10; // Sayfa başına maksimum kayıt sayısı

    public CategoryBean() {
        entity = new Category();
    }

    public void create() {
        dao.create(entity);
        entity = new Category(); // Yeni bir Category nesnesi oluştur
        pageNumber = 1; // Sayfa numarasını sıfırla
        updateList(); // Listeyi güncelle
    }

    public void update() {
        dao.update(entity);
        entity = new Category();
        updateList(); // Listeyi güncelle
    }

    public void delete() {
        dao.delete(entity);
        entity = new Category(); // Silinen kategori için yeni bir Category nesnesi oluştur
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

    public Category getEntity() {
        return entity;
    }

    public void setEntity(Category entity) {
        this.entity = entity;
    }

    public List<Category> getList() {
        if (list == null) {
            updateList();
        }
        return list;
    }

    public void setList(List<Category> list) {
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
