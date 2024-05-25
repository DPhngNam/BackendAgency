package org.example.demobackend.Repository;

import org.example.demobackend.Models.mathang;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

@EnableJpaRepositories
public interface MatHangRepository extends CrudRepository<mathang, Integer> {
    @Query("SELECT mh FROM mathang mh WHERE mh.mamh = :mamh")
    mathang getMatHangById(@Param("mamh") int mamh);

    @Query("SELECT mh.dongianhap FROM mathang mh WHERE mh.mamh = :mamh")
    Integer getDonGiaNhapByMaMH(@Param("mamh") int mamh);

    @Query("SELECT mh.dongiaxuat FROM mathang mh WHERE mh.mamh = :mamh")
    Integer getDonGiaXuatByMaMH(@Param("mamh")int mamh);

    @Query("SELECT mh FROM mathang mh")
    List<mathang> getAllMatHang();

    @Query("SELECT mh.slton FROM mathang mh WHERE mh.tenmh = :tenmh")
    int getSLTByTenmh(@Param("tenmh")String tenmh);
}