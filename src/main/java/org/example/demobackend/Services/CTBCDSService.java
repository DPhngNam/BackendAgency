package org.example.demobackend.Services;

import org.example.demobackend.Models.ctbcds;
import org.example.demobackend.Models.daily;
import org.example.demobackend.Models.phieuxuathang;
import org.example.demobackend.Repository.BaoCaoDoanhSoRepository;
import org.example.demobackend.Repository.CTBCDSRepository;
import org.example.demobackend.Repository.PhieuXuatHangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CTBCDSService {
    private static CTBCDSRepository ctbcdsRepository;
    private static PhieuXuatHangRepository phieuXuatHangRepository;
    private static BaoCaoDoanhSoRepository baoCaoDoanhSoRepository;

    @Autowired
    public CTBCDSService(CTBCDSRepository ctbcdsRepository, PhieuXuatHangRepository phieuXuatHangRepository, BaoCaoDoanhSoRepository baoCaoDoanhSoRepository) {
        this.ctbcdsRepository = ctbcdsRepository;
        this.phieuXuatHangRepository = phieuXuatHangRepository;
        this.baoCaoDoanhSoRepository = baoCaoDoanhSoRepository;
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

    public static List<ctbcds> createCTBCDS(List<ctbcds> newCTBCDSList) {
        try {
            for (ctbcds newCTBCDS : newCTBCDSList) {
                int thang = baoCaoDoanhSoRepository.getThangByMaBaoCaoDS(newCTBCDS.getMabaocaods().getMabaocaods());
                int nam = baoCaoDoanhSoRepository.getNamByMaBaoCaoDS(newCTBCDS.getMabaocaods().getMabaocaods());
                daily madaily = newCTBCDS.getMadaily();
                int sophieuxuat = phieuXuatHangRepository.getSoPhieuXuatByMaDailyAndThangAndNam(madaily, thang, nam);
                int tongtrigia = phieuXuatHangRepository.getTongTienPhieuXuatByMaDailyAndThangAndNam(madaily, thang, nam);
                int tongcactongtrigia = phieuXuatHangRepository.getTongTienPhieuXuatByThangAndNam(thang, nam);
                double tyle = (double) tongtrigia / tongcactongtrigia;
                newCTBCDS.setSophieuxuat(sophieuxuat);
                newCTBCDS.setTongtrigia(tongtrigia);
                newCTBCDS.setTyle(tyle);
                ctbcdsRepository.save(newCTBCDS);
            }
            return newCTBCDSList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
