package com.example.demo.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name = "dvt")
public class dvt {
    @Id
    private int madvt;
    private String tendvt;

    public dvt() {
    }

    public dvt(int madvt, String tendvt) {
        this.madvt = madvt;
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
