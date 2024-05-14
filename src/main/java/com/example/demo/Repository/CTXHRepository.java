package com.example.demo.Repository;

import com.example.demo.Models.ctxh;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

@EnableJpaRepositories
public interface CTXHRepository extends CrudRepository<ctxh, Integer> {
    List<ctxh> findByMapxuat(int mapxuat);

    @Query("SELECT ctxh FROM ctxh ctxh WHERE ctxh.mapxuat = :mapxuat")
    List<ctxh> getCTXHByMapXuat(int mapxuat);

    @Query("SELECT ctxh FROM ctxh ctxh WHERE ctxh.mamh = :mamh")
    List<ctxh> getCTXHByMaMH(int mamh);
}
