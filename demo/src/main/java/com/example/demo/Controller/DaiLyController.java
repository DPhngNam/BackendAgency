package com.example.demo.Controller;

import com.example.demo.Models.daily;

import com.example.demo.Repository.DaiLyRepository;
import com.example.demo.Services.DaiLyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/daily")
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

    @GetMapping("/getAllDaiLyByPersonId")
    public Iterable<daily> getAllDaiLyByPersonId(@RequestParam String person_id) {
        return daiLyService.getAllDaiLyByPersonId(Integer.parseInt(person_id));
    }


}

