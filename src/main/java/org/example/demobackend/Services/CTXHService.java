package com.example.demo.Services;

import com.example.demo.Models.ctxh;
import com.example.demo.Repository.CTXHRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CTXHService {
    private static CTXHRepository ctxhRepository;

    @Autowired
    public CTXHService(CTXHRepository ctxhRepository) {
        this.ctxhRepository = ctxhRepository;
    }

    public static List<ctxh> getCTXHByMapXuat(int mapxuat) {
        return ctxhRepository.getCTXHByMapXuat(mapxuat);
    }

    public static List<ctxh> getCTXHByMaMH(int mamh) {
        return ctxhRepository.getCTXHByMaMH(mamh);
    }

    public static ctxh getCTXHByMapXuatAndMaMH(int mapxuat, int mamh) {
        return ctxhRepository.getCTXHByMapXuatAndMaMH(mapxuat, mamh);
    }

    public static boolean createCTXH(ctxh newCTXH) {
        try {
            ctxhRepository.save(newCTXH);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}