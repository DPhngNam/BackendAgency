package com.example.demo.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@Entity
public class loaidaily {
    @Id
    private int id;
    private String tenloaidl;

    public loaidaily() {

    }

    public loaidaily(int id, String tenloaidl) {
        this.id = id;
        this.tenloaidl = tenloaidl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenloai() {
        return tenloaidl;
    }

    public void setTenloai(String tenloai) {
        this.tenloaidl = tenloai;
    }
}
