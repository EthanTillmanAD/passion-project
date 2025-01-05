package com.Pasionproject.PasionProject.repos;

import com.Pasionproject.PasionProject.entities_Tables.Cpus;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CpuRepo extends CrudRepository<Cpus, Long> {
    @Query("SELECT p FROM Cpus p WHERE p.title LIKE %:title%")
    List<Cpus> findCpusByTitle(String title);

    @Query("SELECT x FROM Cpus x WHERE x.name LIKE %:name% ")
    List<Cpus> findByName(String name);

}
