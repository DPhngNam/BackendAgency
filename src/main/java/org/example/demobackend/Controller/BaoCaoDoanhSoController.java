package org.example.demobackend.Controller;

import org.example.demobackend.Models.baocaodoanhso;
import org.example.demobackend.Services.BaoCaoDoanhSoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/baocaodoanhso")
public class BaoCaoDoanhSoController {
    @Autowired
    private final BaoCaoDoanhSoService baoCaoDoanhSoService;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public BaoCaoDoanhSoController(BaoCaoDoanhSoService baoCaoDoanhSoService) {
        this.baoCaoDoanhSoService = baoCaoDoanhSoService;
    }

    @GetMapping ("/bcdsbymabaocaods")
    public ResponseEntity<baocaodoanhso> getBaoCaoDoanhSoByMaBaoCaoDS(@RequestParam int mabaocaods) {
        baocaodoanhso bcds = BaoCaoDoanhSoService.getBaoCaoDoanhSoByMaBaoCaoDS(mabaocaods);
        if (bcds != null) {
            return new ResponseEntity<>(bcds, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping ("/bcdsbythang")
    public ResponseEntity<List<baocaodoanhso>> getBaoCaoDoanhSoByThang(@RequestParam int thang) {
        List<baocaodoanhso> bcdsList = BaoCaoDoanhSoService.getBaoCaoDoanhSoByThang(thang);
        if (!bcdsList.isEmpty()) {
            return new ResponseEntity<>(bcdsList, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping ("/bcdsbynam")
    public ResponseEntity<List<baocaodoanhso>> getBaoCaoDoanhSoByNam(@RequestParam int nam) {
        List<baocaodoanhso> bcdsList = BaoCaoDoanhSoService.getBaoCaoDoanhSoByNam(nam);
        if (!bcdsList.isEmpty()) {
            return new ResponseEntity<>(bcdsList, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping ("/bcdsbythangandnam")
    public ResponseEntity<baocaodoanhso> getBaoCaoDoanhSoByThangAndNam(@RequestParam int thang, @RequestParam int nam) {
        baocaodoanhso bcdsList = BaoCaoDoanhSoService.getBaoCaoDoanhSoByThangAndNam(thang, nam);
        if (bcdsList != null) {
            return new ResponseEntity<>(bcdsList, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/createbaocaodoanhso")
    public ResponseEntity<String> createBaoCaoDoanhSo(@RequestParam int thang, @RequestParam int nam, @RequestParam int tongdoanhthu) {
        baocaodoanhso bcds = BaoCaoDoanhSoService.createBaoCaoDoanhSo(thang, nam);
        return new ResponseEntity<>("Created successfully!", HttpStatus.CREATED);
    }
}
