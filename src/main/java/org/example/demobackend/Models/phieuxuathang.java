package org.example.demobackend.Models;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class phieuxuathang {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "mapxuat")
    private int mapxuat;

    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    @Column(name = "ngaylp",nullable = false)
    private Date ngaylp;

    @ManyToOne
    @JoinColumn(name = "madaily",nullable = false)
    private daily madaily;

    @Column(name = "tongtien")
    private int tongtien;

    @Column(name = "sotientra")
    private int sotientra;

    @Column(name = "conlai")
    private int conlai;

    public phieuxuathang() {
    }

    public phieuxuathang(int mapxuat) {
        this.mapxuat = mapxuat;
    }

    public phieuxuathang(Date ngaylp, daily madaily, int tongtien, int sotientra, int conlai) {
        this.ngaylp = ngaylp;
        this.madaily = madaily;
        this.tongtien = tongtien;
        this.sotientra = sotientra;
        this.conlai = conlai;
    }
}
