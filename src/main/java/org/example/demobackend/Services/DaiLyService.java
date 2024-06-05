package org.example.demobackend.Services;

import jakarta.transaction.Transactional;
import org.example.demobackend.Models.*;
import org.example.demobackend.Repository.*;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class DaiLyService {
    private final DaiLyRepository daiLyRepository;
    private final LoaiDaiLyRepository loaiDailyRepository;
    private final QuanRepository quanRepository;
    private final ThamSoRepository thamSoRepository;
    private final CongNoRepository baocaocongnoRepository;
    private final CTXHRepository ctxhRepository;
    private final PhieuXuatHangRepository phieuXuatHangRepository;
    private final PTTRepository phieuThuTienRepository;
    private final CTBCDSRepository ctbcdsRepository;
    private final BaoCaoDoanhSoRepository baoCaoDoanhSoRepository;

    private static Calendar calendar;
    @Autowired
    public DaiLyService(DaiLyRepository daiLyRepository,
                        LoaiDaiLyRepository loaiDailyRepository,
                        QuanRepository quanRepository,
                        ThamSoRepository thamSoRepository,
                        CongNoRepository baocaocongnoRepository,
                        CTXHRepository ctxhRepository,
                        PhieuXuatHangRepository phieuXuatHangRepository,
                        PTTRepository phieuThuTienRepository,
                        CTBCDSRepository ctbcdsRepository,
                        BaoCaoDoanhSoRepository baoCaoDoanhSoRepository) {
        this.daiLyRepository = daiLyRepository;
        this.loaiDailyRepository = loaiDailyRepository;
        this.quanRepository = quanRepository;
        this.thamSoRepository = thamSoRepository;
        this.baocaocongnoRepository = baocaocongnoRepository;

        this.ctxhRepository = ctxhRepository;
        this.phieuXuatHangRepository = phieuXuatHangRepository;
        this.phieuThuTienRepository = phieuThuTienRepository;
        this.ctbcdsRepository = ctbcdsRepository;
        this.baoCaoDoanhSoRepository = baoCaoDoanhSoRepository;
    }

    public Iterable<daily> getAllDaiLy() {
        return daiLyRepository.findAll();
    }

    private daily setAttributes(daily daily){
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
        return daily;
    }

    public daily insertDaiLy(daily daily) {
            calendar = Calendar.getInstance();
            daily = setAttributes(daily);
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

    public daily updateDaiLy(@NotNull daily daily) {
        daily existingDaiLy = daiLyRepository.getDaiLyById(daily.getMadaily());
        daily = setAttributes(daily);
        if (existingDaiLy != null){
            assert daily != null;
            existingDaiLy.setTendaily(daily.getTendaily());
            existingDaiLy.setDiachi(daily.getDiachi());
            existingDaiLy.setSdt(daily.getSdt());
            existingDaiLy.setEmail(daily.getEmail());
            existingDaiLy.setMaloaidl(daily.getMaloaidl());
            existingDaiLy.setMaquan(daily.getMaquan());
            existingDaiLy.setNgaytn(daily.getNgaytn());
            daiLyRepository.save(existingDaiLy);
            return existingDaiLy;
        }
        return null;
    }
}
