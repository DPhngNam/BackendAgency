package org.example.demobackend.Repository;

import org.example.demobackend.Models.baocaodoanhso;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import java.util.List;
import java.util.Map;

@EnableJpaRepositories
public interface BaoCaoDoanhSoRepository extends CrudRepository<baocaodoanhso, Integer> {

    @Query("SELECT bcds FROM baocaodoanhso bcds WHERE bcds.thang = :thang AND bcds.nam = :nam")
    baocaodoanhso getBaoCaoDoanhSoByThangAndNam(@Param("thang") int thang, @Param("nam") int nam);


    @Modifying
    @Query("DELETE FROM baocaodoanhso bcds WHERE bcds.mabaocaods = :mabaocaods")
    void deleteByMabaocaodoanhso(@Param("mabaocaods") int mabaocaods);
}