package org.example.demobackend.Repository;

import org.example.demobackend.Models.ctnh;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.Mapping;

import java.util.List;

@EnableJpaRepositories
public interface CTNHRepository extends CrudRepository<ctnh, Integer> {
    @Query("SELECT ctnh FROM ctnh ctnh WHERE ctnh.mapnhap = :mapnhap")
    List<ctnh> getCTNHByMapNhap(@Param("mapnhap") int mapnhap);

    @Query("SELECT ctnh FROM ctnh ctnh WHERE ctnh.mamh = :mamh")
    List<ctnh> getCTNHByMaMH(@Param("mamh") int mamh);

    @Query("SELECT ctnh FROM ctnh ctnh WHERE ctnh.mapnhap = :mapnhap AND ctnh.mamh = :mamh")
    ctnh getCTNHByMapNhapAndMaMH(@Param("mapnhap") int mapnhap, @Param("mamh") int mamh);

    @Modifying
    @Query("DELETE FROM ctnh ctnh WHERE ctnh.mapnhap.mapnhap = :mapnhap AND ctnh.mamh.mamh = :mamh")
    void deleteCTNH(@Param("mapnhap") int mapnhap, @Param("mamh") int mamh);

}