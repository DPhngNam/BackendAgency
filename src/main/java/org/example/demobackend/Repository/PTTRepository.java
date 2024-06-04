package org.example.demobackend.Repository;

import org.example.demobackend.Models.daily;
import org.example.demobackend.Models.phieuthutien;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

@EnableJpaRepositories
public interface PTTRepository extends CrudRepository<phieuthutien, Integer> {
    @Query("SELECT p FROM phieuthutien p WHERE p.maphieuthu = :maPhieuThu")
    phieuthutien getPhieuThuTienById(@Param("maPhieuThu") int maPhieuThu);

    @Query("SELECT p FROM phieuthutien p WHERE p.madaily = :madaily")
    Iterable<phieuthutien> getPhieuThuTienByDaiLyId(@Param("madaily") int madaily);

    @Modifying
    @Query("DELETE FROM phieuthutien p WHERE p.madaily.madaily = :madaily")
    void deleteByMadaily(@Param("madaily") int madaily);
}
