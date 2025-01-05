package com.Pasionproject.PasionProject.controllers;

import com.Pasionproject.PasionProject.entities_Tables.HDD;
import com.Pasionproject.PasionProject.services.HDDService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HDDController {

    @Autowired
    HDDService hddService;

    private final Logger logger = LoggerFactory.getLogger(HDDController.class);


    @GetMapping("/hdd")
    public ResponseEntity<List<HDD>> getAllHdd(){
        logger.info("Pulling Up All Hdd In System");
        return ResponseEntity.ok(hddService.allHdd());
    }

    @GetMapping("/hdd/{hddId}")
    public ResponseEntity<HDD> getHddById(@PathVariable Long hddId){
        logger.info("Pulling Up Hdd With Id: " + hddId);
        return ResponseEntity.ok(hddService.findHddById(hddId));
    }

    @PostMapping("/hdd")
    public ResponseEntity<HDD> createNewHdd(@Valid @RequestBody HDD hdd){
        logger.info("Creating A New Hdd");
        return new ResponseEntity<>(hddService.createHdd(hdd), HttpStatus.CREATED);
    }

    @PutMapping("/hdd/{hddId}")
    public ResponseEntity<HDD> fixHddInfo(@PathVariable Long hddId, @RequestBody HDD hdd){
        logger.info("Updating Hdd Info For Hdd Id: " + hddId);
        return new ResponseEntity<>(hddService.updateHdd(hdd, hddId), HttpStatus.CREATED);
    }
    @DeleteMapping("/hdd/{hddId}")
    public void deleteHddById(@PathVariable Long hddId){
        logger.info("Removing Hdd From System With Id: " + hddId);
        hddService.deleteHddById(hddId);
    }


}
