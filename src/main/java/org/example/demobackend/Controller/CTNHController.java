package org.example.demobackend.Controller;

import org.example.demobackend.Models.ctnh;
import org.example.demobackend.Models.mathang;
import org.example.demobackend.Services.CTNHService;
import org.example.demobackend.Services.MatHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

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
    public ResponseEntity<List<ctnh>> getCTNHByMapNhap(@RequestParam int mapnhap) {
        List<ctnh> ctnhList = CTNHService.getCTNHByMapNhap(mapnhap);
        if (!ctnhList.isEmpty()) {
            return new ResponseEntity<>(ctnhList, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/ctnhbymamh")
    public ResponseEntity<List<ctnh>> getCTNHByMaMH(@RequestParam int mamh) {
        List<ctnh> ctnhList = CTNHService.getCTNHByMaMH(mamh);
        if (!ctnhList.isEmpty()) {
            return new ResponseEntity<>(ctnhList, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/ctnhbymapnhapandmamh")
    public ResponseEntity<ctnh> getCTNHByMapNhapAndMaMH(@RequestParam int mapnhap, @RequestParam int mamh) {
        ctnh ctnh = CTNHService.getCTNHByMapNhapAndMaMH(mapnhap, mamh);
        if (ctnh != null) {
            return new ResponseEntity<>(ctnh, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/createctnh")
    public ResponseEntity<String> createCTNH(@RequestBody List<ctnh> newCTNHList) {
        for (ctnh newCTNH : newCTNHList) {
            mathang mh = MatHangService.getMatHangById(newCTNH.getMamh().getMamh());
            if (mh == null) {
                return new ResponseEntity<>("No mathang found with the provided mamh", HttpStatus.BAD_REQUEST);
            }

            newCTNH.setDongianhap(mh.getDongianhap());
            newCTNH.setThanhtien(newCTNH.getDongianhap() * newCTNH.getSlnhap());

            newCTNH.setDvt(mh.getDvt().getMadvt());
            if (!CTNHService.createCTNH(newCTNH)) {
                return new ResponseEntity<>("Creation failed for ctnh with mamh: " + newCTNH.getMamh(), HttpStatus.BAD_REQUEST);
            }
        }
        return new ResponseEntity<>("Created successfully!", HttpStatus.CREATED);
    }
}