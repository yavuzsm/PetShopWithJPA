package dao;

import entity.Category;
import jakarta.ejb.Local;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.List;

@Local
@Stateless
public class CategoryDAO extends AbstractDAO<Category> implements Serializable {

    @PersistenceContext(unitName = "JSFPetshopKatalogPU")
    private EntityManager em;

    public CategoryDAO() {
        super(Category.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public Category getCategoryById(Long id) {
        return find(id);
    }

    public List<Category> findCategoriesWithPagination(int pageNumber, int pageSize) {
        int firstResult = (pageNumber - 1) * pageSize;
        return findRange(firstResult, pageSize);
    }

    public int getCategoryCount() {
        return count();
    }
     public List<Category> getAllCategories() {
        return findAll();
    }
}