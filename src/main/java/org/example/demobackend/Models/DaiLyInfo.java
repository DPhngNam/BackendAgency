package org.example.demobackend.Models;

public class DaiLyInfo {
    private int madaily;
    private String tendaily;

    public DaiLyInfo(int madaily, String tendaily) {
        this.madaily = madaily;
        this.tendaily = tendaily;
    }

    public String getTendaily() {
        return tendaily;
    }

    public int getMadaily() {
        return madaily;
    }
}
