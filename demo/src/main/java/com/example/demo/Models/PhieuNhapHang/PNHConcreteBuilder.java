package com.example.demo.Models.PhieuNhapHang;

import com.example.demo.Models.phieunhaphang;

public class PNHConcreteBuilder implements PNHBuilder{
    private int maPhieuNhap;
    private String ngayNhap;
    private int tongTien;
    @Override
    public PNHConcreteBuilder setMaPhieuNhap(int maPhieuNhap) {
        this.maPhieuNhap = maPhieuNhap;
        return this;
    }
    @Override
    public PNHConcreteBuilder setNgayNhap(String ngayNhap) {
        this.ngayNhap = ngayNhap;
        return this;
    }

    @Override
    public PNHConcreteBuilder setTongTien(int tongTien) {
        this.tongTien = tongTien;
        return this;
    }

    @Override
    public phieunhaphang build() {
        return new phieunhaphang(maPhieuNhap, ngayNhap, tongTien);
    }
}
