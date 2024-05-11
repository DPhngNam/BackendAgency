package com.example.demo.Models;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class phieuxuathang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int maphieuxuat;
    private String ngaylp;
    private int madaily;
    private int tongtien;
    private int sotientra;
    private int conlai;

    public phieuxuathang() {
        
    }
    public phieuxuathang(String ngaylp, int madaily, int tongtien, int sotientra, int conlai){
        this.ngaylp = ngaylp;
        this.madaily = madaily;
        this.tongtien = tongtien;
        this.sotientra = sotientra;
        this.conlai = conlai;
    }

    @OneToMany(mappedBy = "phieuxuathang", cascade = CascadeType.ALL)
    private List<ctxh> ctxhList = new ArrayList<>();

    public void addCtxh(ctxh ctxh) {
        ctxhList.add(ctxh);
        ctxh.setPhieuxuathang(this);
    }

    public int getMaphieuxuat() {
        return maphieuxuat;
    }

    public void setMaphieuxuat(int maphieuxuat) {
        this.maphieuxuat = maphieuxuat;
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

    public int getConlai() {
        return conlai;
    }

    public void setConlai(int conlai) {
        this.conlai = conlai;
    }
}
