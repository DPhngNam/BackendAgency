package com.example.demo.Controller;

import com.example.demo.Models.ctxh;
import com.example.demo.Models.phieuxuathang;
import com.example.demo.Services.PhieuXuatHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/phieuxuathang")
public class PhieuXuatHangController {
    @Autowired
    private final PhieuXuatHangService phieuXuatHangService;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public PhieuXuatHangController(PhieuXuatHangService phieuXuatHangService) {
        this.phieuXuatHangService = phieuXuatHangService;
    }

    @GetMapping (path="/pxhbyid")
    public ResponseEntity<phieuxuathang> getPhieuXuatHangById(@RequestParam int mapxuat) {
        phieuxuathang pxh = PhieuXuatHangService.getPhieuXuatHangById(mapxuat);
        if(pxh != null) {
            return new ResponseEntity<>(pxh, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping (path="/pxhbyngayxuat")
    public ResponseEntity<phieuxuathang> getAllPhieuXuatHangByNgayXuat(@RequestParam String ngaylp) {
        phieuxuathang pxh = PhieuXuatHangService.getAllPhieuXuatHangByNgayXuat(ngaylp);
        if(pxh != null) {
            return new ResponseEntity<>(pxh, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/createpxh")
    public ResponseEntity<String> createPhieuXuatHang(@RequestBody phieuxuathang newPhieuXuatHang) {
        if (PhieuXuatHangService.createPhieuXuatHang(newPhieuXuatHang)) {
            return new ResponseEntity<>("Created successfully!", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Created failed!", HttpStatus.BAD_REQUEST);
        }
    }
}