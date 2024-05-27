package org.example.demobackend.Repository;

import org.example.demobackend.Models.DaiLyInfo;
import org.example.demobackend.Models.daily;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

@EnableJpaRepositories
public interface DaiLyRepository extends CrudRepository<daily, Integer> {
    @Query("SELECT d FROM daily d WHERE d.madaily = :madaily")
    daily getDaiLyById(@Param("madaily") int madaily);

    @Query("SELECT d FROM daily d WHERE d.tendaily = :tendaily")
    daily getAllDaiLyByTenDaiLy(@Param("tendaily") String tendaily);

    @Query("SELECT d FROM daily d WHERE d.diachi = :diachi")
    daily getAllDaiLyByDiaChi(@Param("diachi") String diachi);

    @Query("SELECT new org.example.demobackend.Models.daily(d.madaily  ,d.tendaily)  FROM daily d ")
    List<daily> getAllDaiLyIdAndName();


    @Query("SELECT d FROM daily d ")
    List<daily> getAllDaiLy();

    @Query("SELECT COUNT (*) FROM daily d WHERE d.maquan.maquan = :maquan ")
    int countDaiLyByLoaiDaiLy(@Param("maquan") int maquan);

    @Query("SELECT d FROM daily d WHERE d.madaily = :madaily ")
    List<daily> getDaiLyTienNo(@Param("madaily") int madaily);

}