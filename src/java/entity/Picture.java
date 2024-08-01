/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author Yavuz Selim
 */
public class Picture {
    private long id;
    private String ad;
    private String resimTuru;
    private String resimYolu;

    public Picture(long id, String ad, String resimTuru, String resimYolu) {
        this.id = id;
        this.ad = ad;
        this.resimTuru = resimTuru;
        this.resimYolu = resimYolu;
    }

    public Picture() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getResimTuru() {
        return resimTuru;
    }

    public void setResimTuru(String resimTuru) {
        this.resimTuru = resimTuru;
    }

    public String getResimYolu() {
        return resimYolu;
    }

    public void setResimYolu(String resimYolu) {
        this.resimYolu = resimYolu;
    }
    

    
    
}
