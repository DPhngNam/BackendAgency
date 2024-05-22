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

    @Autowired
    public CTBCDSService(CTBCDSRepository ctbcdsRepository,
                         PhieuXuatHangRepository phieuXuatHangRepository,
                         BaoCaoDoanhSoRepository baoCaoDoanhSoRepository,
                         DaiLyRepository dailyRepository) {
        this.ctbcdsRepository = ctbcdsRepository;
        this.phieuXuatHangRepository = phieuXuatHangRepository;
        this.baoCaoDoanhSoRepository = baoCaoDoanhSoRepository;
        this.dailyRepository = dailyRepository;
    }

    public static List<ctbcds> getCTBCDSByMaBaoCaoDS(int mabaocaods) {
        return ctbcdsRepository.getCTBCDSByMaBaoCaoDS(mabaocaods);
    }

    public static List<ctbcds> getCTBCDSByMaDaily(int madaily) {
        return ctbcdsRepository.getCTBCDSByMaDaily(madaily);
    }

    public static ctbcds getCTBCDSByMaDailyAndMaBaoCaoDS(int madaily, int mabaocaods) {
        return ctbcdsRepository.getCTBCDSByMaDailyAndMaBaoCaoDS(madaily, mabaocaods);
    }

    public static List<ctbcds> createCTBCDS(int thang, int nam) {
        List<ctbcds> ctbcdsList = new ArrayList<ctbcds>();
        baocaodoanhso bcds = baoCaoDoanhSoRepository.getBaoCaoDoanhSoByThangAndNam(thang, nam);
        List<daily> dailyList = dailyRepository.getAllDaiLy();
        int tongtien = phieuXuatHangRepository.getTongByThangAndNam(thang, nam);

        for (daily daily : dailyList) {
            int sum1 = phieuXuatHangRepository.getTongTienByThangAndNamOfDaiLy(thang, nam, daily.getMadaily());
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
}
