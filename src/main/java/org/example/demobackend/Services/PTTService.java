package org.example.demobackend.Services;


import org.example.demobackend.Models.baocaocongno;
import org.example.demobackend.Models.daily;
import org.example.demobackend.Models.phieuthutien;
import org.example.demobackend.Repository.CongNoRepository;
import org.example.demobackend.Repository.DaiLyRepository;
import org.example.demobackend.Repository.PTTRepository;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;

@Service
public class PTTService {
    private final PTTRepository pttRepository;
    private final DaiLyRepository daiLyRepository;
    private final DaiLyService daiLyService;
    private final CongNoRepository congNoRepository;

    public PTTService(PTTRepository pttRepository, DaiLyRepository daiLyRepository, DaiLyService daiLyService, CongNoRepository congNoRepository) {
        this.pttRepository = pttRepository;
        this.daiLyRepository = daiLyRepository;
        this.daiLyService = daiLyService;
        this.congNoRepository = congNoRepository;
    }

    public Iterable<phieuthutien> getAllPhieuThuTien() {
        return pttRepository.findAll();
    }


    public Iterable<phieuthutien> getPhieuThuTienByDaiLyId(int madaily) {
        return pttRepository.getPhieuThuTienByDaiLyId(madaily);
    }

    public boolean insertPhieuThuTien(phieuthutien phieuthutien) {
        try {
            // Retrieve the existing daily object from the database
            daily existingDaily = daiLyRepository.getDaiLyById(phieuthutien.getMadaily().getMadaily());
            int tienthu = phieuthutien.getTienthu();
            if (existingDaily != null) {
                int oldTienNo = existingDaily.getTienno();
                if (oldTienNo < tienthu) {
                    return false;
                }
                existingDaily.setTienno(oldTienNo-tienthu);


                daiLyRepository.save(existingDaily);
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        pttRepository.save(phieuthutien);
        Date ngaylp = phieuthutien.getNgaythutien();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(ngaylp);
        int thang = calendar.get(Calendar.MONTH) + 1;
        int nam = calendar.get(Calendar.YEAR);

        baocaocongno existingBCCN = congNoRepository.getCongNoByDaiLy(thang,nam,phieuthutien.getMadaily().getMadaily());
        if (existingBCCN != null) {
            int oldPhatSinh = existingBCCN.getPhatSinh();
            int newPhatSinh = oldPhatSinh - phieuthutien.getTienthu();
            existingBCCN.setPhatSinh(newPhatSinh);
            congNoRepository.save(existingBCCN);
        }
        return true;
    }

    public String deletePhieuThuTien(int maPhieuThu) {
        try {
            phieuthutien existingPhieuThuTien = pttRepository.getPhieuThuTienById(maPhieuThu);
            daily existingDaily = daiLyRepository.getDaiLyById(existingPhieuThuTien.getMadaily().getMadaily());
            existingDaily.setTienno(existingPhieuThuTien.getTienthu() + existingDaily.getTienno());
            daiLyRepository.save(existingDaily);
            pttRepository.deleteById(maPhieuThu);
            return "Delete success";
        } catch (Exception e) {
            return "Delete failed";
        }
    }
}
