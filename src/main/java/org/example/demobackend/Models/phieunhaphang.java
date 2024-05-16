package org.example.demobackend.Models;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class phieunhaphang {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "mapnhap")
    private int mapnhap;

    @Column(name = "ngaylp")
    private String ngaylp;

    @Column(name = "tongtien")
    private int tongtien;

    public phieunhaphang() {
    }

    public phieunhaphang(String ngaynhap, int tongtien) {
        this.ngaylp = ngaynhap;
        this.tongtien = tongtien;
    }

    public int getMapnhap() {
        return mapnhap;
    }

    public void setMapnhap(int mapnhap) {
        this.mapnhap = mapnhap;
    }

    public String getNgaylp() {
        return ngaylp;
    }

    public void setNgaylp(String ngaylp) {
        this.ngaylp = ngaylp;
    }

    public int getTongtien() {
        return tongtien;
    }

    public void setTongtien(int tongtien) {
        this.tongtien = tongtien;
    }
}