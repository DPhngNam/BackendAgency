package org.example.demobackend.Controller;


import org.example.demobackend.Models.phieuthutien;
import org.example.demobackend.Services.MatHangService;
import org.example.demobackend.Services.PTTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> addPhieuThuTien(@RequestBody phieuthutien phieuthutien) {
        if ( pttService.insertPhieuThuTien(phieuthutien)) {
            return new ResponseEntity<>("Created successfully!", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Created failed!", HttpStatus.BAD_REQUEST);
        }
    }
}
