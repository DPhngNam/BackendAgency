package org.example.demobackend.Controller;

import org.example.demobackend.Models.quan;
import org.example.demobackend.Services.QuanService;
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
