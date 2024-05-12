package com.example.demo.Controller;

import com.example.demo.Models.ctnh;
import com.example.demo.Services.CTNHService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;

@RestController
@RequestMapping("/ctnh")
public class CTNHController {
    @Autowired
    private final CTNHService ctnhService;

    @Autowired
    private JdbcTemplate jdbcTemplate;
    public CTNHController(CTNHService ctnhService) {
        this.ctnhService = ctnhService;
    }

    @GetMapping("/ctnhbymapnhap")
    public ResponseEntity<ctnh> getCTNHByMapNhap(@RequestParam int mapnhap) {
        ctnh ctnh = CTNHService.getCTNHByMapNhap(mapnhap);
        if (ctnh != null) {
            return new ResponseEntity<>(ctnh, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/ctnhbymamh")
    public ResponseEntity<ctnh> getCTNHByMaMH(@RequestParam int mamh) {
        ctnh ctnh = CTNHService.getCTNHByMaMH(mamh);
        if (ctnh != null) {
            return new ResponseEntity<>(ctnh, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/createctnh")
    public ResponseEntity<String> createCTNH(@RequestBody ctnh newCTNH) {
        if (CTNHService.createCTNH(newCTNH)) {
            return new ResponseEntity<>("Created successfully!", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Created failed!", HttpStatus.BAD_REQUEST);
        }
    }
}
