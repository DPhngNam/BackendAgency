package org.example.demobackend.Services;

import org.example.demobackend.Repository.CongNoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CongNoService {
    private final CongNoRepository congNoRepository;
    @Autowired
    public CongNoService(CongNoRepository congNoRepository) {
        this.congNoRepository = congNoRepository;
    }
}
