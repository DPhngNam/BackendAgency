package org.example.demobackend.Repository;


import org.example.demobackend.Models.person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<person, Integer> {
    @Query("SELECT p FROM person p WHERE p.personemail = :personemail")
    person getUserByEmail(@Param("personemail") String personemail);


    @Query(value = "SELECT * FROM person WHERE SOUNDEX(personname) = SOUNDEX(:personname)", nativeQuery = true)
    Iterable<person> findByNameSimilarity(@Param("personname") String personname);

    @Query("SELECT p FROM person p WHERE p.personemail = :personemail")
    person existsByEmail(@Param("personemail") String personemail);
}
