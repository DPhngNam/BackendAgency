package com.example.demo.Repository;

import com.example.demo.Models.person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<person, Integer> {
    @Query("SELECT o FROM person o WHERE o.personemail = :personemail")
    person getUserByEmail(@Param("personemail") String personemail);
}
