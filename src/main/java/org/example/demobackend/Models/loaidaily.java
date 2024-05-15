package org.example.demobackend.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@Entity
public class loaidaily {
    @Id
    private int maloaidl;
    @Column(name = "tenloaidl")
    private String tenloaidl;
    private int notoida;

    public loaidaily(int maloaidl, String tenloaidl, int notoida) {
        this.maloaidl = maloaidl;
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
