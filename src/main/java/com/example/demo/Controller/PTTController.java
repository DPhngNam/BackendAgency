package com.example.demo.Controller;

import com.example.demo.Models.phieuthutien;
import com.example.demo.Services.PTTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/phieuthutien")
public class PTTController {
    @Autowired
    private final PTTService pttService;

    public PTTController(PTTService pttService) {
        this.pttService = pttService;
    }

    @GetMapping("/getAllPhieuThuTien")
    public Iterable<phieuthutien> getAllPhieuThuTien() {
        return pttService.getAllPhieuThuTien();
    }

    @GetMapping("/getPhieuThuTienById")
    public Iterable<phieuthutien> getPhieuThuTienById(int maphieuthu) {
        return pttService.getPhieuThuTienById(maphieuthu);
    }

    @GetMapping("/getPhieuThuTienByDaiLyId") //http://localhost:8080/phieuthutien/getPhieuThuTienByDaiLyId?maDaiLy=1
    public Iterable<phieuthutien> getPhieuThuTienByDaiLyId(int madaily) {
        return pttService.getPhieuThuTienByDaiLyId(madaily);
    }

    @PostMapping("/addPhieuThuTien")
    public phieuthutien addPhieuThuTien(@RequestBody phieuthutien phieuthutien) {
        return pttService.insertPhieuThuTien(phieuthutien);
    }
}
