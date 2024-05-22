package org.example.demobackend.Models;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


import java.util.Date;


@Entity
public class phieunhaphang {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "mapnhap")
    private int mapnhap;


    @Column(name = "ngaylp")
    private String ngaylp;

    @Column(name = "tongtien")
    private int tongtien;

    public phieunhaphang() {
    }



    public phieunhaphang(int mapnhap,int tongtien) {
        this.mapnhap = mapnhap;
        this.tongtien = tongtien;
    }

    public phieunhaphang( String ngaylp, int tongtien) {

        this.ngaylp = ngaylp;
        this.tongtien = tongtien;
    }

    public phieunhaphang(int mapnhap) {
        this.mapnhap = mapnhap;
    }

    public int getMapnhap() {
        return mapnhap;
    }

    public String getNgaylp() {
        return ngaylp;
    }
    public int getTongtien() {
        return tongtien;
    }

    public void setTongtien(int tongtien) {
        this.tongtien = tongtien;
    }


}