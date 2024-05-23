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

import java.util.ArrayList;
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
    public ResponseEntity<Object> createCTXH(@RequestBody List<ctxh> newCTXHList) {
        List<ctxh> errorctxh = new ArrayList<ctxh>();
        for (ctxh newCTXH : newCTXHList) {
            mathang mh = MatHangService.getMatHangById(newCTXH.getMamh().getMamh());
            if (mh == null) {
                errorctxh.add(newCTXH);
                continue;
            }
            newCTXH.setDongiaxuat(mh.getDongiaxuat());
            if (!CTXHService.createCTXH(newCTXH)) {
                errorctxh.add(newCTXH);
            }
        }
        if(!errorctxh.isEmpty()) {
            return new ResponseEntity<>(errorctxh, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Created phieu xuat hang successfully!", HttpStatus.CREATED);
    }
}