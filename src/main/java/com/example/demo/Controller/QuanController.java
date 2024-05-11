package com.example.demo.Controller;

import com.example.demo.Models.quan;
import com.example.demo.Services.QuanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/quan")
public class QuanController {
    @Autowired
    private final QuanService quanService;

    public QuanController(QuanService quanService) {
        this.quanService = quanService;
    }

    @GetMapping("/allQuan")
    public Iterable<quan> getAllQuan() {
        return quanService.getAllQuan();
    }
}
