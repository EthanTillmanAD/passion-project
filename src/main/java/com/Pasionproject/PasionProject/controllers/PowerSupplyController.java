package com.Pasionproject.PasionProject.controllers;

import com.Pasionproject.PasionProject.entities_Tables.PowerSupply;
import com.Pasionproject.PasionProject.services.PowerSupplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PowerSupplyController {

    @Autowired
    PowerSupplyService powerSupplyService;

    @GetMapping("/power")
    public ResponseEntity<List<PowerSupply>> allPowerSupplies(){
        return new ResponseEntity<>(powerSupplyService.listAllPowerSupply(), HttpStatus.OK);
    }

    @GetMapping("/power/{powerId}")
    public ResponseEntity<PowerSupply> powerSupplyById(@PathVariable Long powerId){
        return new ResponseEntity<>(powerSupplyService.findPowerSupplyById(powerId), HttpStatus.OK);
    }

    @PostMapping("/power")
    public ResponseEntity<PowerSupply> addPowerSupply(@RequestBody PowerSupply powerSupply){
        return new ResponseEntity<>(powerSupplyService.createPowerSupply(powerSupply), HttpStatus.CREATED);
    }

    @PutMapping("/power/{powerId}")
    public ResponseEntity<PowerSupply> updatePower(@PathVariable Long powerId, @RequestBody PowerSupply powerSupply){
        return new ResponseEntity<>(powerSupplyService.updatePowerSupplyInfo(powerId, powerSupply), HttpStatus.OK);
    }

    @DeleteMapping("/power/{powerId}")
    public void deletePowerSupply (@PathVariable Long powerId){
        powerSupplyService.deletePowerSupplyById(powerId);
    }

}
