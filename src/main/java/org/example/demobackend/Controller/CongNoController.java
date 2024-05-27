package org.example.demobackend.Controller;

import org.example.demobackend.Models.baocaocongno;
import org.example.demobackend.Services.CongNoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/congno")
public class CongNoController {
    @Autowired
    private final CongNoService congNoService;

    public CongNoController(CongNoService congNoService) {
        this.congNoService = congNoService;
    }

    @GetMapping("/getCongNo")
    public ResponseEntity<List<baocaocongno>> getCongNo(@RequestParam int thang, @RequestParam int nam) {
        List<baocaocongno> bccnList = congNoService.getCongNo(thang, nam);
        if (!bccnList.isEmpty()) {
            return new ResponseEntity<>(bccnList, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/autoCreateBaoCaoCongNo")
    public ResponseEntity<String> autoCreateBaoCaoCongNo(@RequestBody baocaocongno bccn) {
        congNoService.createCongNo(bccn);
        return new ResponseEntity<>("Báo cáo công nợ đã được tạo", HttpStatus.OK);
    }
}
