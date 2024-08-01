// AbstractDAO.java
package dao;

import jakarta.ejb.Local;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

@Local
@Stateless
public abstract class AbstractDAO<T> implements Serializable {

    private Class<T> entityClass;

    public AbstractDAO() {
    }

    public AbstractDAO(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    public void create(T entity) {
        getEntityManager().persist(entity);
    }

    public void update(T entity) {
        getEntityManager().merge(entity);
    }

    public void delete(T entity) {
        getEntityManager().remove(getEntityManager().merge(entity));
    }

    public T find(Object id) {
        return getEntityManager().find(entityClass, id);
    }

    public List<T> findAll() {
        return getEntityManager().createQuery("SELECT e FROM " + entityClass.getSimpleName() + " e", entityClass).getResultList();
    }

    public List<T> findRange(int firstResult, int maxResults) {
        return getEntityManager()
                .createQuery("SELECT e FROM " + entityClass.getSimpleName() + " e", entityClass)
                .setFirstResult(firstResult)
                .setMaxResults(maxResults)
                .getResultList();
    }

    public int count() {
        return ((Long) getEntityManager()
                .createQuery("SELECT COUNT(e) FROM " + entityClass.getSimpleName() + " e")
                .getSingleResult())
                .intValue();
    }
    
    public T findById(Object id) {
        return getEntityManager().find(entityClass, id);
    }

    protected abstract EntityManager getEntityManager();
}
