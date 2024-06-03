package org.example.demobackend.Controller;

import org.example.demobackend.Models.thamso;
import org.example.demobackend.Services.ThamSoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/thamso")
public class ThamSoController {
    @Autowired
    private final ThamSoService thamSoService;

    public ThamSoController(ThamSoService thamSoService) {
        this.thamSoService = thamSoService;
    }

    @PostMapping("/addThamSo")
    public void addThamSo(@RequestBody thamso thamso) {
        thamSoService.addThamSo(thamso);
    }

    @PostMapping("/updateThamSo")
    public boolean updateThamSo(@RequestBody thamso thamso) {
        return thamSoService.updateThamSo(thamso);
    }

    @GetMapping("/getThamSoValue")
    public int getThamSo(@RequestParam String tenthamso) {
        return thamSoService.getThamSo(tenthamso);
    }
}
