package org.example.demobackend.Repository;

import org.example.demobackend.Models.quan;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

@EnableJpaRepositories
public interface QuanRepository extends CrudRepository<quan, Integer> {


    @Query("SELECT q FROM quan q WHERE q.maquan = :maquan")
    quan existsById(@Param("maquan") String maquan);

    @Query("SELECT q FROM quan q WHERE q.tenquan = :tenquan")
    quan findByTenquan(@Param("tenquan") String tenquan);
}
