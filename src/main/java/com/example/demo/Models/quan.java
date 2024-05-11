package com.example.demo.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public  class quan {
    @Id
    private int id;
    private String tenquan;

    public quan() {

    }

    public quan(int id, String tenquan) {
        this.id = id;
        this.tenquan = tenquan;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenquan() {
        return tenquan;
    }

    public void setTenquan(String tenquan) {
        this.tenquan = tenquan;
    }
}
