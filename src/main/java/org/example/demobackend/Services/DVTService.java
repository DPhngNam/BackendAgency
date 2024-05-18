package org.example.demobackend.Services;

import org.example.demobackend.Models.dvt;
import org.example.demobackend.Repository.DVTRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DVTService {
    private final DVTRepository dvtRepository;

    public DVTService(DVTRepository dvtRepository) {
        this.dvtRepository = dvtRepository;
    }

    public ResponseEntity<String> insertDVT(dvt dvt) {
        try {
            dvt existingDVT = dvtRepository.findByTendvt(dvt.getTendvt());
            if (existingDVT == null) {
                return ResponseEntity.ok("DVT already exists");
            } else {
                dvtRepository.save(dvt);
                return ResponseEntity.ok("DVT added successfully");
            }
        }catch (Exception e) {
            return ResponseEntity.badRequest().body("Error adding DVT"
                    + e.getMessage());
        }
    }
}
