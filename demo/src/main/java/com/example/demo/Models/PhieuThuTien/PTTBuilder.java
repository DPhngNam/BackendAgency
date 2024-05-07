package com.example.demo.Models.PhieuThuTien;

import com.example.demo.Models.phieuthutien;

public interface PTTBuilder {
    PTTBuilder setMaPhieuThu(int maPhieuThu);
    PTTBuilder setNgayThuTien(String ngayThuTien);
    PTTBuilder setSoTienThu(int soTienThu);
    PTTBuilder setMaDaiLy(int maDaiLy);
    phieuthutien build();
}
