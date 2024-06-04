package org.example.demobackend.Repository;

import org.example.demobackend.Models.ctbcds;
import org.example.demobackend.Models.ctxh;
import org.example.demobackend.Models.daily;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import java.util.List;

@EnableJpaRepositories
public interface CTXHRepository extends CrudRepository<ctxh, Integer> {
    @Query("SELECT ctxh FROM ctxh ctxh WHERE ctxh.mapxuat = :mapxuat")
    List<ctxh> getCTXHByMapXuat(@Param("mapxuat") int mapxuat);

    @Query("SELECT ctxh FROM ctxh ctxh WHERE ctxh.mamh = :mamh")
    List<ctxh> getCTXHByMaMH(@Param("mamh")int mamh);

    @Query("SELECT ctxh FROM ctxh ctxh WHERE ctxh.mapxuat = :mapxuat AND ctxh.mamh = :mamh")
    ctxh getCTXHByMapXuatAndMaMH(@Param("mapxuat") int mapxuat, @Param("mamh") int mamh);

    @Modifying
    @Query("DELETE FROM ctxh ctxh WHERE ctxh.mapxuat.mapxuat = :mapxuat")
    void deleteByMapxuat(@Param("mapxuat") int mapxuat);
    @Modifying
    @Query("DELETE FROM ctxh ctxh WHERE ctxh.mamh.mamh = :mamh AND ctxh.mapxuat.mapxuat = :mapxuat")
    void deleteCTXH(@Param("mamh") int mamh,@Param("mapxuat") int mapxuat);
}