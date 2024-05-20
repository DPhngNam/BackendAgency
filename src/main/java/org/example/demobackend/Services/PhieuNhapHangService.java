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

    public static phieunhaphang getPhieuNhapHangById(int mapnhap) {
        return phieuNhapHangRepository.getPhieuNhapHangById(mapnhap);
    }

    public static phieunhaphang getAllPhieuNhapHangByNgayNhap(String ngaylp) {
        return phieuNhapHangRepository.getAllPhieuNhapHangByNgayLp(ngaylp);
    }

    public static int createPhieuNhapHang(phieunhaphang newPhieuNhapHang) {
        try {
            phieunhaphang savedPhieuNhapHang = phieuNhapHangRepository.save(newPhieuNhapHang);
            return savedPhieuNhapHang.getMapnhap();
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

}