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
    private static ThamSoService thamSoService;

    @Autowired
    public MatHangService(MatHangRepository matHangRepository, DVTRepository dvtRepository, ThamSoService thamSoService) {
        this.matHangRepository = matHangRepository;
        this.dvtRepository = dvtRepository;
        this.thamSoService = thamSoService;

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

        newMatHang.setDongiaxuat(thamSoService.getThamSo("Tỷ lệ đơn giá xuất") * newMatHang.getDongianhap());

        matHangRepository.save(newMatHang);
        return true;
    }

    public static List<mathang> getAllMatHang() {
        return matHangRepository.getAllMatHang();
    }

    static void updateSLT(mathang mathang,int sl, int type){
        mathang temp = matHangRepository.getMatHangById(mathang.getMamh());
        switch (type){
            case 1:
                temp.setSlton(temp.getSlton() + sl);
                matHangRepository.save(temp);
                break;
            case 2:
                temp.setSlton(temp.getSlton() - sl);
                matHangRepository.save(temp);
                break;
        }
    }
}
