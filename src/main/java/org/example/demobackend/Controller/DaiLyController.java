package org.example.demobackend.Controller;


import org.example.demobackend.Models.daily;
import org.example.demobackend.Services.DaiLyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/daily") //https://still-cliffs-55450-6c9d6b2dff57.herokuapp.com/
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
        daily newDaiLy = daiLyService.insertDaiLy(daily);
        if (newDaiLy == null) {
            return null;
        }else {
            return newDaiLy;
        }
    }

    @GetMapping("/getSoNoDuocNoThem")
    public ResponseEntity<Integer> getSoNoDuocNoThem(@RequestParam int madaily) {
        int so_no_duoc_no_them = daiLyService.getSoNoDuocNoThem(madaily);
        if(so_no_duoc_no_them != -1) {
            return ResponseEntity.ok(so_no_duoc_no_them);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}