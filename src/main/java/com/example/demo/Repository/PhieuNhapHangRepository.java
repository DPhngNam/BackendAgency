package com.example.demo.Repository;

import com.example.demo.Models.phieunhaphang;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

@EnableJpaRepositories
public interface PhieuNhapHangRepository extends CrudRepository<phieunhaphang, Integer>{
    @Query("SELECT pnh FROM phieunhaphang pnh WHERE pnh.maphieunhap = :maphieunhap")
    phieunhaphang getPhieuNhapHangById(@Param("maphieunhap") int maphieunhap);

    @Query ("SELECT pnh FROM phieunhaphang pnh WHERE pnh.ngaylp = :ngaylp")
    phieunhaphang getAllPhieuNhapHangByNgayLp(@Param("ngaylp") String ngaylp);
}