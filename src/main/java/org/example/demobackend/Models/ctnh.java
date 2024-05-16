package org.example.demobackend.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@IdClass(ctnh.CtnhId.class)
public class ctnh {
    @Id
    @ManyToOne
    @JoinColumn(name = "mapnhap")
    private phieunhaphang mapnhap;

    @Id
    @ManyToOne
    @JoinColumn(name = "mamh")
    private mathang mamh;

    @Column(name = "slnhap")
    private int slnhap;

    @Column(name = "dongianhap")
    private int dongianhap;

    @Column(name = "thanhtien")
    private int thanhtien;

    @ManyToOne
    @JoinColumn(name = "dvt")
    private dvt dvt;

    public ctnh() {
    }

    public ctnh(phieunhaphang mapnhap, mathang mamh, int slnhap, int dongianhap, int thanhtien, dvt dvt) {
        this.mapnhap = mapnhap;
        this.mamh = mamh;
        this.slnhap = slnhap;
        this.dongianhap = dongianhap;
        this.thanhtien = thanhtien;
        this.dvt = dvt;
    }

    public phieunhaphang getMapnhap() {
        return mapnhap;
    }

    public void setMapnhap(phieunhaphang mapnhap) {
        this.mapnhap = mapnhap;
    }

    public mathang getMamh() {
        return mamh;
    }

    public void setMamh(mathang mamh) {
        this.mamh = mamh;
    }

    public int getSlnhap() {
        return slnhap;
    }

    public void setSlnhap(int slnhap) {
        this.slnhap = slnhap;
    }

    public int getDongianhap() {
        return dongianhap;
    }

    public void setDongianhap(int dongianhap) {
        this.dongianhap = dongianhap;
    }

    public int getThanhtien() {
        return thanhtien;
    }

    public void setThanhtien(int thanhtien) {
        this.thanhtien = thanhtien;
    }

    public dvt getDvt() {
        return dvt;
    }

    public void setDvt(dvt dvt) {
        this.dvt = dvt;
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