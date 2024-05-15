package org.example.demobackend.Controller;//package com.example.demo.Controller;
//
//import com.example.demo.Repository.PhieuXuatHangRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.*;
//
//@Controller
//@RequestMapping("/phieuxuathang")
//public class PhieuXuatHangController {
//    @Autowired
//    private PhieuXuatHangRepository phieuXuatHangRepository;
//
//    @PostMapping("/add")
//    public @ResponseBody String addPhieuXuatHang(@RequestParam String string){
//        PXHBuilder builder = new PXHConcreteBuilder()
//                .setMaPhieuXuat(1)
//                .setNgayXuat("2021-01-01")
//                .setMaDaiLy(1)
//                .setTongTien(0)
//                .setSoTienTra(0)
//                .setConLai(0);
//
//        PhieuXuatHang pxh = builder.build();
//
//        phieuXuatHangRepository.save(pxh);
//        return "Saved";
//    }
//
//    @GetMapping(path="/all")
//    public @ResponseBody Iterable<PhieuXuatHang> getAllPhieuXuatHang(){
//        return phieuXuatHangRepository.findAll();
//    }
//}
