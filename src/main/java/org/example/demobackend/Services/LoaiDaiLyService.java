package org.example.demobackend.Services;

import org.example.demobackend.Models.loaidaily;
import org.example.demobackend.Repository.LoaiDaiLyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoaiDaiLyService {
    private static LoaiDaiLyRepository loaiDaiLyRepository;
    @Autowired
    public LoaiDaiLyService(LoaiDaiLyRepository loaiDaiLyRepository) {
        this.loaiDaiLyRepository = loaiDaiLyRepository;
    }



    public static List<loaidaily> getLoaiDaiLyRepository() {
        return (List<loaidaily>) loaiDaiLyRepository.findAll();
    }
}
