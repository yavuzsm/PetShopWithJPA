package entity;

import jakarta.persistence.Entity;


@Entity
public class Brand extends AbstractEntity {

    private String markaIsmi;

    public String getMarkaIsmi() {
        return markaIsmi;
    }

    public void setMarkaIsmi(String markaIsmi) {
        this.markaIsmi = markaIsmi;
    }

    

  
}