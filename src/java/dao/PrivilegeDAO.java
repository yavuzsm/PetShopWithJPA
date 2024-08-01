package dao;

import entity.Privilege;
import jakarta.ejb.Local;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.io.Serializable;

@Local
@Stateless
public class PrivilegeDAO extends AbstractDAO<Privilege> implements Serializable {

    @PersistenceContext(unitName = "JSFPetshopKatalogPU")
    private EntityManager em;

    public PrivilegeDAO() {
        super(Privilege.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
}