package com.example.demo.Repository;

import com.example.demo.Models.daily;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
@EnableJpaRepositories
public interface DaiLyRepository extends CrudRepository<daily, Integer> {
    @Query("SELECT d FROM daily d WHERE d.madaily = :madaily")
    daily getDaiLyById(@Param("madaily") int madaily);

    @Query("SELECT d FROM daily d WHERE d.tendaily = :tendaily")
    Iterable<daily> getAllDaiLyByTenDaiLy(@Param("tendaily") String tendaily);

    @Query("SELECT d FROM daily d WHERE d.diachi = :diachi")
    Iterable<daily> getAllDaiLyByDiaChi(@Param("diachi") String diachi);

    @Query("SELECT d FROM daily d WHERE d.person_id = :person_id")
    Iterable<daily> getAllDaiLyByPersonId(@Param("person_id") int person_id);
}