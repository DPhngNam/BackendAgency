package org.example.demobackend.Services;

import org.example.demobackend.Models.daily;
import org.example.demobackend.Models.loaidaily;
import org.example.demobackend.Models.quan;
import org.example.demobackend.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DaiLyService {
    private final DaiLyRepository daiLyRepository;
    private final LoaiDaiLyRepository loaiDailyRepository;
    private final QuanRepository quanRepository;
    private final ThamSoRepository thamSoRepository;


    @Autowired
    public DaiLyService(DaiLyRepository daiLyRepository,
                        LoaiDaiLyRepository loaiDailyRepository,
                        QuanRepository quanRepository,
                        ThamSoRepository thamSoRepository) {
        this.daiLyRepository = daiLyRepository;
        this.loaiDailyRepository = loaiDailyRepository;
        this.quanRepository = quanRepository;
        this.thamSoRepository = thamSoRepository;

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

            int n = daiLyRepository.countDaiLyByLoaiDaiLy(daily.getMaloaidl().getMaloaidl());
            if(n >= thamSoRepository.getThamSoByTen("Số đại lý tối đa trong một quận").getGiatri()){
                return null;
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

    public Boolean updateSoNo(int tienno,int madaily){

        daily existingDaiLy = daiLyRepository.getDaiLyById(madaily);
        if (existingDaiLy != null) {
            int oldTienNo = existingDaiLy.getTienno();
            int newTienNo = oldTienNo + tienno;

            if(loaiDailyRepository.findByMaloaidl(existingDaiLy.getMaloaidl().getMaloaidl()).getNotoida() < newTienNo){
                return false;
            }
            existingDaiLy.setTienno(newTienNo);
            daiLyRepository.save(existingDaiLy);
            return true;
        }
        return false;
    }

    public int getSoNoDuocNoThem(int madaily) {
        daily existingDaiLy = daiLyRepository.getDaiLyById(madaily);
        if (existingDaiLy != null) {
            return loaiDailyRepository.findByMaloaidl(existingDaiLy.getMaloaidl().getMaloaidl()).getNotoida() - existingDaiLy.getTienno();
        }
        return -1;
    }
}
