package org.example.demobackend.Services;

import org.example.demobackend.Models.daily;
import org.example.demobackend.Models.loaidaily;
import org.example.demobackend.Models.quan;
import org.example.demobackend.Repository.DaiLyRepository;
import org.example.demobackend.Repository.LoaiDaiLyRepository;
import org.example.demobackend.Repository.PersonRepository;
import org.example.demobackend.Repository.QuanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DaiLyService {
    private final DaiLyRepository daiLyRepository;
    private final LoaiDaiLyRepository loaiDailyRepository;
    private final QuanRepository quanRepository;
    private final PersonRepository personRepository;

    @Autowired
    public DaiLyService(DaiLyRepository daiLyRepository, LoaiDaiLyRepository loaiDailyRepository, QuanRepository quanRepository, PersonRepository personRepository) {
        this.daiLyRepository = daiLyRepository;
        this.loaiDailyRepository = loaiDailyRepository;
        this.quanRepository = quanRepository;
        this.personRepository = personRepository;
    }

    public Iterable<daily> getAllDaiLy() {
        return daiLyRepository.findAll();
    }



    public daily insertDaiLy(daily daily) {
        try {

            quan existingQuan = quanRepository.findByTenquan(daily.getMaquan().getTenquan());
            if (existingQuan == null) {
                // If not, create it
                quan newQuan = new quan();
                newQuan.setTenquan(daily.getMaquan().getTenquan());
                quanRepository.save(newQuan);
                daily.setMaquan(newQuan);
            } else {
                daily.setMaquan(existingQuan);
            }

            loaidaily existingLoaiDaiLy = loaiDailyRepository.findByTenloaidl(daily.getMaloaidl().getTenloaidl());
            if (existingLoaiDaiLy == null) {
                loaidaily newLoaidl = new loaidaily();
                newLoaidl.setTenloaidl(daily.getMaloaidl().getTenloaidl());
                loaiDailyRepository.save(newLoaidl);
                daily.setMaloaidl(newLoaidl);
            } else {
                daily.setMaloaidl(existingLoaiDaiLy);
            }


            return daiLyRepository.save(daily);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public daily getDaiLyByName(String tendaily) {
        return daiLyRepository.getAllDaiLyByTenDaiLy(tendaily);
    }

    public void updateSoNo(int tienno,int madaily){

        daily existingDaiLy = daiLyRepository.getDaiLyById(madaily);
        if (existingDaiLy != null) {
            int oldTienNo = existingDaiLy.getTienno();
            existingDaiLy.setTienno(oldTienNo+tienno);
            daiLyRepository.save(existingDaiLy);
        }

    }
}
