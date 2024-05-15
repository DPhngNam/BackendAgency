package org.example.demobackend.Controller;

import org.example.demobackend.Models.phieunhaphang;
import org.example.demobackend.Services.PhieuNhapHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/phieunhaphang")
public class PhieuNhapHangController {
    @Autowired
    private final PhieuNhapHangService phieuNhapHangService;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public PhieuNhapHangController(PhieuNhapHangService phieuNhapHangService) {
        this.phieuNhapHangService = phieuNhapHangService;
    }

    @GetMapping (path="/pnhbyid")
    public ResponseEntity<phieunhaphang> getPhieuNhapHangById(@RequestParam int mapnhap) {
        phieunhaphang pnh = PhieuNhapHangService.getPhieuNhapHangById(mapnhap);
        if(pnh != null) {
            return new ResponseEntity<>(pnh, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping (path="/pnhbyngaynhap")
    public ResponseEntity<phieunhaphang> getAllPhieuNhapHangByNgayNhap(@RequestParam String ngaylp) {
        phieunhaphang pnh = PhieuNhapHangService.getAllPhieuNhapHangByNgayNhap(ngaylp);
        if(pnh != null) {
            return new ResponseEntity<>(pnh, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/createpnh")
    public ResponseEntity<String> createPhieuNhapHang(@RequestBody phieunhaphang newPhieuNhapHang){
        if (PhieuNhapHangService.createPhieuNhapHang(newPhieuNhapHang)) {
            return new ResponseEntity<>("Created successfully!", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Created failed!", HttpStatus.BAD_REQUEST);
        }
    }
}