package org.example.demobackend.Models;

import jakarta.persistence.*;

@Entity(name = "dvt")
public class dvt {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "madvt")
    private int madvt;
    @Column(name = "tendvt")
    private String tendvt;

    public dvt() {
    }

    public dvt(String tendvt) {
        this.tendvt = tendvt;
    }

    public int getMadvt() {
        return madvt;
    }

    public void setMadvt(int madvt) {
        this.madvt = madvt;
    }

    public String getTendvt() {
        return tendvt;
    }

    public void setTendvt(String tendvt) {
        this.tendvt = tendvt;
    }
}
