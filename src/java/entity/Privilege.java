/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import jakarta.persistence.Entity;

/**
 *
 * @author Administrator
 */
@Entity
public class Privilege extends AbstractEntity {

    private boolean c;
    private boolean r;
    private boolean u;
    private boolean d;
    private boolean mv;
    private boolean iv;

    public boolean isC() {
        return c;
    }

    public void setC(boolean c) {
        this.c = c;
    }

    public boolean isR() {
        return r;
    }

    public void setR(boolean r) {
        this.r = r;
    }

    public boolean isU() {
        return u;
    }

    public void setU(boolean u) {
        this.u = u;
    }

    public boolean isD() {
        return d;
    }

    public void setD(boolean d) {
        this.d = d;
    }

    public boolean isMv() {
        return mv;
    }

    public void setMv(boolean mv) {
        this.mv = mv;
    }

    public boolean isIv() {
        return iv;
    }

    public void setIv(boolean iv) {
        this.iv = iv;
    }

}
