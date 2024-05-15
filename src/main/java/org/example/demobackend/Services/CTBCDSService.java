package org.example.demobackend.Services;

import org.example.demobackend.Models.ctbcds;
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

    public static void createCTBCDS(int madaily, int mabaocaods, int tongtrigia, double tyle) {
        int sophieuxuat = phieuXuatHangRepository.getSoPhieuXuatByThangAndNamOfNgayLP(baoCaoDoanhSoRepository.getThangByMaBaoCaoDS(mabaocaods), baoCaoDoanhSoRepository.getNamByMaBaoCaoDS(mabaocaods));
        ctbcds ctbcds = new ctbcds(madaily, mabaocaods, sophieuxuat, tongtrigia, tyle);
        ctbcdsRepository.save(ctbcds);
    }

}
