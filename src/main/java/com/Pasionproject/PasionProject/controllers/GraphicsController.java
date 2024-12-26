package com.Pasionproject.PasionProject.controllers;


import com.Pasionproject.PasionProject.entities_Tables.Cpus;
import com.Pasionproject.PasionProject.entities_Tables.Graphics;
import com.Pasionproject.PasionProject.repos.GraphicsRepo;
import com.Pasionproject.PasionProject.services.GraphicsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GraphicsController {

    @Autowired
    GraphicsService graphicsService;

    @GetMapping("/graphics")
    public ResponseEntity<List<Graphics>> getAllGraphics(){
        return ResponseEntity.ok(graphicsService.allGraphics());
    }

    @GetMapping("/graphics/{graphicsId}")
    public ResponseEntity<Graphics> getGraphicsById(@PathVariable Long graphicsId){
        return ResponseEntity.ok(graphicsService.findGraphicsById(graphicsId));
    }

    @PostMapping("/graphics")
    public ResponseEntity<Graphics> createNewGraphics(@RequestBody Graphics graphics){
        return new ResponseEntity<>(graphicsService.createGraphics(graphics), HttpStatus.CREATED);
    }

    @PutMapping("/graphics/{graphicsId}")
    public ResponseEntity<Graphics> fixGraphicsInfo(@PathVariable Long graphicsId, @RequestBody Graphics graphics){
        return new ResponseEntity<>(graphicsService.updateGraphicsCard(graphics, graphicsId), HttpStatus.CREATED);
    }
    @DeleteMapping("/graphics/{graphicsId}")
    public void deleteGraphicsById(@PathVariable Long graphicsId){
        graphicsService.deleteGraphicsById(graphicsId);
    }
}
