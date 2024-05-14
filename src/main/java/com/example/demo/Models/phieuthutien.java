package com.example.demo.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class phieuthutien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int maphieuthu;
    private String ngaythutien;
    private int tienthu;
    private int madaily;

    public phieuthutien() {
    }

    public phieuthutien(String ngaythutien, int tienthu, int madaily) {

        this.ngaythutien = ngaythutien;
        this.tienthu = tienthu;
        this.madaily = madaily;
    }

    public int getMaphieuthu() {
        return maphieuthu;
    }

    public void setMaphieuthu(int maphieuthu) {
        this.maphieuthu = maphieuthu;
    }

    public String getNgaythutien() {
        return ngaythutien;
    }

    public void setNgaythutien(String ngaythutien) {
        this.ngaythutien = ngaythutien;
    }

    public int getTienthu() {
        return tienthu;
    }

    public void setTienthu(int tienthu) {
        this.tienthu = tienthu;
    }

    public int getMadaily() {
        return madaily;
    }

    public void setMadaily(int madaily) {
        this.madaily = madaily;
    }
}
