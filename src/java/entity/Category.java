package entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
public class Category extends AbstractEntity {

    private String kategoriIsmi;

    
    @ManyToMany(mappedBy = "categories")
    private List<Product> products;

    public String getKategoriIsmi() {
        return kategoriIsmi;
    }

    public void setKategoriIsmi(String kategoriIsmi) {
        this.kategoriIsmi = kategoriIsmi;
    }
    
  public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

   
    

    @Override
    public String toString() {
        return "Category{" +
                "id=" + getId() +
                ", kategoriIsmi='" + kategoriIsmi + '\'' +
                '}';
    }
}
