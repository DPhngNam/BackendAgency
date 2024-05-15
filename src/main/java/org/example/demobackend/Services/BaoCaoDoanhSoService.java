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

    public static baocaodoanhso getBaoCaoDoanhSoByMaBaoCaoDS(int mabaocaods) {
        return baoCaoDoanhSoRepository.getBaoCaoDoanhSoByMaBaoCaoDS(mabaocaods);
    }

    public static List<baocaodoanhso> getBaoCaoDoanhSoByThang(int thang) {
        return baoCaoDoanhSoRepository.getBaoCaoDoanhSoByThang(thang);
    }

    public static List<baocaodoanhso> getBaoCaoDoanhSoByNam(int nam) {
        return baoCaoDoanhSoRepository.getBaoCaoDoanhSoByNam(nam);
    }

    public static List<baocaodoanhso> getBaoCaoDoanhSoByThangAndNam(int thang, int nam) {
        return baoCaoDoanhSoRepository.getBaoCaoDoanhSoByThangAndNam(thang, nam);
    }

    public static int getThangByMaBaoCaoDS(int mabaocaods) {
        return baoCaoDoanhSoRepository.getThangByMaBaoCaoDS(mabaocaods);
    }

    public static int getNamByMaBaoCaoDS(int mabaocaods) {
        return baoCaoDoanhSoRepository.getNamByMaBaoCaoDS(mabaocaods);
    }

    public static Map<String, Integer> getThangAndNamByMaBaoCaoDS(int mabaocaods) {
        return baoCaoDoanhSoRepository.getThangAndNamByMaBaoCaoDS(mabaocaods);
    }

    public static baocaodoanhso createBaoCaoDoanhSo(int thang, int nam) {
        List<phieuxuathang> pxhList = phieuXuatHangRepository.getAllPhieuXuatHangByThangAndNamOfNgayLP(thang, nam);
        int tongdoanhthu = pxhList.stream().mapToInt(phieuxuathang::getTongtien).sum();
        baocaodoanhso bcds = new baocaodoanhso(thang, nam, tongdoanhthu);
        baoCaoDoanhSoRepository.save(bcds);
        return bcds;
    }
}