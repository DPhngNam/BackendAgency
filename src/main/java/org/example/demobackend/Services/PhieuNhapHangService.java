package org.example.demobackend.Services;

import org.example.demobackend.Models.ctnh;
import org.example.demobackend.Models.phieunhaphang;
import org.example.demobackend.Repository.CTNHRepository;
import org.example.demobackend.Repository.PhieuNhapHangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhieuNhapHangService {
    private static PhieuNhapHangRepository phieuNhapHangRepository;
    private static CTNHRepository ctnhRepository;


    @Autowired
    public PhieuNhapHangService(PhieuNhapHangRepository phieuNhapHangRepository,
                                CTNHRepository ctnhRepository) {
        this.phieuNhapHangRepository = phieuNhapHangRepository;
        this.ctnhRepository = ctnhRepository;
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
    public String deletePhieuNhapHang(int mapnhap) {
        try {
            phieuNhapHangRepository.deleteById(mapnhap);
            List<ctnh> ctnhList = ctnhRepository.getCTNHByMapNhap(mapnhap);
            for (ctnh ctnh : ctnhList) {
                MatHangService.downSLT(ctnh.getMamh(), ctnh.getSlnhap());
                ctnhRepository.deleteCTNH(ctnh.getMamh().getMamh(), mapnhap);
            }
            return "Xóa phiếu nhập hàng thành công";
        } catch (Exception e) {
            e.printStackTrace();
            return "Xóa phiếu nhập hàng thất bại";
        }
    }

}