package org.example.demobackend.Repository;

import org.example.demobackend.Models.ctxh;
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
}