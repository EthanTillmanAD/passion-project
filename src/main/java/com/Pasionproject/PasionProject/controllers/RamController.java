package com.Pasionproject.PasionProject.controllers;

import com.Pasionproject.PasionProject.entities_Tables.Ram;
import com.Pasionproject.PasionProject.services.RamService;
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

    @GetMapping("/ram")
    public ResponseEntity<List<Ram>> getAllRam(){
        return ResponseEntity.ok(ramService.listOfCreatedRam());
    }

    @GetMapping("/ram/{ramId}")
    public ResponseEntity<Ram> getRamById(@PathVariable Long ramId){
        return ResponseEntity.ok(ramService.findById(ramId));
    }

    @PostMapping("/ram")
    public ResponseEntity<Ram> createNewRam(@RequestBody Ram ram){
        return new ResponseEntity<>(ramService.createRam(ram), HttpStatus.CREATED);
    }

    @PutMapping("/ram/{ramId}")
    public ResponseEntity<Ram> fixRamInfo(@PathVariable Long ramId, @RequestBody Ram ram){
        return new ResponseEntity<>(ramService.adjustRam(ram, ramId), HttpStatus.CREATED);
    }
    @DeleteMapping("/ram/{ramId}")
    public void deleteRamById(@PathVariable Long ramId){
        ramService.removeRamById(ramId);
    }



}
