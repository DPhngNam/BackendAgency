package org.example.demobackend.Services;

import org.example.demobackend.Models.daily;
import org.example.demobackend.Models.loaidaily;
import org.example.demobackend.Repository.DaiLyRepository;
import org.example.demobackend.Repository.LoaiDaiLyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoaiDaiLyService {
    private static LoaiDaiLyRepository loaiDaiLyRepository;
    private static DaiLyRepository daiLyRepository;
    @Autowired
    public LoaiDaiLyService(LoaiDaiLyRepository loaiDaiLyRepository, DaiLyRepository daiLyRepository) {
        this.loaiDaiLyRepository = loaiDaiLyRepository;
        this.daiLyRepository = daiLyRepository;
    }



    public static List<loaidaily> getLoaiDaiLyRepository() {
        return (List<loaidaily>) loaiDaiLyRepository.findAll();
    }

    public static int addLoaiDaiLy(loaidaily newLoaiDaiLy) {
        try {
            loaidaily existingLoaiDaiLy = loaiDaiLyRepository.findByTenloaidl(newLoaiDaiLy.getTenloaidl());
            if (existingLoaiDaiLy != null) {
                return -1;
            }
            loaiDaiLyRepository.save(newLoaiDaiLy);
            return 1;
        } catch (Exception e) {
            return -1;
        }
    }

    public static int updateLoaiDaiLy(loaidaily newLoaiDaiLy) {
        try {
            loaidaily existingLoaiDaiLy = loaiDaiLyRepository.findByTenloaidl(newLoaiDaiLy.getTenloaidl());
            if (existingLoaiDaiLy == null) {
                return -1;
            }

            List<daily> existingDaiLy = daiLyRepository.getDaiLyTienNo(existingLoaiDaiLy.getMaloaidl());

            for (daily daiLy : existingDaiLy) {
                if(daiLy.getTienno() > newLoaiDaiLy.getNotoida()){
                    return -1;
                }
            }

            existingLoaiDaiLy.setNotoida(newLoaiDaiLy.getNotoida());
            loaiDaiLyRepository.save(existingLoaiDaiLy);
            return 1;
        } catch (Exception e) {
            return -1;
        }
    }

    public static int getTienNoToiDa(int maloaidl) {
        loaidaily existingLoaiDaiLy = loaiDaiLyRepository.findByMaloaidl(maloaidl);
        if (existingLoaiDaiLy == null) {
            return -1;
        }
        return existingLoaiDaiLy.getNotoida();
    }
}
