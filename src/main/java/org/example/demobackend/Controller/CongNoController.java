package org.example.demobackend.Controller;

import org.example.demobackend.Models.baocaocongno;
import org.example.demobackend.Services.CongNoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
}
