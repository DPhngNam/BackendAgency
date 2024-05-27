package org.example.demobackend.Services;

import org.example.demobackend.Models.*;
import org.example.demobackend.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;

@Service
public class DaiLyService {
    private final DaiLyRepository daiLyRepository;
    private final LoaiDaiLyRepository loaiDailyRepository;
    private final QuanRepository quanRepository;
    private final ThamSoRepository thamSoRepository;
    private final CongNoRepository baocaocongnoRepository;

    @Autowired
    public DaiLyService(DaiLyRepository daiLyRepository,
                        LoaiDaiLyRepository loaiDailyRepository,
                        QuanRepository quanRepository,
                        ThamSoRepository thamSoRepository,
                        CongNoRepository baocaocongnoRepository) {
        this.daiLyRepository = daiLyRepository;
        this.loaiDailyRepository = loaiDailyRepository;
        this.quanRepository = quanRepository;
        this.thamSoRepository = thamSoRepository;
        this.baocaocongnoRepository = baocaocongnoRepository;
    }

    public Iterable<daily> getAllDaiLy() {
        return daiLyRepository.findAll();
    }


    private static Calendar calendar;

    public daily insertDaiLy(daily daily) {
            calendar = Calendar.getInstance();
            quan existingQuan = quanRepository.findByTenquan(daily.getMaquan().getTenquan());
            if (existingQuan == null) {
                return null;
            } else {
                daily.setMaquan(existingQuan);
            }
            loaidaily existingLoaiDaiLy = loaiDailyRepository.findByTenloaidl(daily.getMaloaidl().getTenloaidl());
            if (existingLoaiDaiLy == null) {
                return null;
            } else {
                daily.setMaloaidl(existingLoaiDaiLy);
            }
            int n = daiLyRepository.countDaiLyByLoaiDaiLy(daily.getMaquan().getId());
            if(n >= thamSoRepository.getThamSoByTen("Số đại lý tối đa trong một quận").getGiatri()){
                return null;
            }
            daily daily1 = daiLyRepository.save(daily);
            calendar.setTime(daily1.getNgaytn());
            int thang = calendar.get(Calendar.MONTH) + 1;
            int nam = calendar.get(Calendar.YEAR);
            baocaocongno bccn = new baocaocongno(new baocaocongnoID(thang, nam, daily1), 0, 0, 0);
            baocaocongnoRepository.save(bccn);
            return daily1;

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


    public int getDaiLyById(int madaily) {
        daily dl =  daiLyRepository.getDaiLyById(madaily);
        int max_debt = loaiDailyRepository.findByMaloaidl(dl.getMaloaidl().getMaloaidl()).getNotoida();
        return max_debt - dl.getTienno();
    }
}
