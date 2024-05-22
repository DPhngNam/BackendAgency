package org.example.demobackend.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.io.Serializable;

@Embeddable
public class baocaocongnoID implements Serializable {
    @Column(name = "thang")
    private String thang;
    @Column(name = "nam")
    private String nam;
    @ManyToOne
    @JoinColumn(name = "madaily")
    private daily madaily;


    public baocaocongnoID() {
    }

    public baocaocongnoID(String thang, String nam, daily madaily) {
        this.thang = thang;
        this.nam = nam;
        this.madaily = madaily;
    }

    public String getThang() {
        return thang;
    }

    public void setThang(String thang) {
        this.thang = thang;
    }

    public String getNam() {
        return nam;
    }

    public void setNam(String nam) {
        this.nam = nam;
    }

    public daily getMadaily() {
        return madaily;
    }

    public void setMadaily(daily madaily) {
        this.madaily = madaily;
    }
}
