package com.Pasionproject.PasionProject.repos;

import com.Pasionproject.PasionProject.entities_Tables.Cpus;
import com.Pasionproject.PasionProject.entities_Tables.PowerSupply;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PowerSupplyRepo extends CrudRepository<PowerSupply, Long> {
    @Query("SELECT p FROM PowerSupply p WHERE p.title = :title")
    List<PowerSupply> findPowerSupplyByTitle(String title);

    @Query("SELECT x FROM PowerSupply x WHERE x.name LIKE %:name% ")
    List<PowerSupply> findByName(String name);
}
