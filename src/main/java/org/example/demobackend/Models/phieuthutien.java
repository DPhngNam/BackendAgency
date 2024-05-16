package org.example.demobackend.Models;

import jakarta.persistence.*;

@Entity
public class phieuthutien {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "maphieuthu")
    private int maphieuthu;
    @Column(name = "ngaythutien")
    private String ngaythutien;
    @Column(name = "tienthu")
    private int tienthu;
    @ManyToOne
    @JoinColumn(name = "madaily")
    private daily madaily;

    public phieuthutien() {
    }

    public phieuthutien(String ngaythutien, int tienthu, daily madaily) {
        this.ngaythutien = ngaythutien;
        this.tienthu = tienthu;
        this.madaily = madaily;
    }

    public int getMaphieuthu() {
        return maphieuthu;
    }

    public String getNgaythutien() {
        return ngaythutien;
    }

    public int getTienthu() {
        return tienthu;
    }

    public daily getMadaily() {
        return madaily;
    }
}
