package org.example.demobackend.Models;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class phieuxuathang {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "mapxuat")
    private int mapxuat;

    @Column(name = "ngaylp")
    private String ngaylp;

    @ManyToOne
    @JoinColumn(name = "madaily")
    private daily madaily;

    @Column(name = "tongtien")
    private int tongtien;

    @Column(name = "sotientra")
    private int sotientra;

    public phieuxuathang() {
    }

    public phieuxuathang(int mapxuat, String ngaylp, daily madaily, int tongtien, int sotientra) {
        this.mapxuat = mapxuat;
        this.ngaylp = ngaylp;
        this.madaily = madaily;
        this.tongtien = tongtien;
        this.sotientra = sotientra;
    }

    public int getMapxuat() {
        return mapxuat;
    }

    public void setMapxuat(int mapxuat) {
        this.mapxuat = mapxuat;
    }

    public String getNgaylp() {
        return ngaylp;
    }

    public void setNgaylp(String ngaylp) {
        this.ngaylp = ngaylp;
    }

    public daily getMadaily() {
        return madaily;
    }

    public void setMadaily(daily madaily) {
        this.madaily = madaily;
    }

    public int getTongtien() {
        return tongtien;
    }

    public void setTongtien(int tongtien) {
        this.tongtien = tongtien;
    }

    public int getSotientra() {
        return sotientra;
    }

    public void setSotientra(int sotientra) {
        this.sotientra = sotientra;
    }
}
