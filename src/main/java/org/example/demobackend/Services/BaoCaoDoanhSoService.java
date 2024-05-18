package org.example.demobackend.Services;

import org.example.demobackend.Models.baocaodoanhso;
import org.example.demobackend.Models.ctbcds;
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

    public static List<Integer> getMaBaoCaoDSByThangAndNam(int thang, int nam) {
        return baoCaoDoanhSoRepository.getMaBaoCaoDSByThangAndNam(thang, nam);
    }

    public static baocaodoanhso createBaoCaoDoanhSo(baocaodoanhso newBaoCaoDoanhSo) {
        int thang = newBaoCaoDoanhSo.getThang();
        int nam = newBaoCaoDoanhSo.getNam();
        int maBaoCaoDS = newBaoCaoDoanhSo.getMabaocaods();
        List<Integer> maBaoCaoDSList = getMaBaoCaoDSByThangAndNam(thang, nam);
        if (maBaoCaoDSList.contains(maBaoCaoDS)) {
            List<ctbcds> ctbcdsList = CTBCDSService.getCTBCDSByMaBaoCaoDS(maBaoCaoDS);
            int tongdoanhthu = ctbcdsList.stream().mapToInt(ctbcds::getTongtrigia).sum();
            newBaoCaoDoanhSo.setTongdoanhthu(tongdoanhthu);
        }
        else {
            newBaoCaoDoanhSo.setTongdoanhthu(0);
        }
        baoCaoDoanhSoRepository.save(newBaoCaoDoanhSo);
        return newBaoCaoDoanhSo;
    }
}