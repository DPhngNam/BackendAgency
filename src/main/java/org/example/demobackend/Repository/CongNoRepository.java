package org.example.demobackend.Repository;

import org.example.demobackend.Models.baocaocongno;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

@EnableJpaRepositories
public interface CongNoRepository extends CrudRepository<baocaocongno, Integer>{
    @Query("SELECT bccn FROM baocaocongno bccn WHERE bccn.baocaocongnoID.thang = :thang AND bccn.baocaocongnoID.nam = :nam")
    List<baocaocongno> getCongNo(@Param("thang") int thang, @Param("nam") int nam);


    @Query("SELECT bccn FROM baocaocongno bccn WHERE bccn.baocaocongnoID.thang = :thang AND bccn.baocaocongnoID.nam = :nam AND bccn.baocaocongnoID.madaily.madaily = :madaily")
    baocaocongno getCongNoByDaiLy(@Param("thang") int thang, @Param("nam") int nam, @Param("madaily") int madaily);


    @Query("SELECT bccn FROM baocaocongno bccn WHERE bccn.baocaocongnoID.madaily.madaily = :madaily")
    List<baocaocongno> getCongNoByDaiLy(@Param("madaily") int madaily);

    @Modifying
    @Query("DELETE FROM baocaocongno bccn WHERE bccn.baocaocongnoID.madaily.madaily = :madaily")
    void deleteByMadaily(@Param("madaily") int madaily);
}
