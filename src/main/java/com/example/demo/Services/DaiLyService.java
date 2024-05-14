package com.example.demo.Services;

import com.example.demo.Models.daily;
import com.example.demo.Models.loaidaily;
import com.example.demo.Models.person;
import com.example.demo.Models.quan;
import com.example.demo.Repository.DaiLyRepository;
import com.example.demo.Repository.LoaiDaiLyRepository;
import com.example.demo.Repository.PersonRepository;
import com.example.demo.Repository.QuanRepository;
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
}
