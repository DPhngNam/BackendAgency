//package com.example.demo.Services;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class PhieuXuatHangService {
//    private static PhieuXuatHangService phieuXuatHangService;
//
//    @Autowired
//    public PhieuXuatHangService(PhieuXuatHangService phieuXuatHangService) {
//        this.phieuXuatHangService = phieuXuatHangService;
//    }
//
//    public static List<CTXH> getCTXHList() {
//        // Lấy ra từ Repository dạng List<CTXH> là Entity
//        List<CTXH> ctxhs = (List<CTXH>) phieuXuatHangService.findAll();
//
//        // Biển đổi List<Entity> thành List<Model> (xem ở constructor của CTXHModel có code copy dữ liệu)
//        List<CTXH> ctxhModels = StreamSupport.stream(ctxhs.spliterator(), false)
//                .collect(Collectors.toList());
//
//        return ctxhModels;
//    }
//
//}
