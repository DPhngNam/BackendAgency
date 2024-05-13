package com.example.demo.Repository;

import com.example.demo.Models.mathang;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;

@EnableJpaRepositories
public interface MatHangRepository<MatHang> extends CrudRepository<mathang, Integer> {
    @Query("SELECT mh FROM mathang mh WHERE mh.mamh = :mamh")
    mathang getMatHangById(int mamh);

    @Query("SELECT mh.dongianhap FROM mathang mh WHERE mh.mamh = :mamh")
    Integer getDonGiaNhapByMaMH(int mamh);

    @Query("SELECT mh.dongiaxuat FROM mathang mh WHERE mh.mamh = :mamh")
    Integer getDonGiaXuatByMaMH(int mamh);
}
