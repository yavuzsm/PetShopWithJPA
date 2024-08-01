package dao;

import entity.Favorite;
import entity.Product;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class FavoriteDAO extends AbstractDAO<Favorite> {

    public FavoriteDAO() {
        super(Favorite.class);
    }

    @PersistenceContext
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public Favorite findByProduct(Product product) {
        try {
            return em.createQuery("SELECT f FROM Favorite f WHERE f.product = :product", Favorite.class)
                     .setParameter("product", product)
                     .getSingleResult();
        } catch (Exception e) {
            return null; // Ürün favorilerde bulunamadıysa null döner
        }
    }

    public List<Product> findAllProducts() {
        return em.createQuery("SELECT f.product FROM Favorite f", Product.class)
                 .getResultList();
    }
}
