package org.example.demobackend.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.io.Serializable;

@Entity
@IdClass(ctbcds.ctbcdsId.class)
public class ctbcds {
    @Id
    private int madaily;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "madaily", insertable = false, updatable = false)
    private daily daily;

    @Id
    private int mabaocaods;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "mabaocaods", insertable = false, updatable = false)
    private baocaodoanhso baocaodoanhso;

    private int sophieuxuat;
    private int tongtrigia;
    private double tyle;

    public ctbcds() {
    }

    public ctbcds(int madaily, int mabaocaods, int sophieuxuat, int tongtrigia, double tyle) {
        this.madaily = madaily;
        this.mabaocaods = mabaocaods;
        this.sophieuxuat = sophieuxuat;
        this.tongtrigia = tongtrigia;
        this.tyle = tyle;
    }

    public int getMadaily() {
        return madaily;
    }

    public void setMadaily(int madaily) {
        this.madaily = madaily;
    }

    public daily getDaily() {
        return daily;
    }

    public void setDaily(daily dl) {
        this.daily = dl;
    }

    public int getMabaocaods() {
        return mabaocaods;
    }

    public void setMabaocaods(int mabaocaods) {
        this.mabaocaods = mabaocaods;
    }

    public baocaodoanhso getBaocaodoanhso() {
        return baocaodoanhso;
    }

    public void setBaocaodoanhso(baocaodoanhso bcds) {
        this.baocaodoanhso = bcds;
    }

    public int getSophieuxuat() {
        return sophieuxuat;
    }

    public void setSophieuxuat(int sophieuxuat) {
        this.sophieuxuat = sophieuxuat;
    }

    public int getTongtrigia() {
        return tongtrigia;
    }

    public void setTongtrigia(int tongtrigia) {
        this.tongtrigia = tongtrigia;
    }

    public double getTyle() {
        return tyle;
    }

    public void setTyle(double tyle) {
        this.tyle = tyle;
    }

    public static class ctbcdsId implements Serializable {
        private int madaily;
        private int mabaocaods;

        public ctbcdsId() {
        }

        public int getMadaily() {
            return madaily;
        }

        public void setMadaily(int madaily) {
            this.madaily = madaily;
        }

        public int getMabaocaods() {
            return mabaocaods;
        }

        public void setMabaocaods(int mabaocaods) {
            this.mabaocaods = mabaocaods;
        }
    }
}