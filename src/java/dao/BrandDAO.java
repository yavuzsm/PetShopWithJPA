package dao;

import entity.Brand;
import jakarta.ejb.Local;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.List;

@Local
@Stateless
public class BrandDAO extends AbstractDAO<Brand> implements Serializable {

    @PersistenceContext(unitName = "JSFPetshopKatalogPU")
    private EntityManager em;

    public BrandDAO() {
        super(Brand.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public List<Brand> findCategoriesWithPagination(int pageNumber, int pageSize) {
        int firstResult = (pageNumber - 1) * pageSize;
        return findRange(firstResult, pageSize);
    }

    public int getCategoryCount() {
        return count();
    }
}