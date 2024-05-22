package org.example.demobackend.Models;

import jakarta.persistence.*;

@Entity
public class loaidaily {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "maloaidl")
    private int maloaidl;
    @Column(name = "tenloaidl",nullable = false,columnDefinition = "NVARCHAR(255)")

    private String tenloaidl;
    @Column(name = "notoida",nullable = false)
    private int notoida;

    public loaidaily(String tenloaidl, int notoida) {
        this.tenloaidl = tenloaidl;
        this.notoida = notoida;
    }

    public loaidaily() {

    }


    public int getMaloaidl() {
        return maloaidl;
    }

    public void setMaloaidl(int maloaidl) {
        this.maloaidl = maloaidl;
    }

    public String getTenloaidl() {
        return tenloaidl;
    }

    public void setTenloaidl(String tenloaidl) {
        this.tenloaidl = tenloaidl;
    }

    public int getNotoida() {
        return notoida;
    }

    public void setNotoida(int notoida) {
        this.notoida = notoida;
    }
}
