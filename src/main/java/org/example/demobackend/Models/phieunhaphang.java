package org.example.demobackend.Models;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class phieunhaphang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int mapnhap;
    private String ngaylp;
    private int tongtien;
    private Integer person_id;

    public phieunhaphang() {
        
    }

    public phieunhaphang(String ngaynhap, int tongtien, int person_id) {
        this.ngaylp = ngaynhap;
        this.tongtien = tongtien;
        this.person_id = person_id;
    }

    @OneToMany(mappedBy = "phieunhaphang", cascade = CascadeType.ALL)
    private List<ctnh> ctnhList = new ArrayList<>();

    public void addCtnh(ctnh ctnh) {
        ctnhList.add(ctnh);
        ctnh.setPhieunhaphang(this);
    }

    public int getMapnhap() {
        return mapnhap;
    }

    public void setMapnhap(int mapnhap) {
        this.mapnhap = mapnhap;
    }

    public String getNgaylp() {
        return ngaylp;
    }

    public void setNgaylp(String ngaylp) {
        this.ngaylp = ngaylp;
    }

    public int getTongtien() {
        return tongtien;
    }

    public void setTongtien(int tongtien) {
        this.tongtien = tongtien;
    }

    public Integer getPerson_id() {
        return person_id;
    }

    public void setPerson_id(Integer person_id) {
        this.person_id = person_id;
    }
}
