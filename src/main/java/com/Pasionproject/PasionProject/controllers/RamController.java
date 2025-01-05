package com.Pasionproject.PasionProject.controllers;

import com.Pasionproject.PasionProject.entities_Tables.Ram;
import com.Pasionproject.PasionProject.services.RamService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class RamController {

    @Autowired
    RamService ramService;

    private final Logger logger = LoggerFactory.getLogger(RamController.class);


    @GetMapping("/ram")
    public ResponseEntity<List<Ram>> getAllRam(){
        logger.info("Pulling Up All Ram In System");
        return ResponseEntity.ok(ramService.listOfCreatedRam());
    }

    @GetMapping("/ram/{ramId}")
    public ResponseEntity<Ram> getRamById(@PathVariable Long ramId){
        logger.info("Pulling Up Ram With Id: " + ramId);
        return ResponseEntity.ok(ramService.findById(ramId));
    }

    @PostMapping("/ram")
    public ResponseEntity<Ram> createNewRam(@Valid @RequestBody Ram ram){
        logger.info("Creating Ram");
        return new ResponseEntity<>(ramService.createRam(ram), HttpStatus.CREATED);
    }

    @PutMapping("/ram/{ramId}")
    public ResponseEntity<Ram> fixRamInfo(@PathVariable Long ramId, @RequestBody Ram ram){
        logger.info("Updating Ram Info With Id: " + ramId);
        return new ResponseEntity<>(ramService.adjustRam(ram, ramId), HttpStatus.CREATED);
    }
    @DeleteMapping("/ram/{ramId}")
    public void deleteRamById(@PathVariable Long ramId){
        logger.info("Removing Ram From System With Id: " + ramId);
        ramService.removeRamById(ramId);
    }



}
