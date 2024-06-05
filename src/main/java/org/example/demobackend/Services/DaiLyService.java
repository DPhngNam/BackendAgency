package org.example.demobackend.Services;

import org.example.demobackend.Models.*;
import org.example.demobackend.Repository.*;
import org.example.demobackend.TriggerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;



@Service
public class DaiLyService {
    private final DaiLyRepository daiLyRepository;
    private final LoaiDaiLyRepository loaiDailyRepository;
    private final QuanRepository quanRepository;
    private final ThamSoRepository thamSoRepository;
    private final CongNoRepository baocaocongnoRepository;
    private final CTXHRepository ctxhRepository;
    private final PhieuXuatHangRepository phieuXuatHangRepository;


    @Autowired
    public DaiLyService(DaiLyRepository daiLyRepository,
                        LoaiDaiLyRepository loaiDailyRepository,
                        QuanRepository quanRepository,
                        ThamSoRepository thamSoRepository,
                        CongNoRepository baocaocongnoRepository,
                        CTXHRepository ctxhRepository,
                        PhieuXuatHangRepository phieuXuatHangRepository) {
        this.daiLyRepository = daiLyRepository;
        this.loaiDailyRepository = loaiDailyRepository;
        this.quanRepository = quanRepository;
        this.thamSoRepository = thamSoRepository;
        this.baocaocongnoRepository = baocaocongnoRepository;
        this.ctxhRepository = ctxhRepository;
        this.phieuXuatHangRepository = phieuXuatHangRepository;
    }

    public Iterable<daily> getAllDaiLy() {
        return daiLyRepository.findAll();
    }


    private static Calendar calendar;

    public daily insertDaiLy(daily daily) {
        try {
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
        }catch (DataIntegrityViolationException e) {
            // Handle the error here. For example, you could log the error and return null:
            System.out.println("Error inserting daily: " + e.getMessage());
            return null;
        }
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

    public String deleteDaiLy(int madaily) throws TriggerException {
        daily existingDaiLy = daiLyRepository.getDaiLyById(madaily);
        /*
        if (existingDaiLy != null) {
            if (existingDaiLy.getTienno() == 0) {
                daiLyRepository.delete(existingDaiLy);
                return "Đã xóa đại lý";
            }else{
                return "Không thể xóa đại lý nợ tiền";
            }
        }
        return "Không tìm thấy đại lý";*/

        try {

            daiLyRepository.delete(existingDaiLy);
        } catch (DataIntegrityViolationException e) {
            Throwable cause = e.getRootCause();
            if (cause instanceof SQLException) {
                SQLException sqlEx = (SQLException) cause;
                if (sqlEx.getErrorCode() == 1451) {
                    throw new TriggerException("Trigger error occurred: " + sqlEx.getMessage());
                }

                throw new TriggerException("Trigger error occurred: " + sqlEx.getMessage());

            }
            throw e;
        }
        return "Đã xóa đại lý";
    }
}
