package com.example.demo.Services;

import com.example.demo.Models.ctnh;
import com.example.demo.Repository.CTNHRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CTNHService {
    private static CTNHRepository ctnhRepository;

    @Autowired
    public CTNHService(CTNHRepository ctnhRepository) {
        this.ctnhRepository = ctnhRepository;
    }

    public static List<ctnh> getCTNHByMapNhap(int mapnhap) {
        return ctnhRepository.getCTNHByMapNhap(mapnhap);
    }

    public static List<ctnh> getCTNHByMaMH(int mamh) {
        return ctnhRepository.getCTNHByMaMH(mamh);
    }

    public static ctnh getCTNHByMapNhapAndMaMH(int mapnhap, int mamh) {
        return ctnhRepository.getCTNHByMapNhapAndMaMH(mapnhap, mamh);
    }

    public static boolean createCTNH(ctnh newCTNH) {
        try {
            ctnhRepository.save(newCTNH);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}