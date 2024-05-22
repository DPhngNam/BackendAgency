package org.example.demobackend.Repository;

import org.example.demobackend.Models.thamso;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

@EnableJpaRepositories
public interface ThamSoRepository extends CrudRepository<thamso, Integer>{
    @Query("SELECT t FROM thamso t")
    List<thamso> getAllThamSo();

    @Query("SELECT t FROM thamso t WHERE t.tenthamso = :tenthamso")
    thamso getThamSoByTen(@Param("tenthamso") String tenthamso);
}
