package org.example.demobackend.Models;

import jakarta.persistence.*;

@Entity
public class mathang {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "mamh")
    private int mamh;

    @Column(name = "tenmh", columnDefinition = "NVARCHAR(255)", nullable = false)
    private String tenmh;
    @ManyToOne
    @JoinColumn(name = "dvt", nullable = false)
    private dvt dvt;
    @Column(name = "dongianhap", nullable = false)
    private int dongianhap;


    @Column(name = "dongiaxuat")
    private int dongiaxuat;
    @Column(name = "slton")
    private int slton;

    public mathang(int mamh,int dongianhap){
        this.mamh = mamh;
        this.dongianhap = dongianhap;
    }
    public mathang(String tenmh, dvt dvt, int dongianhap) {
        this.tenmh = tenmh;
        this.dvt = dvt;
        this.dongianhap = dongianhap;
    }

    public mathang() {

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

    public dvt getDvt() {
        return dvt;
    }

    public void setDvt(org.example.demobackend.Models.dvt dvt) {
        this.dvt = dvt;
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
