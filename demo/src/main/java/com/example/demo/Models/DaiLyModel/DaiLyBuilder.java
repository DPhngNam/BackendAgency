package com.example.demo.Models.DaiLyModel;

public interface DaiLyBuilder {
    DaiLyBuilder setMaDaiLy(int maDaiLy);
    DaiLyBuilder setTenDaiLy(String tenDaiLy);
    DaiLyBuilder setDienThoai(String dienThoai);
    DaiLyBuilder setDiaChi(String diaChi);
    DaiLyBuilder setMaLoaiDaiLy(int maLoaiDaiLy);
    DaiLyBuilder setMaQuan(int maQuan);
    DaiLyBuilder setEmail(String email);
    DaiLyBuilder setSoNo(int soNo);
    DaiLyBuilder setNgayTiepNhan(String ngayTiepNhan);
    DaiLyBuilder setUserId(int userId);
    daily build();
}
