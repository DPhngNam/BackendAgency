package org.example.demobackend.Models;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.sql.Date;


@Entity
@EntityListeners(AuditingEntityListener.class)
public class phieunhaphang {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "mapnhap")
    private int mapnhap;


    @Column(name = "ngaylp")
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date ngaylp;

    @Column(name = "tongtien",nullable = false)
    private int tongtien;

    public phieunhaphang() {
    }



    public phieunhaphang(int mapnhap,int tongtien) {
        this.mapnhap = mapnhap;
        this.tongtien = tongtien;
    }

    public phieunhaphang( Date ngaylp, int tongtien) {

        this.ngaylp = ngaylp;
        this.tongtien = tongtien;
    }

    public phieunhaphang(int mapnhap) {
        this.mapnhap = mapnhap;
    }

    public int getMapnhap() {
        return mapnhap;
    }

    public Date getNgaylp() {
        return ngaylp;
    }
    public int getTongtien() {
        return tongtien;
    }

    public void setTongtien(int tongtien) {
        this.tongtien = tongtien;
    }


}