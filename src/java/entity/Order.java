/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.util.Date;

/**
 *
 * @author tolut
 */
public class Order {
    private long id;
    private Date tarih;
    private String musteriIsmi;
    private int miktar;
    private float fiyat;
    private float toplamTutar;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getTarih() {
        return tarih;
    }

    public void setTarih(Date tarih) {
        this.tarih = tarih;
    }

    public String getMusteriIsmi() {
        return musteriIsmi;
    }

    public void setMusteriIsmi(String musteriIsmi) {
        this.musteriIsmi = musteriIsmi;
    }

    public int getMiktar() {
        return miktar;
    }

    public void setMiktar(int miktar) {
        this.miktar = miktar;
    }

    public float getFiyat() {
        return fiyat;
    }

    public void setFiyat(float fiyat) {
        this.fiyat = fiyat;
    }

    public float getToplamTutar() {
        return toplamTutar;
    }

    public void setToplamTutar(float toplamTutar) {
        this.toplamTutar = toplamTutar;
    }

    public Order(long id, Date tarih, String musteriIsmi, int miktar, float fiyat, float toplamTutar) {
        this.id = id;
        this.tarih = tarih;
        this.musteriIsmi = musteriIsmi;
        this.miktar = miktar;
        this.fiyat = fiyat;
        this.toplamTutar = toplamTutar;
    }

    public Order() {
    }
    
    
  

    
            
    
}
