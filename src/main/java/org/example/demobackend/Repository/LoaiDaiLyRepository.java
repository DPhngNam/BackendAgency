package org.example.demobackend.Repository;


import org.example.demobackend.Models.loaidaily;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

@EnableJpaRepositories
public interface LoaiDaiLyRepository extends CrudRepository<loaidaily, Integer> {
    @Query("SELECT l FROM loaidaily l WHERE l.maloaidl = :maloaidl")
    loaidaily existsById(@Param("maloaidl") String maloaidl);

    @Query("SELECT l FROM loaidaily l WHERE l.tenloaidl = :tenloaidl")
    loaidaily findByTenloaidl(@Param("tenloaidl") String tenloaidl);
}
