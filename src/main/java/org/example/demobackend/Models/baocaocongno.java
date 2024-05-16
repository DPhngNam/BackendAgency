package org.example.demobackend.Models;

import jakarta.persistence.*;

@Entity
public class baocaocongno {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "maBaoCaoCongNo")
    private int maBaoCaoCongNo;
    @Column(name = "thang")
    private String thang;
    @Column(name = "nam")
    private String nam;
    @ManyToOne
    @JoinColumn(name = "madaily")
    private daily madaily;
    @Column(name = "noDau")
    private String noDau;
    @Column(name = "noCuoi")
    private String noCuoi;
    @Column(name = "phatSinh")
    private String phatSinh;


    public baocaocongno() {

    }

    public baocaocongno(int maBaoCaoCongNo, String thang, String nam, daily madaily, String noDau, String noCuoi, String phatSinh) {
        this.maBaoCaoCongNo = maBaoCaoCongNo;
        this.thang = thang;
        this.nam = nam;
        this.madaily = madaily;
        this.noDau = noDau;
        this.noCuoi = noCuoi;
        this.phatSinh = phatSinh;
    }
}
