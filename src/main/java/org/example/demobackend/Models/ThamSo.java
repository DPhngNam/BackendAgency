package org.example.demobackend.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class ThamSo {
    @Id
    @Column(name = "tenThamSo")
    private String tenThamSo;
    @Column(name = "giaTri")
    private String giaTri;

    public ThamSo() {
    }

}
