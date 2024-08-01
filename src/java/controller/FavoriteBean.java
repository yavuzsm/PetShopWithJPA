package controller;

import dao.FavoriteDAO;
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
public class FavoriteBean implements Serializable {

    @EJB
    private FavoriteDAO favoriteDAO;

    private List<Favorite> favoriteList;

    public FavoriteBean() {
    }

    public void init() {
        loadFavoriteList();
    }

    public void loadFavoriteList() {
        favoriteList = favoriteDAO.findAll();
        System.out.println("Favori ürünler yüklendi: " + favoriteList);
    }

    public void removeFromFavorites(Favorite favorite) {
        favoriteDAO.delete(favorite);
        favoriteList.remove(favorite);
        FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("favoriteForm");
    }

    public void addToFavorites(Product product) {
        Favorite newFavorite = new Favorite(product);
        favoriteDAO.create(newFavorite);
        favoriteList.add(newFavorite);
        FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("favoriteForm");
    }

    public List<Favorite> getFavoriteList() {
        if (favoriteList == null) {
            loadFavoriteList();
        }
        return favoriteList;
    }

    public void setFavoriteList(List<Favorite> favoriteList) {
        this.favoriteList = favoriteList;
    }
}
