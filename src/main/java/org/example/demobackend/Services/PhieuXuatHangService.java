package org.example.demobackend.Services;

import org.example.demobackend.Models.phieuxuathang;
import org.example.demobackend.Repository.PhieuXuatHangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PhieuXuatHangService {
    private static PhieuXuatHangRepository phieuXuatHangRepository;

    @Autowired
    public PhieuXuatHangService(PhieuXuatHangRepository phieuXuatHangRepository) {
        this.phieuXuatHangRepository = phieuXuatHangRepository;
    }

    public static phieuxuathang getPhieuXuatHangById(int mapxuat) {
        return phieuXuatHangRepository.getPhieuXuatHangById(mapxuat);
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