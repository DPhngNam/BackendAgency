package org.example.demobackend.Services;

import org.example.demobackend.Models.baocaocongno;
import org.example.demobackend.Models.daily;
import org.example.demobackend.Models.phieuthutien;
import org.example.demobackend.Models.phieuxuathang;
import org.example.demobackend.Repository.CongNoRepository;
import org.example.demobackend.Repository.PhieuXuatHangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;

@Service
public class PhieuXuatHangService {
    private static PhieuXuatHangRepository phieuXuatHangRepository;
    private static DaiLyService dailyService;
    private static CongNoRepository congNoRepository;

    @Autowired
    public PhieuXuatHangService(PhieuXuatHangRepository phieuXuatHangRepository,DaiLyService dailyService, CongNoRepository congNoRepository) {
        this.phieuXuatHangRepository = phieuXuatHangRepository;
        this.dailyService = dailyService;
        this.congNoRepository = congNoRepository;
        calendar = Calendar.getInstance();
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
    private static Calendar calendar;
    public static int createPhieuXuatHang(phieuxuathang newPhieuXuatHang) {
        try {
            if (!dailyService.updateSoNo( newPhieuXuatHang.getConlai(),newPhieuXuatHang.getMadaily().getMadaily())) {
                return -1;
            }
            calendar.setTime(newPhieuXuatHang.getNgaylp());
            int thang = calendar.get(Calendar.MONTH) + 1;
            int nam = calendar.get(Calendar.YEAR);
            updatePhatSinh(thang,nam, newPhieuXuatHang.getConlai(),newPhieuXuatHang.getMadaily().getMadaily());
            phieuXuatHangRepository.save(newPhieuXuatHang);
            return newPhieuXuatHang.getMapxuat();
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    private static void updatePhatSinh(int thang, int nam,int phatsinh, int madaily){
        baocaocongno existingBCCN = congNoRepository.getCongNoByDaiLy(madaily,thang,nam);
        if (existingBCCN != null) {
            int oldPhatSinh = existingBCCN.getPhatSinh();
            int newPhatSinh = oldPhatSinh + phatsinh;
            existingBCCN.setPhatSinh(newPhatSinh);
            congNoRepository.save(existingBCCN);

        }
    }
}