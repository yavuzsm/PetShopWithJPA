package dao;

import entity.Product;
import jakarta.ejb.Local;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.List;

@Local
@Stateless
public class ProductDAO extends AbstractDAO<Product> implements Serializable {

    @PersistenceContext(unitName = "JSFPetshopKatalogPU")
    private EntityManager em;

    public ProductDAO() {
        super(Product.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public List<Product> findCategoriesWithPagination(int pageNumber, int pageSize) {
        int firstResult = (pageNumber - 1) * pageSize;
        return findRange(firstResult, pageSize);
    }

    public int getCategoryCount() {
        return count();
    }
}