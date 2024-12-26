package com.Pasionproject.PasionProject.controllers;

import com.Pasionproject.PasionProject.entities_Tables.HDD;
import com.Pasionproject.PasionProject.services.HDDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HDDController {

    @Autowired
    HDDService hddService;

    @GetMapping("/hdd")
    public ResponseEntity<List<HDD>> getAllHdd(){
        return ResponseEntity.ok(hddService.allHdd());
    }

    @GetMapping("/hdd/{hddId}")
    public ResponseEntity<HDD> getHddById(@PathVariable Long hddId){
        return ResponseEntity.ok(hddService.findHddById(hddId));
    }

    @PostMapping("/hdd")
    public ResponseEntity<HDD> createNewHdd(@RequestBody HDD hdd){
        return new ResponseEntity<>(hddService.createHdd(hdd), HttpStatus.CREATED);
    }

    @PutMapping("/hdd/{hddId}")
    public ResponseEntity<HDD> fixHddInfo(@PathVariable Long hddId, @RequestBody HDD hdd){
        return new ResponseEntity<>(hddService.updateHdd(hdd, hddId), HttpStatus.CREATED);
    }
    @DeleteMapping("/hdd/{hddId}")
    public void deleteHddById(@PathVariable Long hddId){
        hddService.deleteHddById(hddId);
    }


}
