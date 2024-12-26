package com.Pasionproject.PasionProject.repos;

import com.Pasionproject.PasionProject.entities_Tables.MotherBoard;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MotherBoardRepo extends CrudRepository<MotherBoard, Long> {
    @Query("SELECT p FROM MotherBoard p WHERE p.title = :title")
    List<MotherBoard> findMotherBoardByTitle(String title);

}
