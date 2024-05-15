package org.example.demobackend.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class baocaodoanhso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int mabaocaods;
    private int thang;
    private int nam;
    private int tongdoanhthu;

    public baocaodoanhso() {
    }

    public baocaodoanhso(int thang, int nam, int tongdoanhthu) {
        this.thang = thang;
        this.nam = nam;
        this.tongdoanhthu = tongdoanhthu;
    }

    public int getMabaocaods() {
        return mabaocaods;
    }

    public void setMabaocaods(int mabaocaods) {
        this.mabaocaods = mabaocaods;
    }

    public int getThang() {
        return thang;
    }

    public void setThang(int thang) {
        this.thang = thang;
    }

    public int getNam() {
        return nam;
    }

    public void setNam(int nam) {
        this.nam = nam;
    }

    public int getTongdoanhthu() {
        return tongdoanhthu;
    }

    public void setTongdoanhthu(int tongdoanhthu) {
        this.tongdoanhthu = tongdoanhthu;
    }
}
