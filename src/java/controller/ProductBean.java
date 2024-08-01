package controller;

import dao.ProductDAO;
import dao.CategoryDAO;
import dao.FavoriteDAO;
import entity.Category;
import entity.Favorite;
import entity.Product;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class ProductBean implements Serializable {

    private Product entity;

    @EJB
    private ProductDAO dao;

    @EJB
    private CategoryDAO categoryDAO;

    @EJB
    private FavoriteDAO favoriteDAO;

    private List<Product> list;
    private List<Category> categories;
    private int pageNumber = 1;
    private int pageSize = 10;

    public ProductBean() {
        entity = new Product();
    }

    public void init() {
        categories = categoryDAO.getAllCategories();
        updateList();
    }

    public void create() {
        dao.create(entity);
        entity = new Product();
        updateList();
    }

    public void update() {
        dao.update(entity);
        entity = new Product();
        updateList();
    }

    public void delete() {
        dao.delete(entity);
        entity = new Product();
        pageNumber = 1;
        updateList();
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

    public void addToFavorites(Long productId) {
        Product product = dao.findById(productId);
        if (product != null) {
            Favorite favorite = new Favorite(product);
            favoriteDAO.create(favorite);
            System.out.println("Ürün favorilere eklendi: " + productId);
            FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("productForm");
        }
    }

    private void updateList() {
        list = dao.findCategoriesWithPagination(pageNumber, pageSize);
        categories = categoryDAO.getAllCategories();
    }

    public Product getEntity() {
        return entity;
    }

    public void setEntity(Product entity) {
        this.entity = entity;
    }

    public List<Product> getList() {
        if (list == null) {
            updateList();
        }
        return list;
    }

    public void setList(List<Product> list) {
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

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
    
}
