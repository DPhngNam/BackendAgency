package com.example.demo.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class phieuxuathang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int maPhieuXuat;

    private String ngayXuat;
    private int maDaiLy;
    private int tongTien;
    private int soTienTra;
    private int conLai;

    public phieuxuathang() {
        
    }
    public phieuxuathang(String ngayXuat, int maDaiLy, int tongTien, int soTienTra, int conLai) {
        this.ngayXuat = ngayXuat;
        this.maDaiLy = maDaiLy;
        this.tongTien = tongTien;
        this.soTienTra = soTienTra;
        this.conLai = conLai;
    }

    public int getMaPhieuXuat() {
        return maPhieuXuat;
    }

    public void setMaPhieuXuat(int maPhieuXuat) {
        this.maPhieuXuat = maPhieuXuat;
    }

    public String getNgayXuat() {
        return ngayXuat;
    }

    public void setNgayXuat(String ngayXuat) {
        this.ngayXuat = ngayXuat;
    }

    public int getMaDaiLy() {
        return maDaiLy;
    }

    public void setMaDaiLy(int maDaiLy) {
        this.maDaiLy = maDaiLy;
    }

    public int getTongTien() {
        return tongTien;
    }

    public void setTongTien(int tongTien) {
        this.tongTien = tongTien;
    }

    public int getSoTienTra() {
        return soTienTra;
    }

    public void setSoTienTra(int soTienTra) {
        this.soTienTra = soTienTra;
    }

    public int getConLai() {
        return conLai;
    }

    public void setConLai(int conLai) {
        this.conLai = conLai;
    }
}
