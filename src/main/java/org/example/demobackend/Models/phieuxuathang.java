package org.example.demobackend.Models;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import java.sql.Date;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class phieuxuathang {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "mapxuat")
    private int mapxuat;


    @Column(name = "ngaylp",nullable = false)
    private Date ngaylp;

    @ManyToOne
    @JoinColumn(name = "madaily",nullable = false)
    private daily madaily;

    @Column(name = "tongtien")
    private int tongtien;

    @Column(name = "sotientra")
    private int sotientra;

    @Column(name = "conlai")
    private int conlai;

    public phieuxuathang() {
    }

    public phieuxuathang(int mapxuat) {
        this.mapxuat = mapxuat;
    }

    public phieuxuathang(daily madaily, int tongtien, int sotientra, int conlai) {
        this.madaily = madaily;
        this.tongtien = tongtien;
        this.sotientra = sotientra;
        this.conlai = conlai;
    }

    public int getMapxuat() {
        return mapxuat;
    }

    public void setMapxuat(int mapxuat) {
        this.mapxuat = mapxuat;
    }

    public Date getNgaylp() {
        return ngaylp;
    }

    public void setNgaylp(Date ngaylp) {
        this.ngaylp = ngaylp;
    }

    public daily getMadaily() {
        return madaily;
    }

    public void setMadaily(daily madaily) {
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
