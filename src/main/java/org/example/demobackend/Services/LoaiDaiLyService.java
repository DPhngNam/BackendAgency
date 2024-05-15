package org.example.demobackend.Services;

import org.example.demobackend.Models.loaidaily;
import org.example.demobackend.Repository.LoaiDaiLyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoaiDaiLyService {
    private final LoaiDaiLyRepository loaiDaiLyRepository;
    @Autowired
    public LoaiDaiLyService(LoaiDaiLyRepository loaiDaiLyRepository) {
        this.loaiDaiLyRepository = loaiDaiLyRepository;
    }
    public Iterable<loaidaily> getLoaiDaiLyRepository() {
        return loaiDaiLyRepository.findAll();
    }
}
