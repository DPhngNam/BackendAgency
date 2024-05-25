package org.example.demobackend.Repository;

import org.example.demobackend.Models.ctbcds;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

@EnableJpaRepositories
public interface CTBCDSRepository extends CrudRepository<ctbcds, Integer> {
    @Query("SELECT ctbcds FROM ctbcds ctbcds WHERE ctbcds.madaily = :madaily")
    List<ctbcds> getCTBCDSByMaDaily(@Param("madaily")int madaily);

    @Query("SELECT ctbcds FROM ctbcds ctbcds WHERE ctbcds.mabaocaods.mabaocaods = :mabaocaods")
    List<ctbcds> getCTBCDSByMaBaoCaoDS(@Param("mabaocaods") int mabaocaods);

    @Query("SELECT ctbcds FROM ctbcds ctbcds WHERE ctbcds.madaily = :madaily AND ctbcds.mabaocaods = :mabaocaods")
    ctbcds getCTBCDSByMaDailyAndMaBaoCaoDS(@Param("madaily")int madaily,@Param("mabaocaods")int mabaocaods);

}
