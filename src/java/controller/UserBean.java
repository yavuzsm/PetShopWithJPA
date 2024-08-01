package controller;

import dao.UserDAO;
import entity.User;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Named("userBean")
@SessionScoped
public class UserBean implements Serializable {

    private User entity;
    @EJB
    private UserDAO dao;
    private List<User> list;
    private String nameSurname;
    private String password;

    private static final Logger LOGGER = Logger.getLogger(UserBean.class.getName());

    public UserBean() {
        entity = new User();
    }

    public String login() {
        try {
            final MessageDigest digest = MessageDigest.getInstance("SHA3-256");
            final byte[] hashbytes = digest.digest(this.password.getBytes(StandardCharsets.UTF_8));
            String sha3Hex = bytesToHex(hashbytes);

            User u = dao.getLogin(nameSurname, sha3Hex); // Şifreyi hash olarak gönderiyoruz
            if (u != null) {
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("user", u);
                return "/panel/category/index?faces-redirect=true";
            }

        } catch (NoSuchAlgorithmException ex) {
            LOGGER.log(Level.SEVERE, "NoSuchAlgorithmException occurred", ex);
        }
        return "/login?faces-redirect=true";
    }

    private static String bytesToHex(byte[] hash) {
        StringBuilder hexString = new StringBuilder(2 * hash.length);
        for (int i = 0; i < hash.length; i++) {
            String hex = Integer.toHexString(0xff & hash[i]);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }

    public void create() {
        dao.create(entity);
        entity = new User();
        updateList();
    }

    public void update() {
        dao.update(entity);
        entity = new User();
        updateList();
    }

    public void delete() {
        dao.delete(entity);
        entity = new User();
        updateList();
    }

    private void updateList() {
        list = dao.findAll();
    }

    public User getEntity() {
        if (entity == null) {
            entity = new User();
        }
        return entity;
    }

    public void setEntity(User entity) {
        this.entity = entity;
    }

    public List<User> getList() {
        if (list == null) {
            list = dao.findAll();
        }
        return list;
    }

    public void setList(List<User> list) {
        this.list = list;
    }

    public String getNameSurname() {
        return nameSurname;
    }

    public void setNameSurname(String nameSurname) {
        this.nameSurname = nameSurname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}