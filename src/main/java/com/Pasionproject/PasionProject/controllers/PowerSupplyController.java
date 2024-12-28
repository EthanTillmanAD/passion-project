package com.Pasionproject.PasionProject.controllers;

import com.Pasionproject.PasionProject.entities_Tables.PowerSupply;
import com.Pasionproject.PasionProject.services.PowerSupplyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PowerSupplyController {

    private final Logger logger = LoggerFactory.getLogger(PowerSupplyController.class);

    @Autowired
    PowerSupplyService powerSupplyService;

    @GetMapping("/power")
    public ResponseEntity<List<PowerSupply>> allPowerSupplies(){
        logger.info("Pulling Up All PowerSupplies");
        return new ResponseEntity<>(powerSupplyService.listAllPowerSupply(), HttpStatus.OK);
    }

    @GetMapping("/power/{powerId}")
    public ResponseEntity<PowerSupply> powerSupplyById(@PathVariable Long powerId){
        logger.info("Pulling Up PowerSupply With Id: " + powerId);
        return new ResponseEntity<>(powerSupplyService.findPowerSupplyById(powerId), HttpStatus.OK);
    }

    @PostMapping("/power")
    public ResponseEntity<PowerSupply> addPowerSupply(@RequestBody PowerSupply powerSupply){
        logger.info("Creating PowerSupply");
        return new ResponseEntity<>(powerSupplyService.createPowerSupply(powerSupply), HttpStatus.CREATED);
    }

    @PutMapping("/power/{powerId}")
    public ResponseEntity<PowerSupply> updatePower(@PathVariable Long powerId, @RequestBody PowerSupply powerSupply){
        logger.info("Updating PowerSupply Info For Id: " + powerId);
        return new ResponseEntity<>(powerSupplyService.updatePowerSupplyInfo(powerId, powerSupply), HttpStatus.OK);
    }

    @DeleteMapping("/power/{powerId}")
    public void deletePowerSupply (@PathVariable Long powerId){
        logger.info("Removing PowerSupply From System With Id: " + powerId);
        powerSupplyService.deletePowerSupplyById(powerId);
    }

}
