package com.example.demo.Services;

import com.example.demo.Models.phieuxuathang;
import com.example.demo.Repository.PhieuXuatHangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PhieuXuatHangService {
    private static PhieuXuatHangRepository phieuXuatHangRepository;

    @Autowired
    public PhieuXuatHangService(PhieuXuatHangRepository phieuXuatHangRepository) {
        this.phieuXuatHangRepository = phieuXuatHangRepository;
    }

    public static phieuxuathang getPhieuXuatHangById(int maphieuxuat) {
        return phieuXuatHangRepository.getPhieuXuatHangById(maphieuxuat);
    }

    public static phieuxuathang getAllPhieuXuatHangByNgayXuat(String ngaylp) {
        return phieuXuatHangRepository.getAllPhieuXuatHangByNgayLp(ngaylp);
    }

    public static boolean createPhieuXuatHang(phieuxuathang newPhieuXuatHang) {
        try {
            phieuXuatHangRepository.save(newPhieuXuatHang);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}