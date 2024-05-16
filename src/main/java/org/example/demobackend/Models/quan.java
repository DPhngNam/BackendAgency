package org.example.demobackend.Models;

import jakarta.persistence.*;

@Entity
public  class quan {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "maquan")
    private int maquan;
    @Column(name = "tenquan")
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
