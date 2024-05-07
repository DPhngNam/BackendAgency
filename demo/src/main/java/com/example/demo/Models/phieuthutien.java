package com.example.demo.Models;

public class phieuthutien {
    private int maPhieuThu;
    private String ngayThuTien;
    private int soTienThu;
    private int maDaiLy;

    public phieuthutien() {
    }
    public phieuthutien(int maPhieuThu, String ngayThuTien, int soTienThu, int maDaiLy) {
        this.maPhieuThu = maPhieuThu;
        this.ngayThuTien = ngayThuTien;
        this.soTienThu = soTienThu;
        this.maDaiLy = maDaiLy;
    }
}
