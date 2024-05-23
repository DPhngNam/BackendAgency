package org.example.demobackend.Controller;

import org.example.demobackend.Models.ctbcds;
import org.example.demobackend.Services.CTBCDSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ctbcds")
public class CTBCDSController {
    @Autowired
    private final CTBCDSService ctbcdsService;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public CTBCDSController(CTBCDSService ctbcdsService) {
        this.ctbcdsService = ctbcdsService;
    }

    @GetMapping ("/ctbcdsbymabaocaods")
    public ResponseEntity<List<ctbcds>> getCTBCDSByMaBaoCaoDS(@RequestParam int mabaocaods) {
        List<ctbcds> ctbcdsList = CTBCDSService.getCTBCDSByMaBaoCaoDS(mabaocaods);
        if (!ctbcdsList.isEmpty()) {
            return new ResponseEntity<>(ctbcdsList, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping ("/ctbcdsbymadaily")
    public ResponseEntity<List<ctbcds>> getCTBCDSByMaDaily(@RequestParam int madaily) {
        List<ctbcds> ctbcdsList = CTBCDSService.getCTBCDSByMaDaily(madaily);
        if (!ctbcdsList.isEmpty()) {
            return new ResponseEntity<>(ctbcdsList, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }




}