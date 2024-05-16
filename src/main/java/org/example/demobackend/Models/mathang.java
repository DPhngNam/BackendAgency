package org.example.demobackend.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class mathang {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int mamh;
    private String tenmh;
    private int madvt;
    private int dongianhap;
    private int dongiaxuat;
    private int slton;

    public mathang() {

    }

    public mathang(String tenmh, int madvt, int dongianhap, int dongiaxuat, int slton) {
        this.tenmh = tenmh;
        this.madvt = madvt;
        this.dongianhap = dongianhap;
        this.dongiaxuat = dongiaxuat;
        this.slton = slton;
    }

    public int getMamh() {
        return mamh;
    }

    public void setMamh(int mamh) {
        this.mamh = mamh;
    }

    public String getTenmh() {
        return tenmh;
    }

    public void setTenmh(String tenmh) {
        this.tenmh = tenmh;
    }

    public int getMadvt() {
        return madvt;
    }

    public void setMadvt(int madvt) {
        this.madvt = madvt;
    }

    public int getDongianhap() {
        return dongianhap;
    }

    public void setDongianhap(int dongianhap) {
        this.dongianhap = dongianhap;
    }

    public int getDongiaxuat() {
        return dongiaxuat;
    }

    public void setDongiaxuat(int dongiaxuat) {
        this.dongiaxuat = dongiaxuat;
    }

    public int getSlton() {
        return slton;
    }

    public void setSlton(int slton) {
        this.slton = slton;
    }
}
