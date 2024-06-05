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

    public static int getSLTByTenmh(String tenmh) {
        int slt = matHangRepository.getSLTByTenmh(tenmh);
        if ( slt != 0){
            return matHangRepository.getSLTByTenmh(tenmh);
        }
        return -1;
    }

    public static mathang createMatHang(mathang newMatHang) {
        dvt existingDVT = dvtRepository.findByTendvt(newMatHang.getDvt().getTendvt());
        if (existingDVT == null) {
            return null;
        }
        newMatHang.setDvt(existingDVT);
        newMatHang.setDongiaxuat(thamSoService.getThamSo("Tỷ lệ đơn giá xuất") * newMatHang.getDongianhap() / 100);
        return matHangRepository.save(newMatHang);

    }

    public static List<mathang> getAllMatHang() {
        return matHangRepository.getAllMatHang();
    }

    static void upSLT(mathang mathang,int sl){
        mathang temp = matHangRepository.getMatHangById(mathang.getMamh());
        temp.setSlton(temp.getSlton() + sl);
        matHangRepository.save(temp);
    }

    static Boolean downSLT(mathang mamh,int sl){
        mathang temp = matHangRepository.getMatHangById(mamh.getMamh());
        if(temp.getSlton() < sl){
            return false;
        }
        temp.setSlton(temp.getSlton() - sl);
        matHangRepository.save(temp);
        return true;
    }

    public static mathang updateMatHang(mathang newMatHang) {
        mathang existingMatHang = matHangRepository.getMatHangById(newMatHang.getMamh());
        if (existingMatHang != null) {
            existingMatHang.setTenmh(newMatHang.getTenmh());
            existingMatHang.setDongianhap(newMatHang.getDongianhap());
            existingMatHang.setDvt(dvtRepository.findByTendvt(newMatHang.getDvt().getTendvt()));
            matHangRepository.save(existingMatHang);
            return existingMatHang;
        }
        return null;
    }
}
