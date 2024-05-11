package com.example.demo.Repository;

import com.example.demo.Models.phieuthutien;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

@EnableJpaRepositories
public interface PTTRepository extends CrudRepository<phieuthutien, Integer> {
    @Query("SELECT p FROM phieuthutien p WHERE p.maphieuthu = :maPhieuThu")
    Iterable<phieuthutien> getPhieuThuTienById(@Param("maPhieuThu") int maPhieuThu);

    @Query("SELECT p FROM phieuthutien p WHERE p.madaily = :madaily")
    Iterable<phieuthutien> getPhieuThuTienByDaiLyId(@Param("madaily") int madaily);


}
