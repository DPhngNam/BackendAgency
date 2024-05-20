package org.example.demobackend.Controller;

import org.example.demobackend.Models.loaidaily;
import org.example.demobackend.Services.LoaiDaiLyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/loaidaily")
public class LoaiDaiLyController {
    @Autowired
    private final LoaiDaiLyService loaiDaiLyService;
    public LoaiDaiLyController(LoaiDaiLyService loaiDaiLyService) {
        this.loaiDaiLyService = loaiDaiLyService;
    }

    @GetMapping("/loaidaily")
    public ResponseEntity<List<loaidaily>> showLoaiDaiLy() {
        List<loaidaily> loaidailyList = LoaiDaiLyService.getLoaiDaiLyRepository();
        if (!loaidailyList.isEmpty()) {
            return new ResponseEntity<>(loaidailyList, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

//    @PostMapping("/addLoaiDaiLy")
//    public ResponseEntity<String> addLoaiDaiLy(@RequestBody loaidaily newLoaiDaiLy) {
//        int code = LoaiDaiLyService.addLoaiDaiLy(newLoaiDaiLy);
//        if (code != -1) {
//            return new ResponseEntity<>("Thêm loại đại lý thành công", HttpStatus.CREATED);
//        } else {
//            return new ResponseEntity<>("Thêm loại đại lý thất bại", HttpStatus.BAD_REQUEST);
//        }
//    }
}
