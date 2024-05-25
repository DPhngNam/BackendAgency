package org.example.demobackend.Controller;

import org.example.demobackend.Models.mathang;
import org.example.demobackend.Services.MatHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/mathang")
public class MatHangController {
    @Autowired
    private final MatHangService matHangService;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public MatHangController(MatHangService matHangService) {
        this.matHangService = matHangService;
    }

    @GetMapping (path="/mhbyid")
    public ResponseEntity<mathang> getMatHangById(@RequestParam int mamh) {
        mathang mh = MatHangService.getMatHangById(mamh);
        if(mh != null) {
            return new ResponseEntity<>(mh, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping (path="/dongianhap")
    public ResponseEntity<Integer> getDonGiaNhapByMaMH(@RequestParam int mamh) {
        Integer dongianhap = MatHangService.getDonGiaNhapByMaMH(mamh);
        if(dongianhap != null) {
            return new ResponseEntity<>(dongianhap, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping (path="/dongiaxuat")
    public ResponseEntity<Integer> getDonGiaXuatByMaMH(@RequestParam int mamh) {
        Integer dongiaxuat = MatHangService.getDonGiaXuatByMaMH(mamh);
        if(dongiaxuat != null) {
            return new ResponseEntity<>(dongiaxuat, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<mathang>> getAllMatHang() {
        List<mathang> mhList = MatHangService.getAllMatHang();
        if (!mhList.isEmpty()) {
            return new ResponseEntity<>(mhList, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/createmh")
    public ResponseEntity<Object> createMatHang(@RequestBody mathang newMatHang){

        if (MatHangService.createMatHang(newMatHang)) {
            return new ResponseEntity<>("Created successfully!", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Created failed!", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getSLT")
    public ResponseEntity<Integer> getSLT(@RequestParam String tenmh) {
        int slt = MatHangService.getSLTByTenmh(tenmh);
        if(slt != -1) {
            return new ResponseEntity<>(slt, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(-1, HttpStatus.NOT_FOUND);
        }
    }
}
