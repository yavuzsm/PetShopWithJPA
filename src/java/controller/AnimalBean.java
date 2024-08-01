package controller;

import dao.AnimalDAO;
import entity.Animal;
import entity.Owner;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import util.Connector;
import java.sql.Connection;

@Named(value = "animalBean")
@SessionScoped
public class AnimalBean implements Serializable {

    private Animal entity;
    @EJB
    private AnimalDAO dao;
    private List<Animal> list;
    private int pageNumber = 1; // Başlangıç sayfa numarası
    private int pageSize = 10; // Sayfa başına maksimum kayıt sayısı

    private Connector connector;// Veritabanı bağlantısını yönetmek için 
    private Connection connection;

    private Long ownerId; // Owner'ın ID'si

    private Part doc;//HTTP isteği içindeki dosya yüklemelerini temsil eder.

    public AnimalBean() {
        entity = new Animal();
    }
    private final String uploadTo = "C:\\upload\\";//Yüklenen dosyaların saklanacağı dizin yolunu belirtir.

    public String getUploadTo() {
        return uploadTo;
    }

    public void upload() {//kullanıcı tarafından yüklenen dosyayı işler
        try {
            InputStream input = doc.getInputStream();
            File file = new File("C:\\upload\\" + doc.getSubmittedFileName());
            Files.copy(input, file.toPath());

            entity.setHayvanTuru(entity.getHayvanTuru());
            entity.setCinsiyet(entity.getCinsiyet());
            entity.setYas(entity.getYas());

            Owner owner = dao.findOwnerById(ownerId);
            entity.setOwner(owner);

            entity.setFilePath(file.getParent());
            entity.setFileName(file.getName());
            entity.setFileType(doc.getContentType());
            dao.create(entity);

            FacesMessage message = new FacesMessage("Dosya başarıyla yüklendi!");
            FacesContext.getCurrentInstance().addMessage(null, message);

            updateList();
            entity = new Animal(); // Yeni bir Animal nesnesi oluştur

        } catch (IOException e) {
            FacesMessage message = new FacesMessage("Dosya yüklenirken hata oluştu!");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }

    public void create() {
        dao.create(entity);
        entity = new Animal(); // Yeni bir Animal nesnesi oluştur
        int totalItems = dao.getCategoryCount();
        int lastPageNumber = (totalItems - 1) / pageSize + 1;

        if (pageNumber > lastPageNumber) {
            pageNumber = lastPageNumber;
        }

        updateList(); // Listeyi güncelle

    }

    public void update() {
        dao.update(entity);
        entity = new Animal();
        updateList(); // Listeyi güncelle
    }

    public void delete(Animal animal) {
        dao.delete(animal);
        entity = new Animal(); // Silinen kategori için yeni bir Animal nesnesi oluştur
        pageNumber = 1; // Sayfa numarasını sıfırla
        updateList(); // Listeyi güncelle
    }

    public void nextPage() {
        pageNumber++;
        updateList();
    }

    public void previousPage() {
        if (pageNumber > 1) {
            pageNumber--;
            updateList();
        }
    }

    private void updateList() {
        list = dao.findCategoriesWithPagination(pageNumber, pageSize);
    }

    public Animal getEntity() {
        if (entity == null) {
            entity = new Animal();
        }
        return entity;
    }

    public void setEntity(Animal entity) {
        this.entity = entity;
    }

    public List<Animal> getList() {
        if (list == null) {
            list = dao.findAll();
        }
        return list;
    }

    public void setList(List<Animal> list) {
        this.list = list;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public Connector getConnector() {
        if (this.connector == null) {
            this.connector = new Connector();
        }
        return connector;
    }

    public void setConnector(Connector connector) {
        this.connector = connector;
    }

    public Connection getConnection() {
        if (this.connection == null) {
            this.connection = this.getConnector().connect();

        }
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public Part getDoc() {
        return doc;
    }

    public void setDoc(Part doc) {
        this.doc = doc;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }
}
