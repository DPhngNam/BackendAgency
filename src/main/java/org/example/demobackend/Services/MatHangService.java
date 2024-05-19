package org.example.demobackend.Services;

import org.example.demobackend.Models.mathang;
import org.example.demobackend.Repository.MatHangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatHangService {
    private static MatHangRepository matHangRepository;

    @Autowired
    public MatHangService(MatHangRepository matHangRepository) {
        MatHangService.matHangRepository = matHangRepository;
    }

    public static mathang getMatHangById(int mamh) {
        return matHangRepository.getMatHangById(mamh);
    }

    public static Integer getDonGiaNhapByMaMH(int mamh) {
        return matHangRepository.getDonGiaNhapByMaMH(mamh);
    }

    public static Integer getDonGiaXuatByMaMH(int mamh) {
        return matHangRepository.getDonGiaXuatByMaMH(mamh);
    }

    public static boolean createMatHang(mathang newMatHang) {
        matHangRepository.save(newMatHang);
        return true;
    }

    public static List<mathang> getAllMatHang() {
        return matHangRepository.getAllMatHang();
    }
}
