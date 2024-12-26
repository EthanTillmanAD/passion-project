package com.Pasionproject.PasionProject.repos;

import com.Pasionproject.PasionProject.entities_Tables.Ram;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RamRepo extends CrudRepository<Ram, Long> {
    @Query("SELECT p FROM Ram p WHERE p.title = :title")
    List<Ram> findRamRyTitle(String title);
}
