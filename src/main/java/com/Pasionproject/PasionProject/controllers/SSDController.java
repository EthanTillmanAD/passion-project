package com.Pasionproject.PasionProject.controllers;

import com.Pasionproject.PasionProject.entities_Tables.SSDrive;
import com.Pasionproject.PasionProject.services.SSDService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SSDController {

    @Autowired
    SSDService ssdService;

    private final Logger logger = LoggerFactory.getLogger(SSDController.class);



    @GetMapping("/ssd")
    public ResponseEntity<List<SSDrive>> getAllSsd(){
        logger.info("Pulling Up All Ssd In System");
        return ResponseEntity.ok(ssdService.allSsd());
    }

    @GetMapping("/ssd/{ssdId}")
    public ResponseEntity<SSDrive> getSsdById(@PathVariable Long ssdId){
        logger.info("Pulling Up Ssd With Id: " + ssdId);
        return ResponseEntity.ok(ssdService.findSddById(ssdId));
    }

    @PostMapping("/ssd")
    public ResponseEntity<SSDrive> createNewSsd(@RequestBody SSDrive ssd){
        logger.info("Creating Ssd");
        return new ResponseEntity<>(ssdService.createSdd(ssd) , HttpStatus.CREATED);
    }

    @PutMapping("/ssd/{ssdId}")
    public ResponseEntity<SSDrive> fixSsdInfo(@PathVariable Long ssdId, @RequestBody SSDrive ssd){
        logger.info("Updating Ssd Info From Id: " + ssdId);
        return new ResponseEntity<>(ssdService.updateSdd(ssd, ssdId), HttpStatus.CREATED);
    }
    @DeleteMapping("/ssd/{ssdId}")
    public void deleteSsdById(@PathVariable Long ssdId){
        logger.info("Removing Ssd With Id: " + ssdId);
       ssdService.deleteHddById(ssdId);
    }

}
