package org.example.demobackend.Controller;

import org.example.demobackend.Models.dvt;
import org.example.demobackend.Services.DVTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dvt")
public class DVTController {
    @Autowired
    private final DVTService dvtService;

    public DVTController(DVTService dvtService) {
        this.dvtService = dvtService;
    }

    @PostMapping("/addDVT")
    public ResponseEntity<String> addDVT(@RequestBody dvt dvt) {
        return dvtService.insertDVT(dvt);
    }

    @GetMapping("/getALLDVT")
    public Iterable<dvt> getAllDVT() {
        return dvtService.getAllDVT();
    }
}
