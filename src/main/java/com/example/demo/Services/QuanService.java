package com.example.demo.Services;

import com.example.demo.Models.quan;
import com.example.demo.Repository.QuanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuanService {

    private final QuanRepository quanRepository;
    @Autowired
    public QuanService(QuanRepository quanRepository) {
        this.quanRepository = quanRepository;
    }
    public Iterable<quan> getAllQuan() {
        return quanRepository.findAll();
    }
}
