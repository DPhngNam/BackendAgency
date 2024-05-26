package org.example.demobackend.Services;


import org.example.demobackend.Models.daily;
import org.example.demobackend.Models.phieuthutien;
import org.example.demobackend.Repository.DaiLyRepository;
import org.example.demobackend.Repository.PTTRepository;
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
        return true;
    }
}
