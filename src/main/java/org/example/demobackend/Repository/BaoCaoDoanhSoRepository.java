package org.example.demobackend.Repository;

import org.example.demobackend.Models.baocaodoanhso;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import java.util.List;
import java.util.Map;

@EnableJpaRepositories
public interface BaoCaoDoanhSoRepository extends CrudRepository<baocaodoanhso, Integer> {
    @Query("SELECT bcds FROM baocaodoanhso bcds WHERE bcds.mabaocaods = :mabaocaods")
    baocaodoanhso getBaoCaoDoanhSoByMaBaoCaoDS(@Param("mabaocaods") int mabaocaods);

    @Query("SELECT bcds FROM baocaodoanhso bcds WHERE bcds.thang = :thang")
    List<baocaodoanhso> getBaoCaoDoanhSoByThang(@Param("thang") int thang);

    @Query("SELECT bcds FROM baocaodoanhso bcds WHERE bcds.nam = :nam")
    List<baocaodoanhso> getBaoCaoDoanhSoByNam(@Param("nam") int nam);

    @Query("SELECT bcds.thang FROM baocaodoanhso bcds WHERE bcds.mabaocaods = :mabaocaods")
    int getThangByMaBaoCaoDS(@Param("mabaocaods") int mabaocaods);

    @Query("SELECT bcds.nam FROM baocaodoanhso bcds WHERE bcds.mabaocaods = :mabaocaods")
    int getNamByMaBaoCaoDS(@Param("mabaocaods") int mabaocaods);

    @Query("SELECT new map(bcds.thang as thang, bcds.nam as nam) FROM baocaodoanhso bcds WHERE bcds.mabaocaods = :mabaocaods")
    Map<String, Integer> getThangAndNamByMaBaoCaoDS(@Param("mabaocaods") int mabaocaods);

    @Query("SELECT bcds FROM baocaodoanhso bcds WHERE bcds.thang = :thang AND bcds.nam = :nam")
    List<baocaodoanhso> getBaoCaoDoanhSoByThangAndNam(@Param("thang") int thang, @Param("nam") int nam);

    @Query("SELECT bcds.mabaocaods FROM baocaodoanhso bcds WHERE bcds.thang = :thang AND bcds.nam = :nam")
    List<Integer> getMaBaoCaoDSByThangAndNam(@Param("thang") int thang, @Param("nam") int nam);
}