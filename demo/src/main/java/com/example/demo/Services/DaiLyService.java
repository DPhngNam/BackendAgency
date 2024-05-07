package com.example.demo.Services;

import com.example.demo.Models.daily;
import com.example.demo.Repository.DaiLyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DaiLyService {
    private final DaiLyRepository daiLyRepository;

    @Autowired
    public DaiLyService(DaiLyRepository daiLyRepository) {
        this.daiLyRepository = daiLyRepository;
    }

    public Iterable<daily> getAllDaiLy() {
        return daiLyRepository.findAll();
    }
}
