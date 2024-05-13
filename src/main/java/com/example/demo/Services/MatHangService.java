package com.example.demo.Services;

import com.example.demo.Models.mathang;
import com.example.demo.Repository.MatHangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MatHangService {
    private static MatHangRepository matHangRepository;

    @Autowired
    public MatHangService(MatHangRepository matHangRepository) {
        this.matHangRepository = matHangRepository;
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
        try {
            matHangRepository.save(newMatHang);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
