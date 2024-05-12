package com.example.demo.Repository;

import com.example.demo.Models.ctnh;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;

@EnableJpaRepositories
public interface CTNHRepository extends CrudRepository<ctnh, Integer> {
    @Query("SELECT ctnh FROM ctnh ctnh WHERE ctnh.mapnhap = :mapnhap")
    ctnh getCTNHByMapNhap(int mapnhap);

    @Query("SELECT ctnh FROM ctnh ctnh WHERE ctnh.mamh = :mamh")
    ctnh getCTNHByMaMH(int mamh);
}
