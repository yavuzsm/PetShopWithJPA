/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

/**
 *
 * @author Muhsin21
 */
@Entity
public class Animal extends AbstractEntity {

    private String hayvanTuru;
    private String cinsiyet;
    private int yas;
    private String fileName;
    private String filePath;
    private String fileType;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "owner_id")
    private Owner owner;

    public Animal() {
    }

    public Animal(String hayvanTuru, String cinsiyet, int yas, String fileName, String filePath, String fileType) {
        this.hayvanTuru = hayvanTuru;
        this.cinsiyet = cinsiyet;
        this.yas = yas;
        this.fileName = fileName;
        this.filePath = filePath;
        this.fileType = fileType;
    }

    // getters and setters
    public String getHayvanTuru() {
        return hayvanTuru;
    }

    public void setHayvanTuru(String hayvanTuru) {
        this.hayvanTuru = hayvanTuru;
    }

    public String getCinsiyet() {
        return cinsiyet;
    }

    public void setCinsiyet(String cinsiyet) {
        this.cinsiyet = cinsiyet;
    }

    public int getYas() {
        return yas;
    }

    public void setYas(int yas) {
        this.yas = yas;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }
}
