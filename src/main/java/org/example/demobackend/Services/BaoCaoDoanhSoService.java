package org.example.demobackend.Services;

import org.example.demobackend.Models.baocaodoanhso;
import org.example.demobackend.Models.phieuxuathang;
import org.example.demobackend.Repository.BaoCaoDoanhSoRepository;
import org.example.demobackend.Repository.PhieuXuatHangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class BaoCaoDoanhSoService {
    private static BaoCaoDoanhSoRepository baoCaoDoanhSoRepository;
    private static PhieuXuatHangRepository phieuXuatHangRepository;

    @Autowired
    public BaoCaoDoanhSoService(BaoCaoDoanhSoRepository baoCaoDoanhSoRepository, PhieuXuatHangRepository phieuXuatHangRepository) {
        this.baoCaoDoanhSoRepository = baoCaoDoanhSoRepository;
        this.phieuXuatHangRepository = phieuXuatHangRepository;
    }


    public static baocaodoanhso createBaoCaoDoanhSo(int thang, int nam) {
        List<phieuxuathang> pxhList = phieuXuatHangRepository.getAllPhieuXuatHangByThangAndNamOfNgayLP(thang, nam);
        baocaodoanhso bcds = new baocaodoanhso(thang, nam);
        int tongtien = phieuXuatHangRepository.getTongByThangAndNam(thang, nam);
        bcds.setTongdoanhthu(tongtien);
        baoCaoDoanhSoRepository.save(bcds);
        return bcds;
    }
}