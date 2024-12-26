package com.Pasionproject.PasionProject.repos;


import com.Pasionproject.PasionProject.entities_Tables.Computer;
import com.Pasionproject.PasionProject.entities_Tables.PcCase;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComputerRepo extends CrudRepository<Computer, Long> {
    @Query("SELECT p FROM Computer p WHERE p.title = :title")
    List<Computer> findComputerByTitle(String title);
}
