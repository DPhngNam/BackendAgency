package org.example.demobackend.Controller;

import org.example.demobackend.Models.phieuxuathang;
import org.example.demobackend.Services.PhieuXuatHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<Integer> createPhieuXuatHang(@RequestBody phieuxuathang newPhieuXuatHang) {
        int id = PhieuXuatHangService.createPhieuXuatHang(newPhieuXuatHang);
        if (id != -1) {
            return new ResponseEntity<>(id, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(-1, HttpStatus.BAD_REQUEST);
        }
    }
}