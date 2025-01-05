package com.Pasionproject.PasionProject.repos;

import com.Pasionproject.PasionProject.entities_Tables.Cpus;
import com.Pasionproject.PasionProject.entities_Tables.PcCase;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
    public interface CaseRepo extends CrudRepository<PcCase, Long> {
        @Query("SELECT p FROM PcCase p WHERE p.title = :title")
        List<PcCase> findPcCaseByTitle(@Param("title")String title);

    @Query("SELECT x FROM PcCase x WHERE x.name LIKE %:name% ")
    List<PcCase> findByName(String name);



}
