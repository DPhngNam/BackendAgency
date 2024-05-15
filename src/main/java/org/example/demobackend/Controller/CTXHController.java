package org.example.demobackend.Controller;

import org.example.demobackend.Models.ctxh;
import org.example.demobackend.Models.mathang;
import org.example.demobackend.Services.CTXHService;
import org.example.demobackend.Services.MatHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<List<ctxh>> getCTXHByMapXuat(@RequestParam int mapxuat) {
        List<ctxh> ctxhList = CTXHService.getCTXHByMapXuat(mapxuat);
        if (!ctxhList.isEmpty()) {
            return new ResponseEntity<>(ctxhList, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/ctxhbymamh")
    public ResponseEntity<List<ctxh>> getCTXHByMaMH(@RequestParam int mamh) {
        List<ctxh> ctxhList = CTXHService.getCTXHByMaMH(mamh);
        if (!ctxhList.isEmpty()) {
            return new ResponseEntity<>(ctxhList, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/ctxhbymapxuatandmamh")
    public ResponseEntity<ctxh> getCTXHByMapXuatAndMaMH(@RequestParam int mapxuat, @RequestParam int mamh) {
        ctxh ctxh = CTXHService.getCTXHByMapXuatAndMaMH(mapxuat, mamh);
        if (ctxh != null) {
            return new ResponseEntity<>(ctxh, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/createctxh")
    public ResponseEntity<String> createCTXH(@RequestBody List<ctxh> newCTXHList) {
        for (ctxh newCTXH : newCTXHList) {
            mathang mh = MatHangService.getMatHangById(newCTXH.getMamh());
            if (mh == null) {
                return new ResponseEntity<>("No mathang found with the provided mamh", HttpStatus.BAD_REQUEST);
            }
            newCTXH.setDongiaxuat(mh);
            if (!CTXHService.createCTXH(newCTXH)) {
                return new ResponseEntity<>("Creation failed for ctxh with mamh: " + newCTXH.getMamh(), HttpStatus.BAD_REQUEST);
            }
        }
        return new ResponseEntity<>("Created successfully!", HttpStatus.CREATED);
    }
}