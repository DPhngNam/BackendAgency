package com.example.demo.Repository;

import com.example.demo.Models.quan;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;

@EnableJpaRepositories
public interface QuanRepository extends CrudRepository<quan, Integer> {

}
