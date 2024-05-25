package org.example.demobackend.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.io.Serializable;

@Embeddable
public class baocaocongnoID implements Serializable {
    @Column(name = "thang")
    private int thang;
    @Column(name = "nam")
    private int nam;
    @ManyToOne
    @JoinColumn(name = "madaily")
    private daily madaily;


    public baocaocongnoID() {
    }

    public baocaocongnoID(int thang, int nam, daily madaily) {
        this.thang = thang;
        this.nam = nam;
        this.madaily = madaily;
    }

    public int getThang() {
        return thang;
    }

    public int getNam() {
        return nam;
    }

    public daily getMadaily() {
        return madaily;
    }
}
