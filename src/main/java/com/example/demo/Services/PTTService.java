package com.example.demo.Services;

import com.example.demo.Models.daily;
import com.example.demo.Models.phieuthutien;
import com.example.demo.Models.quan;
import com.example.demo.Repository.DaiLyRepository;
import com.example.demo.Repository.PTTRepository;
import org.springframework.stereotype.Service;

@Service
public class PTTService {
    private final PTTRepository pttRepository;
    private final DaiLyRepository daiLyRepository;
    private final DaiLyService daiLyService;

    public PTTService(PTTRepository pttRepository, DaiLyRepository daiLyRepository, DaiLyService daiLyService) {
        this.pttRepository = pttRepository;
        this.daiLyRepository = daiLyRepository;
        this.daiLyService = daiLyService;
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

    public phieuthutien insertPhieuThuTien(phieuthutien phieuthutien) {
        try {
            // Retrieve the existing daily object from the database
            daily existingDaily = daiLyRepository.getDaiLyById(phieuthutien.getMadaily());
            int tienthu = phieuthutien.getTienthu();
            if (existingDaily != null) {
                int oldTienNo = existingDaily.getTienno();
                existingDaily.setTienno(oldTienNo-tienthu);

                daiLyRepository.save(existingDaily);
            } else {
                throw new Exception("Daily with name: " + phieuthutien.getMadaily() + " not found");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pttRepository.save(phieuthutien);
    }

}
