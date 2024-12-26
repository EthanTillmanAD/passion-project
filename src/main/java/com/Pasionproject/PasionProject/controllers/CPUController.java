package com.Pasionproject.PasionProject.controllers;


import com.Pasionproject.PasionProject.entities_Tables.Cpus;
import com.Pasionproject.PasionProject.services.CPUService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CPUController {

    @Autowired
    CPUService cpuService;



    @GetMapping("/cpu")
    public ResponseEntity<List<Cpus>> getAllCpu(){
        return ResponseEntity.ok(cpuService.allSsd());
    }

    @GetMapping("/cpu/{cpuId}")
    public ResponseEntity<Cpus> getCpuById(@PathVariable Long cpuId){
        return ResponseEntity.ok(cpuService.findCpuById(cpuId));
    }

    @PostMapping("/cpu")
    public ResponseEntity<Cpus> createNewCpu(@Valid @RequestBody Cpus cpu){
        return new ResponseEntity<>(cpuService.createCpu(cpu), HttpStatus.CREATED);
    }

    @PutMapping("/cpu/{cpuId}")
    public ResponseEntity<Cpus> fixCpuInfo(@PathVariable Long cpuId, @RequestBody Cpus cpu){
        return new ResponseEntity<>(cpuService.updateCpu(cpu,cpuId), HttpStatus.CREATED);
    }
    @DeleteMapping("/cpu/{cpuId}")
    public void deleteCpuById(@PathVariable Long cpuId){
      cpuService.deleteCpuById(cpuId);
    }

}
