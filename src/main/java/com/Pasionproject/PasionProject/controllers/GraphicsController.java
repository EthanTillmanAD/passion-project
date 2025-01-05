package com.Pasionproject.PasionProject.controllers;


import com.Pasionproject.PasionProject.entities_Tables.Cpus;
import com.Pasionproject.PasionProject.entities_Tables.Graphics;
import com.Pasionproject.PasionProject.repos.GraphicsRepo;
import com.Pasionproject.PasionProject.services.GraphicsService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GraphicsController {

    @Autowired
    GraphicsService graphicsService;

    private final Logger logger = LoggerFactory.getLogger(GraphicsController.class);


    @GetMapping("/graphics")
    public ResponseEntity<List<Graphics>> getAllGraphics(){
        logger.info("Pulling Up All Gpu's From System");
        return ResponseEntity.ok(graphicsService.allGraphics());
    }

    @GetMapping("/graphics/{graphicsId}")
    public ResponseEntity<Graphics> getGraphicsById(@PathVariable Long graphicsId){
        logger.info("Pulling Up Gpu With Id: " + graphicsId);
        return ResponseEntity.ok(graphicsService.findGraphicsById(graphicsId));
    }

    @PostMapping("/graphics")
    public ResponseEntity<Graphics> createNewGraphics(@Valid @RequestBody Graphics graphics){
        logger.info("Creating Gpu");
        return new ResponseEntity<>(graphicsService.createGraphics(graphics), HttpStatus.CREATED);
    }

    @PutMapping("/graphics/{graphicsId}")
    public ResponseEntity<Graphics> fixGraphicsInfo(@PathVariable Long graphicsId, @RequestBody Graphics graphics){
        logger.info("Updating Gpu Info For Gpu Id: " + graphicsId);
        return new ResponseEntity<>(graphicsService.updateGraphicsCard(graphics, graphicsId), HttpStatus.CREATED);
    }
    @DeleteMapping("/graphics/{graphicsId}")
    public void deleteGraphicsById(@PathVariable Long graphicsId){
        logger.info("Removing Gpu From System");
        graphicsService.deleteGraphicsById(graphicsId);
    }
}
