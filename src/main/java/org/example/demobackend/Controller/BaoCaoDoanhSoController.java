package org.example.demobackend.Controller;

import org.example.demobackend.Models.baocaodoanhso;
import org.example.demobackend.Models.ctbcds;
import org.example.demobackend.Services.BaoCaoDoanhSoService;
import org.example.demobackend.Services.CTBCDSService;
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



    public BaoCaoDoanhSoController(BaoCaoDoanhSoService baoCaoDoanhSoService) {
        this.baoCaoDoanhSoService = baoCaoDoanhSoService;
    }


    @GetMapping ("/bcdsbythangandnam")
    public ResponseEntity<List<ctbcds>> getBaoCaoDoanhSoByThangAndNam(@RequestParam int thang, @RequestParam int nam) {

        List<ctbcds> ctbcdsList = CTBCDSService.getCTBCDS(thang, nam);
        if (!ctbcdsList.isEmpty()) {
            ctbcdsList = CTBCDSService.createCTBCDS(thang, nam);
            return new ResponseEntity<>(ctbcdsList, HttpStatus.OK);
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
