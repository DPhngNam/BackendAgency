//package com.example.demo.Repository;
//
//import com.example.demo.Models.PhieuXuatHang.PhieuXuatHang;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.data.repository.CrudRepository;
//
//@EnableJpaRepositories
//public interface PhieuXuatHangRepository extends CrudRepository<PhieuXuatHang, Integer>{
//    @Query("SELECT pxh FROM PhieuXuatHang pxh WHERE pxh.maPhieuXuat = :maPhieuXuat")
//    Iterable<PhieuXuatHang> getPhieuXuatHangById(int maphieuxuathang);
//}
