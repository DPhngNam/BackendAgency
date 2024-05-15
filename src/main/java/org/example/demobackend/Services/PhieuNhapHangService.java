package org.example.demobackend.Services;


import org.example.demobackend.Models.phieunhaphang;
import org.example.demobackend.Repository.PhieuNhapHangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class PhieuNhapHangService {
    private static PhieuNhapHangRepository phieuNhapHangRepository;

    @Autowired
    public PhieuNhapHangService(PhieuNhapHangRepository phieuNhapHangRepository) {
        this.phieuNhapHangRepository = phieuNhapHangRepository;
    }

    public static phieunhaphang getPhieuNhapHangById(int maphieunhap) {
        return phieuNhapHangRepository.getPhieuNhapHangById(maphieunhap);
    }

    public static phieunhaphang getAllPhieuNhapHangByNgayNhap(String ngaylp) {
        return phieuNhapHangRepository.getAllPhieuNhapHangByNgayLp(ngaylp);
    }

    public static boolean createPhieuNhapHang(phieunhaphang newPhieuNhapHang) {
        try {
            phieuNhapHangRepository.save(newPhieuNhapHang);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
