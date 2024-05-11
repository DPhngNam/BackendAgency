package com.example.demo.Services;

import com.example.demo.Models.phieuthutien;
import com.example.demo.Repository.PTTRepository;
import org.springframework.stereotype.Service;

@Service
public class PTTService {
    private final PTTRepository pttRepository;

    public PTTService(PTTRepository pttRepository) {
        this.pttRepository = pttRepository;
    }

    public Iterable<phieuthutien> getAllPhieuThuTien() {
        return pttRepository.findAll();
    }

    public Iterable<phieuthutien> getPhieuThuTienById(int maPhieuThu) {
        return pttRepository.getPhieuThuTienById(maPhieuThu);
    }

    public Iterable<phieuthutien> getPhieuThuTienByDaiLyId(int madaily) {
        return pttRepository.getPhieuThuTienByDaiLyId(madaily);
    }


}
