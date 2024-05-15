package org.example.demobackend.Repository;

import org.example.demobackend.Models.phieuxuathang;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

@EnableJpaRepositories
public interface PhieuXuatHangRepository extends CrudRepository<phieuxuathang, Integer> {
    @Query("SELECT pxh FROM phieuxuathang pxh WHERE pxh.mapxuat = :mapxuat")
    phieuxuathang getPhieuXuatHangById(@Param("mapxuat") int mapxuat);

    @Query("SELECT pxh FROM phieuxuathang pxh WHERE pxh.ngaylp = :ngaylp")
    phieuxuathang getAllPhieuXuatHangByNgayLp(@Param("ngaylp") String ngaylp);

    @Query("SELECT pxh FROM phieuxuathang pxh WHERE MONTH(pxh.ngaylp) = :thang AND YEAR(pxh.ngaylp) = :nam")
    List<phieuxuathang> getAllPhieuXuatHangByThangAndNamOfNgayLP(@Param("thang") int thang, @Param("nam") int nam);

    @Query("SELECT COUNT(pxh) FROM phieuxuathang pxh WHERE MONTH(pxh.ngaylp) = :thang AND YEAR(pxh.ngaylp) = :nam")
    int getSoPhieuXuatByThangAndNamOfNgayLP(@Param("thang") int thang, @Param("nam") int nam);
}