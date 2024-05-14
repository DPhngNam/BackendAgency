package com.example.demo.Controller;

import com.example.demo.Models.*;

import com.example.demo.Services.DaiLyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/daily") //http://localhost:8080/daily
public class DaiLyController {
    @Autowired
    private final DaiLyService daiLyService;

    public DaiLyController(DaiLyService daiLyService) {
        this.daiLyService = daiLyService;
    }

    @GetMapping("/getAllDaiLy")
    public Iterable<daily> getAllDaiLy() {
        return daiLyService.getAllDaiLy();
    }



    @PostMapping("/addDaiLy")
    public daily addDaiLy(@RequestBody daily daily) {
        return daiLyService.insertDaiLy(daily);
    }

}

