package org.example.demobackend.Services;


import org.example.demobackend.Models.quan;
import org.example.demobackend.Repository.QuanRepository;
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
