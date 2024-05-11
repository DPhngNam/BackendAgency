package com.example.demo.Repository;

import com.example.demo.Models.loaidaily;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
public interface LoaiDaiLyRepository extends JpaRepository<loaidaily, Integer> {

}
