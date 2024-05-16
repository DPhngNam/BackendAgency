package org.example.demobackend.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@IdClass(ctxh.CtxhId.class)
public class ctxh {
    @Id
    @Column(name = "mapxuat")
    private int mapxuat;

    @Id
    @Column(name = "mamh")
    private int mamh;

    @Column(name = "slxuat")
    private int slxuat;

    @Column(name = "dongiaxuat")
    private int dongiaxuat;

    @Column(name = "thanhtien")
    private int thanhtien;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "mapxuat", insertable = false, updatable = false)
    private phieuxuathang phieuxuathang;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "mamh", insertable = false, updatable = false)
    private mathang mathang;

    public ctxh() {
    }

    public ctxh(int mamh, int slxuat, int dongiaxuat, int thanhtien) {
        this.mamh = mamh;
        this.slxuat = slxuat;
        this.dongiaxuat = dongiaxuat;
        this.thanhtien = thanhtien;
    }

    public int getMapxuat() {
        return mapxuat;
    }

    public void setMapxuat(int mapxuat) {
        this.mapxuat = mapxuat;
    }

    public int getMamh() {
        return mamh;
    }

    public void setMamh(int mamh) {
        this.mamh = mamh;
    }

    public int getSlxuat() {
        return slxuat;
    }

    public void setSlxuat(int slxuat) {
        this.slxuat = slxuat;
    }

    public int getDongiaxuat() {
        return dongiaxuat;
    }

    public void setDongiaxuat(mathang mh) {
        this.dongiaxuat = mh.getDongiaxuat();
    }

    public int getThanhtien() {
        return this.slxuat * this.dongiaxuat;
    }

    public void setThanhtien(int thanhtien) {
        this.thanhtien = thanhtien;
    }

    public phieuxuathang getPhieuxuathang() {
        return phieuxuathang;
    }

    public void setPhieuxuathang(phieuxuathang phieuxuathang) {
        this.phieuxuathang = phieuxuathang;
    }

    public static class CtxhId implements Serializable {
        private int mapxuat;
        private int mamh;

        public CtxhId() {
        }

        public int getMapxuat() {
            return mapxuat;
        }

        public void setMapxuat(int mapxuat) {
            this.mapxuat = mapxuat;
        }

        public int getMamh() {
            return mamh;
        }

        public void setMamh(int mamh) {
            this.mamh = mamh;
        }
    }
}