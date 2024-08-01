package dao;

import entity.User;
import jakarta.ejb.Local;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import java.io.Serializable;
import java.util.List;

@Local
@Stateless
public class UserDAO extends AbstractDAO<User> implements Serializable {

    @PersistenceContext(unitName = "JSFPetshopKatalogPU")
    private EntityManager em;

    public UserDAO() {
        super(User.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    public User getLogin(String nameSurname, String pass) {
        TypedQuery<User> q = em.createQuery("SELECT u FROM User u WHERE u.nameSurname = :nameSurname AND u.password = :pass", User.class);
        q.setParameter("nameSurname", nameSurname);
        q.setParameter("pass", pass);
        List<User> results = q.getResultList();
        return results.isEmpty() ? null : results.get(0);
    }
}