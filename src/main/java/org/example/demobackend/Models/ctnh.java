package org.example.demobackend.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    private int dongianhap;
    private int thanhtien;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "mapnhap", insertable = false, updatable = false)
    private phieunhaphang phieunhaphang;

    public ctnh() {
    }

    public ctnh(int mapnhap, int mamh, int slnhap, int dongianhap, int thanhtien) {
        this.mapnhap = mapnhap;
        this.mamh = mamh;
        this.slnhap = slnhap;
        this.dongianhap = dongianhap;
        this.thanhtien = thanhtien;
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

    public int getSlnhap() {
        return slnhap;
    }

    public void setSlnhap(int slxuat) {
        this.slnhap = slxuat;
    }

    public int getDongianhap() {
        return dongianhap;
    }

    public void setDongianhap(mathang mh) {
        this.dongianhap = mh.getDongianhap();
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