package com.Pasionproject.PasionProject.repos;

import com.Pasionproject.PasionProject.entities_Tables.Cpus;
import com.Pasionproject.PasionProject.entities_Tables.SSDrive;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SSDRepo extends CrudRepository<SSDrive, Long> {
    @Query("SELECT p FROM SSDrive p WHERE p.title = :title")
    List<SSDrive> findSSDriveByTitle(String title);

    @Query("SELECT x FROM SSDrive x WHERE x.name LIKE %:name% ")
    List<SSDrive> findByName(String name);
}
