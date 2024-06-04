package org.example.demobackend.Services;

import jakarta.transaction.Transactional;
import org.example.demobackend.Models.*;
import org.example.demobackend.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
<<<<<<< Updated upstream
=======
import java.util.HashSet;
import java.util.List;
import java.util.Set;

>>>>>>> Stashed changes

@Service
public class DaiLyService {
    private final DaiLyRepository daiLyRepository;
    private final LoaiDaiLyRepository loaiDailyRepository;
    private final QuanRepository quanRepository;
    private final ThamSoRepository thamSoRepository;
    private final CongNoRepository baocaocongnoRepository;
<<<<<<< Updated upstream
=======
    private final CTXHRepository ctxhRepository;
    private final PhieuXuatHangRepository phieuXuatHangRepository;
    private final PTTRepository phieuThuTienRepository;
    private final CTBCDSRepository ctbcdsRepository;
    private final BaoCaoDoanhSoRepository baoCaoDoanhSoRepository;

>>>>>>> Stashed changes

    @Autowired
    public DaiLyService(DaiLyRepository daiLyRepository,
                        LoaiDaiLyRepository loaiDailyRepository,
                        QuanRepository quanRepository,
                        ThamSoRepository thamSoRepository,
<<<<<<< Updated upstream
                        CongNoRepository baocaocongnoRepository) {
=======
                        CongNoRepository baocaocongnoRepository,
                        CTXHRepository ctxhRepository,
                        PhieuXuatHangRepository phieuXuatHangRepository, PTTRepository phieuThuTienRepository, CTBCDSRepository ctbcdsRepository, BaoCaoDoanhSoRepository baoCaoDoanhSoRepository) {
>>>>>>> Stashed changes
        this.daiLyRepository = daiLyRepository;
        this.loaiDailyRepository = loaiDailyRepository;
        this.quanRepository = quanRepository;
        this.thamSoRepository = thamSoRepository;
        this.baocaocongnoRepository = baocaocongnoRepository;
<<<<<<< Updated upstream
=======
        this.ctxhRepository = ctxhRepository;
        this.phieuXuatHangRepository = phieuXuatHangRepository;
        this.phieuThuTienRepository = phieuThuTienRepository;
        this.ctbcdsRepository = ctbcdsRepository;
        this.baoCaoDoanhSoRepository = baoCaoDoanhSoRepository;
>>>>>>> Stashed changes
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
<<<<<<< Updated upstream
=======

    @Transactional
    public String deleteDaiLy(int madaily) {

        try {
            baocaocongnoRepository.deleteByMadaily(madaily);
            List<phieuxuathang> listPXH = phieuXuatHangRepository.getPhieuXuatHangByDaiLy(madaily);
            for (phieuxuathang pxh : listPXH) {
                ctxhRepository.deleteByMapxuat(pxh.getMapxuat());
            }
            phieuXuatHangRepository.deleteByMadaily(madaily);
            phieuThuTienRepository.deleteByMadaily(madaily);

            List<ctbcds> listCTBCDS = ctbcdsRepository.getCTBCDSByMaDaily(madaily);
            Set<Integer> listMaBCDS = new HashSet<>();
            for (ctbcds ctbcds : listCTBCDS) {
                ctbcdsRepository.deleteByMaDaily(madaily);
                if(!listMaBCDS.contains(ctbcds.getMabaocaods().getMabaocaods()) && ctbcdsRepository.countCTBCDSByMabaocaods(ctbcds.getMabaocaods().getMabaocaods()) == 0){
                    listMaBCDS.add(ctbcds.getMabaocaods().getMabaocaods());
                }
            }
            daiLyRepository.deleteByMadaily(madaily);
            for (int mabaocaods : listMaBCDS) {
                baoCaoDoanhSoRepository.deleteByMabaocaodoanhso(mabaocaods);
            }
        } catch (DataIntegrityViolationException e) {
            return e.getMessage();
        }
        return "Deleted";
    }
>>>>>>> Stashed changes
}
