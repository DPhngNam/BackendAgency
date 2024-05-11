package com.example.demo.Repository;

import com.example.demo.Models.phieuxuathang;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

@EnableJpaRepositories
public interface PhieuXuatHangRepository extends CrudRepository<phieuxuathang, Integer> {
    @Query("SELECT pxh FROM phieuxuathang pxh WHERE pxh.maphieuxuat = :maphieuxuat")
    phieuxuathang getPhieuXuatHangById(@Param("maphieuxuat") int maphieuxuat);

    @Query("SELECT pxh FROM phieuxuathang pxh WHERE pxh.ngaylp = :ngaylp")
    phieuxuathang getAllPhieuXuatHangByNgayLp(@Param("ngaylp") String ngaylp);
}