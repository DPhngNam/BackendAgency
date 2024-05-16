package org.example.demobackend.Models;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class phieuxuathang {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int mapxuat;
    private String ngaylp;
    private int madaily;
    private int tongtien;
    private int sotientra;

    public phieuxuathang() {
        
    }
    public phieuxuathang(String ngaylp, int madaily, int tongtien, int sotientra){
        this.ngaylp = ngaylp;
        this.madaily = madaily;
        this.tongtien = tongtien;
        this.sotientra = sotientra;
    }

    @OneToMany(mappedBy = "phieuxuathang", cascade = CascadeType.ALL)
    private List<ctxh> ctxhList = new ArrayList<>();

    public void addCtxh(ctxh ctxh) {
        ctxhList.add(ctxh);
        ctxh.setPhieuxuathang(this);
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

    public int getMadaily() {
        return madaily;
    }

    public void setMadaily(int madaily) {
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
