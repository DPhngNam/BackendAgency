package org.example.demobackend.Repository;

import org.example.demobackend.Models.baocaocongno;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

@EnableJpaRepositories
public interface CongNoRepository extends CrudRepository<baocaocongno, Integer>{

}
