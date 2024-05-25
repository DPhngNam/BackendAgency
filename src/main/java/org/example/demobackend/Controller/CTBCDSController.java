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








}