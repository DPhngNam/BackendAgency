package org.example.demobackend.Models;

import jakarta.persistence.*;

@Entity(name = "mathang")
public class mathang {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mamh")
    private int mamh;

    @Column(name = "tenmh", nullable = false)
    private String tenmh;

    @ManyToOne
    @JoinColumn(name = "madvt")
    private dvt madvt;

    @Column(name = "dongianhap")
    private double dongianhap;

    @Column(name = "dongiaxuat")
    private double dongiaxuat;

    @Column(name = "slton")
    private int slton;

    public mathang() {
    }

    public mathang(String tenmh, dvt madvt, double dongianhap, double dongiaxuat, int slton) {

        this.tenmh = tenmh;
        this.madvt = madvt;
        this.dongianhap = dongianhap;
        this.dongiaxuat = dongiaxuat;
        this.slton = slton;
    }


}