package com.example.demo.Models;

public class phieuxuathang {
    private int maPhieuXuat;
    private String ngayXuat;
    private int maDaiLy;
    private int tongTien;
    private int soTienTra;
    private int conLai;

    public phieuxuathang() {
        
    }
    public phieuxuathang(int maPhieuXuat, String ngayXuat, int maDaiLy, int tongTien, int soTienTra, int conLai) {
        this.maPhieuXuat = maPhieuXuat;
        this.ngayXuat = ngayXuat;
        this.maDaiLy = maDaiLy;
        this.tongTien = tongTien;
        this.soTienTra = soTienTra;
        this.conLai = conLai;
    }
}
