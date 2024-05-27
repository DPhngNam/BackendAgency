package org.example.demobackend.Services;

import org.example.demobackend.Models.*;
import org.example.demobackend.Repository.BaoCaoDoanhSoRepository;
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
    private static BaoCaoDoanhSoRepository baoCaoDoanhSoRepository;

    @Autowired
    public PhieuXuatHangService(PhieuXuatHangRepository phieuXuatHangRepository,DaiLyService dailyService, CongNoRepository congNoRepository, BaoCaoDoanhSoRepository baoCaoDoanhSoRepository) {
        this.phieuXuatHangRepository = phieuXuatHangRepository;
        this.dailyService = dailyService;
        this.congNoRepository = congNoRepository;
        this.baoCaoDoanhSoRepository = baoCaoDoanhSoRepository;
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

            updatePhatSinh(thang,nam, newPhieuXuatHang.getConlai(),newPhieuXuatHang.getMadaily());
            updateDoanhSo(thang,nam, newPhieuXuatHang.getTongtien());
            phieuXuatHangRepository.save(newPhieuXuatHang);
            return newPhieuXuatHang.getMapxuat();
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    private static void updatePhatSinh(int thang, int nam,int phatsinh, daily madaily){
        baocaocongno existingBCCN = congNoRepository.getCongNoByDaiLy(thang,nam,madaily.getMadaily());
        if (existingBCCN != null) {
            int oldPhatSinh = existingBCCN.getPhatSinh();
            int newPhatSinh = oldPhatSinh + phatsinh;
            existingBCCN.setPhatSinh(newPhatSinh);
            congNoRepository.save(existingBCCN);
        } else {
            baocaocongno newBCCN = new baocaocongno(new baocaocongnoID(thang,nam,madaily),0,0,phatsinh);
        }
    }

    private static void updateDoanhSo(int thang,int nam,int tiencongthem){
        baocaodoanhso existingBCDS = baoCaoDoanhSoRepository.getBaoCaoDoanhSoByThangAndNam(thang,nam);
        if (existingBCDS != null) {
            System.out.println("Found existing baocaodoanhso: " + existingBCDS);
            int tongtien = phieuXuatHangRepository.getTongByThangAndNam(thang, nam);
            existingBCDS.setTongdoanhthu(tongtien + tiencongthem);
            System.out.println("Saving updated baocaodoanhso: " + existingBCDS);
            baoCaoDoanhSoRepository.save(existingBCDS);
        } else {
            baoCaoDoanhSoRepository.save(new baocaodoanhso(thang,nam,tiencongthem));
        }
    }
}