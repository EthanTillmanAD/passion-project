package com.Pasionproject.PasionProject.repos;

import com.Pasionproject.PasionProject.entities_Tables.HDD;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HDDRepo extends CrudRepository<HDD,Long> {
    @Query("SELECT p FROM HDD p WHERE p.title = :title")
    List<HDD> findHddByTitle(String title);
}
