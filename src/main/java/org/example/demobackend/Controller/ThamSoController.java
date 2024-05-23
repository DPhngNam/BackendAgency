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

    @GetMapping("/getThamSo")
    public Iterable<thamso> getThamSo() {
        return thamSoService.getAllThamSo();
    }

    @PostMapping("/updateThamSo")
    public void updateThamSo(@RequestBody thamso thamso) {
        thamSoService.updateThamSo(thamso);
    }
}
