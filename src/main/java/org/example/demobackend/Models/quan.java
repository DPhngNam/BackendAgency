package org.example.demobackend.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public  class quan {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int maquan;
    private String tenquan;

    public quan(int maquan) {
        this.maquan = maquan;
    }

    public quan(String tenquan) {

        this.tenquan = tenquan;
    }

    public quan() {

    }

    public int getId() {
        return maquan;
    }

    public void setId(Integer id) {
        this.maquan = id;
    }

    public String getTenquan() {
        return tenquan;
    }

    public void setTenquan(String tenquan) {
        this.tenquan = tenquan;
    }
}
