package org.example.demobackend.Models;

import jakarta.persistence.*;

@Entity
public class baocaocongno {


    @EmbeddedId
    private baocaocongnoID baocaocongnoID;

    @Column(name = "noDau")
    private String noDau;
    @Column(name = "noCuoi")
    private String noCuoi;
    @Column(name = "phatSinh")
    private String phatSinh;


    public baocaocongno() {

    }

    public baocaocongno(baocaocongnoID baocaocongnoID, String noDau, String noCuoi, String phatSinh) {
        this.baocaocongnoID = baocaocongnoID;
        this.noDau = noDau;
        this.noCuoi = noCuoi;
        this.phatSinh = phatSinh;
    }

    public org.example.demobackend.Models.baocaocongnoID getBaocaocongnoID() {
        return baocaocongnoID;
    }

    public void setBaocaocongnoID(org.example.demobackend.Models.baocaocongnoID baocaocongnoID) {
        this.baocaocongnoID = baocaocongnoID;
    }

    public String getNoDau() {
        return noDau;
    }

    public void setNoDau(String noDau) {
        this.noDau = noDau;
    }

    public String getNoCuoi() {
        return noCuoi;
    }

    public void setNoCuoi(String noCuoi) {
        this.noCuoi = noCuoi;
    }

    public String getPhatSinh() {
        return phatSinh;
    }

    public void setPhatSinh(String phatSinh) {
        this.phatSinh = phatSinh;
    }
}
