package org.example.demobackend.Services;

import org.example.demobackend.Models.baocaodoanhso;
import org.example.demobackend.Models.ctbcds;
import org.example.demobackend.Models.daily;
import org.example.demobackend.Models.phieuxuathang;
import org.example.demobackend.Repository.BaoCaoDoanhSoRepository;
import org.example.demobackend.Repository.CTBCDSRepository;
import org.example.demobackend.Repository.DaiLyRepository;
import org.example.demobackend.Repository.PhieuXuatHangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CTBCDSService {
    private static CTBCDSRepository ctbcdsRepository;
    private static PhieuXuatHangRepository phieuXuatHangRepository;
    private static BaoCaoDoanhSoRepository baoCaoDoanhSoRepository;
    private static DaiLyRepository dailyRepository;
    private static List<ctbcds> ctbcdsList;
    @Autowired
    public CTBCDSService(CTBCDSRepository ctbcdsRepository,
                         PhieuXuatHangRepository phieuXuatHangRepository,
                         BaoCaoDoanhSoRepository baoCaoDoanhSoRepository,
                         DaiLyRepository dailyRepository) {
        this.ctbcdsRepository = ctbcdsRepository;
        this.phieuXuatHangRepository = phieuXuatHangRepository;
        this.baoCaoDoanhSoRepository = baoCaoDoanhSoRepository;
        this.dailyRepository = dailyRepository;
        ctbcdsList = new ArrayList<ctbcds>();
    }



    public static List<ctbcds> getCTBCDSByMaDaily(int madaily) {
        return ctbcdsRepository.getCTBCDSByMaDaily(madaily);
    }

    public static ctbcds getCTBCDSByMaDailyAndMaBaoCaoDS(int madaily, int mabaocaods) {
        return ctbcdsRepository.getCTBCDSByMaDailyAndMaBaoCaoDS(madaily, mabaocaods);
    }

    public static List<ctbcds> createCTBCDS(int thang, int nam) {
        ctbcdsList.clear();
        baocaodoanhso bcds = baoCaoDoanhSoRepository.getBaoCaoDoanhSoByThangAndNam(thang, nam);
        List<daily> dailyList = dailyRepository.getAllDaiLyIdAndName();
        int tongtien = phieuXuatHangRepository.getTongByThangAndNam(thang, nam);

        for (daily daily : dailyList) {
            Integer sum1 = phieuXuatHangRepository.getTongTienByThangAndNamOfDaiLy(daily.getMadaily(),thang, nam) ;
            if (sum1 == null) {
                sum1 = 0;
            }
            double tyle = (double) sum1 / tongtien;
            ctbcds ctbcds = new ctbcds(daily,
                    bcds,
                    phieuXuatHangRepository.getSoPhieuXuatByThangAndNamOfNgayLP(thang, nam),
                    sum1,
                    tyle);
            ctbcdsRepository.save(ctbcds);
            ctbcdsList.add(ctbcds);
        }
        return ctbcdsList;
    }


    private static List<ctbcds> updateCTBCDS(int thang, int nam) {
        ctbcdsList.clear();
        baocaodoanhso bcds = baoCaoDoanhSoRepository.getBaoCaoDoanhSoByThangAndNam(thang, nam);

        ctbcdsList = ctbcdsRepository.getCTBCDSByMaBaoCaoDS(bcds.getMabaocaods());
        int tongtien = phieuXuatHangRepository.getTongByThangAndNam(thang, nam);
        for (ctbcds ctbcds : ctbcdsList) {
            Integer sum1 = phieuXuatHangRepository.getTongTienByThangAndNamOfDaiLy(ctbcds.getMadaily().getMadaily(),thang, nam) ;
            if (sum1 == null) {
                sum1 = 0;
            }
            double tyle = (double) sum1 / tongtien;
            ctbcds.setSophieuxuat(phieuXuatHangRepository.getSoPhieuXuatByThangAndNamOrderByMadaily(thang, nam, ctbcds.getMadaily().getMadaily()));
            ctbcds.setTongtrigia(sum1);
            ctbcds.setTyle(tyle);
            ctbcdsRepository.save(ctbcds);
        }
        return ctbcdsList;
    }

    public static List<ctbcds> getCTBCDS(int thang, int nam) {
        baocaodoanhso bcds = baoCaoDoanhSoRepository.getBaoCaoDoanhSoByThangAndNam(thang, nam);
        if (bcds == null) {
            return null;
        }
        ctbcdsList = ctbcdsRepository.getCTBCDSByMaBaoCaoDS(bcds.getMabaocaods());
        if (ctbcdsList.isEmpty()) {
            return createCTBCDS(thang, nam);
        } else {
            return updateCTBCDS(thang, nam);
        }
    }
}
