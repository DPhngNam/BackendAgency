package org.example.demobackend.Models;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.sql.Date;

@Entity
@EntityListeners(AuditingEntityListener.class)

public class daily {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "madaily")
    private int madaily;
    @Column(name = "tendaily",nullable = false,columnDefinition = "NVARCHAR(255)")
    private String tendaily;
    @Column(name = "diachi",nullable = false,columnDefinition = "NVARCHAR(255)")
    private String diachi;
    @Column(name = "sdt",nullable = false)
    private String sdt;
    @Column(name = "email",nullable = false)
    private String email;
    @ManyToOne
    @JoinColumn(name = "maloaidl")
    private loaidaily maloaidl;

    @ManyToOne
    @JoinColumn(name = "maquan")
    private quan maquan;

    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    @Column(name = "ngaytn")
    private Date ngaytn;
    @Column(name = "tienno")
    private int tienno;



    public daily() {
    }




}
