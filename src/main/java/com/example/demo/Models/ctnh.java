package com.example.demo.Models;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@IdClass(ctnh.CtnhId.class)
public class ctnh {
    @Id
    private int mapnhap;
    @Id
    private int mamh;
    private int slnhap;
    private int thanhtien;
    private int dongianhap;

    @ManyToOne
    @JoinColumn(name = "mapnhap", insertable = false, updatable = false)
    private phieunhaphang phieunhaphang;

    public int getMapnhap() {
        return mapnhap;
    }

    public void setMapnhap(int mapnhap) {
        this.mapnhap = mapnhap;
    }

    public int getMamh() {
        return mamh;
    }

    public void setMamh(int mamh) {
        this.mamh = mamh;
    }

    public int getSlnhap() {
        return slnhap;
    }

    public void setSlnhap(int slxuat) {
        this.slnhap = slxuat;
    }

    public int getThanhtien() {
        return thanhtien;
    }

    public void setThanhtien(int thanhtien) {
        this.thanhtien = thanhtien;
    }

    public phieunhaphang getPhieunhaphang() {
        return phieunhaphang;
    }

    public void setPhieunhaphang(phieunhaphang phieunhaphang) {
        this.phieunhaphang = phieunhaphang;
    }

    public int getDongianhap(mathang mh) {
        return mh.getDongianhap();
    }

    public void setDongianhap(mathang mh) {
        this.dongianhap = mh.getDongianhap();
    }

    public static class CtnhId implements Serializable {
        private int mapnhap;
        private int mamh;

        public CtnhId() {
        }

        public int getMapnhap() {
            return mapnhap;
        }

        public void setMapnhap(int mapnhap) {
            this.mapnhap = mapnhap;
        }

        public int getMamh() {
            return mamh;
        }

        public void setMamh(int mamh) {
            this.mamh = mamh;
        }
    }
}