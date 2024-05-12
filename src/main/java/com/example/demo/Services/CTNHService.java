package com.example.demo.Services;

import com.example.demo.Models.ctnh;
import com.example.demo.Repository.CTNHRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CTNHService {
    private static CTNHRepository ctnhRepository;

    @Autowired
    public CTNHService(CTNHRepository ctnhRepository) {
        this.ctnhRepository = ctnhRepository;
    }

    public static ctnh getCTNHByMapNhap(int mapnhap) {
        return ctnhRepository.getCTNHByMapNhap(mapnhap);
    }

    public static ctnh getCTNHByMaMH(int mamh) {
        return ctnhRepository.getCTNHByMaMH(mamh);
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
