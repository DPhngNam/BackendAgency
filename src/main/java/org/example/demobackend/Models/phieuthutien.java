package org.example.demobackend.Models;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class phieuthutien {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "maphieuthu")
    private int maphieuthu;

    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    @Column(name = "ngaythutien",nullable = false)
    private Date ngaythutien;

    @Column(name = "tienthu",nullable = false)
    private int tienthu;

    @ManyToOne
    @JoinColumn(name = "madaily")
    private daily madaily;

    public phieuthutien() {
    }

    public phieuthutien(int maphieuthu, Date ngaythutien, int tienthu, daily madaily) {
        this.maphieuthu = maphieuthu;
        this.ngaythutien = ngaythutien;
        this.tienthu = tienthu;
        this.madaily = madaily;
    }


}
