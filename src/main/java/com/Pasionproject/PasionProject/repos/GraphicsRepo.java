package com.Pasionproject.PasionProject.repos;

import com.Pasionproject.PasionProject.entities_Tables.Graphics;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GraphicsRepo extends CrudRepository<Graphics, Long> {
    @Query("SELECT p FROM Graphics p WHERE p.title = :title")
    List<Graphics> findGraphicsByTitle(String title);
}
