// AnimalDAO.java
package dao;

import entity.Animal;
import entity.Owner;
import jakarta.ejb.Local;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.List;

@Local
@Stateless
public class AnimalDAO extends AbstractDAO<Animal> implements Serializable {

    @PersistenceContext(unitName = "JSFPetshopKatalogPU")
    private EntityManager em;

    public AnimalDAO() {
        super(Animal.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public List<Animal> findCategoriesWithPagination(int pageNumber, int pageSize) {
        int firstResult = (pageNumber - 1) * pageSize;
        return findRange(firstResult, pageSize);
    }

    public int getCategoryCount() {
        return count();
    }
    public Owner findOwnerById(Long id) {
        return em.find(Owner.class, id);
    }
}