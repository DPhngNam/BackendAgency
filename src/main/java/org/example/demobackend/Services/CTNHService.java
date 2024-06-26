package org.example.demobackend.Services;

import org.example.demobackend.Models.ctnh;
import org.example.demobackend.Models.phieunhaphang;
import org.example.demobackend.Repository.CTNHRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CTNHService {
    private static CTNHRepository ctnhRepository;

    @Autowired
    public CTNHService(CTNHRepository ctnhRepository) {
        this.ctnhRepository = ctnhRepository;
    }

    public static List<ctnh> getCTNHByMapNhap(int mapnhap) {
        return ctnhRepository.getCTNHByMapNhap(mapnhap);
    }

    public static List<ctnh> getCTNHByMaMH(int mamh) {
        return ctnhRepository.getCTNHByMaMH(mamh);
    }

    public static ctnh getCTNHByMapNhapAndMaMH(int mapnhap, int mamh) {
        return ctnhRepository.getCTNHByMapNhapAndMaMH(mapnhap, mamh);
    }
    public static boolean createCTNH(ctnh newCTNH) {
        try {
            phieunhaphang existingPhieuNhapHang = PhieuNhapHangService.getPhieuNhapHangById(newCTNH.getMapnhap().getMapnhap());
            if (existingPhieuNhapHang != null) {
                ctnhRepository.save(newCTNH);
                updateMatHang(newCTNH);
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }
    static void updateMatHang(ctnh ctnh) {
        MatHangService.upSLT(ctnh.getMamh(),ctnh.getSlnhap());
    }
}