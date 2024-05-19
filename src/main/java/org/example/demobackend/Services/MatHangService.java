package org.example.demobackend.Services;

import org.example.demobackend.Models.dvt;
import org.example.demobackend.Models.mathang;
import org.example.demobackend.Repository.DVTRepository;
import org.example.demobackend.Repository.MatHangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatHangService {
    private static MatHangRepository matHangRepository;
    private static DVTRepository dvtRepository;

    @Autowired
    public MatHangService(MatHangRepository matHangRepository, DVTRepository dvtRepository) {

        this.matHangRepository = matHangRepository;
        this.dvtRepository = dvtRepository;
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
        dvt existingDVT = dvtRepository.findByTendvt(newMatHang.getDvt().getTendvt());
        if (existingDVT == null) {
            return false;
        }
        newMatHang.setDvt(existingDVT);
        matHangRepository.save(newMatHang);
        return true;
    }

    public static List<mathang> getAllMatHang() {
        return matHangRepository.getAllMatHang();
    }
}
