package org.example.demobackend.Repository;

import org.example.demobackend.Models.ctbcds;
import org.example.demobackend.Models.daily;
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

    @Query(value = "SELECT COUNT(*) FROM phieuxuathang pxh WHERE MONTH(pxh.ngaylp) = :thang AND YEAR(pxh.ngaylp) = :nam", nativeQuery = true)
    int getSoPhieuXuatByThangAndNamOfNgayLP(@Param("thang") int thang, @Param("nam") int nam);

    @Query(value = "SELECT pxh.madaily, MONTH(pxh.ngaylp) as thang, YEAR(pxh.ngaylp) as nam, SUM(pxh.tongtien)" +
                " FROM phieuxuathang pxh" +
                " WHERE pxh.madaily = :madaily AND MONTH(pxh.ngaylp) = :thang AND YEAR(pxh.ngaylp) = :nam" +
                " GROUP BY pxh.madaily, MONTH(pxh.ngaylp), YEAR(pxh.ngaylp)", nativeQuery = true)
    int getTongTienPhieuXuatByMaDailyAndThangAndNam(@Param("madaily") daily madaily, @Param("thang") int thang, @Param("nam") int nam);

    @Query(value = "SELECT pxh.madaily, MONTH(pxh.ngaylp) as thang, YEAR(pxh.ngaylp) as nam, COUNT(*) as sophieuxuat" +
            " FROM phieuxuathang pxh" +
            " WHERE pxh.madaily = :madaily AND MONTH(pxh.ngaylp) = :thang AND YEAR(pxh.ngaylp) = :nam" +
            " GROUP BY pxh.madaily, MONTH(pxh.ngaylp), YEAR(pxh.ngaylp)", nativeQuery = true)
    int getSoPhieuXuatByMaDailyAndThangAndNam(@Param("madaily") daily madaily, @Param("thang") int thang, @Param("nam") int nam);

    @Query(value = "SELECT SUM(pxh.tongtien)" +
                    " FROM phieuxuathang pxh" +
                    " WHERE MONTH(pxh.ngaylp) = :thang AND YEAR(pxh.ngaylp) = :nam" +
                    " GROUP BY MONTH(pxh.ngaylp), YEAR(pxh.ngaylp)", nativeQuery = true)
    int getTongTienPhieuXuatByThangAndNam(@Param("thang") int thang, @Param("nam") int nam);
}