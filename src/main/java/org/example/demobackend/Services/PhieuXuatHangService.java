package org.example.demobackend.Services;

import org.example.demobackend.Models.daily;
import org.example.demobackend.Models.phieuthutien;
import org.example.demobackend.Models.phieuxuathang;
import org.example.demobackend.Repository.PhieuXuatHangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PhieuXuatHangService {
    private static PhieuXuatHangRepository phieuXuatHangRepository;
    private static DaiLyService dailyService;

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

    public static int getSoPhieuXuatByThangAndNamOfNgayLP(int thang, int nam) {
        return phieuXuatHangRepository.getSoPhieuXuatByThangAndNamOfNgayLP(thang, nam);
    }

    public static int createPhieuXuatHang(phieuxuathang newPhieuXuatHang) {
        try {
            int tienno_moi = newPhieuXuatHang.getTongtien() - newPhieuXuatHang.getSotientra();
            if(tienno_moi > 0){
                dailyService.updateSoNo(newPhieuXuatHang.getMadaily().getMadaily(), tienno_moi);
                phieuXuatHangRepository.save(newPhieuXuatHang);
            }
            return newPhieuXuatHang.getMapxuat();
        } catch (Exception e) {
            return -1;
        }
    }

}