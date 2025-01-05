package com.Pasionproject.PasionProject.controllers;


import com.Pasionproject.PasionProject.entities_Tables.Cpus;
import com.Pasionproject.PasionProject.services.CPUService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CPUController {

    @Autowired
    CPUService cpuService;

    private final Logger logger = LoggerFactory.getLogger(CPUController.class);



    @GetMapping("/cpu")
    public ResponseEntity<List<Cpus>> getAllCpu(){
        logger.info("Pulling Up All Cpu's In System");
        return ResponseEntity.ok(cpuService.allCpus());
    }

    @GetMapping("/cpu/{cpuId}")
    public ResponseEntity<Cpus> getCpuById(@PathVariable Long cpuId){
        logger.info("Pulling Up Cpu With Id: " + cpuId);
        return ResponseEntity.ok(cpuService.findCpuById(cpuId));
    }

    @PostMapping("/cpu")
    public ResponseEntity<Cpus> createNewCpu(@Valid @RequestBody Cpus cpu){
        logger.info("Cpu Being Created");
        return new ResponseEntity<>(cpuService.createCpu(cpu), HttpStatus.CREATED);
    }

    @PutMapping("/cpu/{cpuId}")
    public ResponseEntity<Cpus> fixCpuInfo(@PathVariable Long cpuId, @RequestBody Cpus cpu){
        logger.info("Updating Cpu Info For Cpu With Id: " + cpuId);
        return new ResponseEntity<>(cpuService.updateCpu(cpu,cpuId), HttpStatus.CREATED);
    }
    @DeleteMapping("/cpu/{cpuId}")
    public void deleteCpuById(@PathVariable Long cpuId){
        logger.info("Removing Cpu From System With Id: " + cpuId);
      cpuService.deleteCpuById(cpuId);
    }

}
