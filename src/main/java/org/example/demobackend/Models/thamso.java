package org.example.demobackend.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;

@Entity
public class thamso {
    @Id
    @Column(name = "tenthamso",columnDefinition = "NVARCHAR(255)")
    private String tenthamso;
    @Getter
    @Column(name = "giatri",nullable = false)
    private int giatri;

    public thamso() {
    }

    public thamso(String tenthamso, int giaTri) {
        this.tenthamso = tenthamso;
        this.giatri = giaTri;
    }

    public String getTenThamSo() {
        return tenthamso;
    }

    public void setTenthamso(String tenthamso) {
        this.tenthamso = tenthamso;
    }

    public void setGiatri(int giatri) {
        this.giatri = giatri;
    }

}
