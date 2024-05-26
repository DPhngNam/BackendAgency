package org.example.demobackend.Controller;


import org.example.demobackend.Models.daily;
import org.example.demobackend.Services.DaiLyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<daily> addDaiLy(@RequestBody daily daily) {
        daily newDaiLy = daiLyService.insertDaiLy(daily);
        if (newDaiLy == null) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }else {
            return new ResponseEntity<>(newDaiLy, HttpStatus.OK);
        }
    }

}