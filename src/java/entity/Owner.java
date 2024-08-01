/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Muhsin21
 */
@Entity
public class Owner extends AbstractEntity {

    private String isim;
    private String soyisim;
    private String telefonNumarasi;
    private String eMail;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
    private Set<Animal> animals = new HashSet<>();

    public Owner() {
    }

    public Owner(String isim, String soyisim, String telefonNumarasi, String eMail) {
        this.isim = isim;
        this.soyisim = soyisim;
        this.telefonNumarasi = telefonNumarasi;
        this.eMail = eMail;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public String getSoyisim() {
        return soyisim;
    }

    public void setSoyisim(String soyisim) {
        this.soyisim = soyisim;
    }

    public String getTelefonNumarasi() {
        return telefonNumarasi;
    }

    public void setTelefonNumarasi(String telefonNumarasi) {
        this.telefonNumarasi = telefonNumarasi;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public Set<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(Set<Animal> animals) {
        this.animals = animals;
    }

    public void addAnimal(Animal animal) {
        animals.add(animal);
        animal.setOwner(this);
    }

    public void removeAnimal(Animal animal) {
        animals.remove(animal);
        animal.setOwner(null);
    }
}
