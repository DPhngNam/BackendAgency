package com.example.demo.Controller;

import com.example.demo.Models.ctxh;
import com.example.demo.Models.mathang;
import com.example.demo.Services.CTXHService;
import com.example.demo.Services.MatHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ctxh")
public class CTXHController {
    @Autowired
    private final CTXHService ctxhService;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public CTXHController(CTXHService ctxhService) {
        this.ctxhService = ctxhService;
    }

    @GetMapping("/ctxhbymapxuat")
    public ResponseEntity<ctxh> getCTXHByMapXuat(@RequestParam int mapxuat) {
        ctxh ctxh = CTXHService.getCTXHByMapXuat(mapxuat);
        if (ctxh != null) {
            return new ResponseEntity<>(ctxh, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/ctxhbymamh")
    public ResponseEntity<ctxh> getCTXHByMaMH(@RequestParam int mamh) {
        ctxh ctxh = CTXHService.getCTXHByMaMH(mamh);
        if (ctxh != null) {
            return new ResponseEntity<>(ctxh, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/createctxh")
    public ResponseEntity<String> createCTXH(@RequestBody ctxh newCTXH) {
        mathang mh = MatHangService.getMatHangById(newCTXH.getMamh());
        if (mh == null) {
            return new ResponseEntity<>("No mathang found with the provided mamh", HttpStatus.BAD_REQUEST);
        }
        newCTXH.setDongiaxuat(mh);
        if (CTXHService.createCTXH(newCTXH)) {
            return new ResponseEntity<>("Created successfully!", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Created failed!", HttpStatus.BAD_REQUEST);
        }
    }

}
