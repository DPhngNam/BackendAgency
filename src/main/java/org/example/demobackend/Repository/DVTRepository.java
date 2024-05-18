package org.example.demobackend.Repository;

import org.example.demobackend.Models.dvt;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

@EnableJpaRepositories
public interface DVTRepository extends CrudRepository<dvt, Integer> {
    @Query("SELECT d FROM dvt d WHERE d.tendvt = :tendvt")
    dvt findByTendvt(@Param("tendvt") String tendvt);
}
