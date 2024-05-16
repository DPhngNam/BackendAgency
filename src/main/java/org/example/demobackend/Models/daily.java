package org.example.demobackend.Models;

import jakarta.persistence.*;

@Entity
public class daily {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int madaily;
    private String tendaily;
    private String diachi;
    private String sdt;
    private String email;
    @ManyToOne
    @JoinColumn(name = "maloaidl")
    private loaidaily maloaidl;

    @ManyToOne
    @JoinColumn(name = "maquan")
    private quan maquan;

    private String ngaytn;
    private int tienno;



    public daily() {
    }

    public daily(String tendaily, String diachi, String sdt, String email, loaidaily maloaidl, quan maquan, String ngaytn, int tienno) {
            this.tendaily = tendaily;
            this.diachi = diachi;
            this.sdt = sdt;
            this.email = email;
            this.maloaidl = maloaidl;
            this.maquan = maquan;
            this.ngaytn = ngaytn;
            this.tienno = tienno;
    }

    public int getMadaily() {
        return madaily;
    }

    public void setMadaily(int madaily) {
        this.madaily = madaily;
    }

    public String getTendaily() {
        return tendaily;
    }

    public void setTendaily(String tendaily) {
        this.tendaily = tendaily;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public loaidaily getMaloaidl() {
        return maloaidl;
    }

    public void setMaloaidl(loaidaily maloaidl) {
        this.maloaidl = maloaidl;
    }

    public quan getMaquan() {
        return maquan;
    }

    public void setMaquan(quan maquan) {
        this.maquan = maquan;
    }

    public String getNgaytn() {
        return ngaytn;
    }

    public void setNgaytn(String ngaytn) {
        this.ngaytn = ngaytn;
    }

    public int getTienno() {
        return tienno;
    }

    public void setTienno(int tienno) {
        this.tienno = tienno;
    }


}