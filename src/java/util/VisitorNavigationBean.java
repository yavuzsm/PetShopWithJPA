/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Administrator
 */
@Named(value = "vnb")
@ViewScoped
public class VisitorNavigationBean implements Serializable {

    private Map<String, String> pages;

    public VisitorNavigationBean() {
        pages = new HashMap<>();
    }

    public String module(String page) {
        pages.clear(); // Tüm sayfaları temizle
        this.pages.put(page, "active"); // Yalnızca seçilen sayfayı aktif yap
        return "/visitorPanel/module/" + page + "/index?faces-redirect=true";
    }

    public Map<String, String> getPages() {
        return pages;
    }

}
