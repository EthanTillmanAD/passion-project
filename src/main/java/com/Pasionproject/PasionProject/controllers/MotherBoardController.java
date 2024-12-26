package com.Pasionproject.PasionProject.controllers;


import com.Pasionproject.PasionProject.entities_Tables.*;
import com.Pasionproject.PasionProject.services.MotherBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MotherBoardController {

    @Autowired
    MotherBoardService motherBoardService;

    @PostMapping("/motherboard/cpu/{cpuId}/graphics/{graphicsId}/ssd/{ssdId}/hdd/{hddId}/ramOne/{ramOneId}/ramTwo/{ramTwoId}")
    public ResponseEntity<MotherBoard> buildMotherBoard (@PathVariable Long cpuId, @PathVariable Long graphicsId, @PathVariable Long ssdId,
                                                         @PathVariable Long hddId, @PathVariable Long ramOneId, @PathVariable Long ramTwoId ){

        return new ResponseEntity<>(motherBoardService.buildMotherBoardByPiece(cpuId,graphicsId,hddId,ssdId,ramOneId,ramTwoId), HttpStatus.CREATED);
    }

   @GetMapping("/motherboard")
   public ResponseEntity<List<MotherBoard>> allMotherBoards(){
        return new ResponseEntity<>(motherBoardService.getAllMotherBoards(), HttpStatus.OK);
   }

   @PutMapping("/motherboard/{motherBoardId}/cpu")
   public ResponseEntity<MotherBoard> upgradeCpu(@PathVariable Long motherBoardId, @RequestBody Cpus cpu){

        return new ResponseEntity<>(motherBoardService.updateCpu(motherBoardId, cpu), HttpStatus.OK);
   }
    @PutMapping("/motherboard/{motherBoardId}/hdd")
    public ResponseEntity<MotherBoard> addHdd(@PathVariable Long motherBoardId, @RequestBody HDD hdd){
        return new ResponseEntity<>(motherBoardService.addHddToMotherBoard(motherBoardId,hdd), HttpStatus.OK);
    }
    @PutMapping("/motherboard/{motherBoardId}/ssd")
    public ResponseEntity<MotherBoard> addSsd(@PathVariable Long motherBoardId, @RequestBody SSDrive ssd){
        return new ResponseEntity<>(motherBoardService.addSsdToMotherBoard(motherBoardId, ssd), HttpStatus.OK);
    }
    @PutMapping("/motherboard/{motherBoardId}/ram/{ramId}")
    public ResponseEntity<MotherBoard> upgradeRam(@PathVariable Long motherBoardId, @RequestBody Ram ram, @PathVariable Long ramId){
        return new ResponseEntity<>(motherBoardService.updateRam(motherBoardId, ram, ramId), HttpStatus.OK);
    }
    @PutMapping("/motherboard/{motherBoardId}/ram")
    public ResponseEntity<MotherBoard> addRam(@PathVariable Long motherBoardId, @RequestBody Ram ram){
        return new ResponseEntity<>(motherBoardService.addRamToMotherboard(motherBoardId,ram), HttpStatus.OK);
    }

    @PutMapping("/motherboard/{motherBoardId}/graphics")
    public ResponseEntity<MotherBoard> upgradeGpu(@PathVariable Long motherBoardId, @RequestBody Graphics graphics){
        return new ResponseEntity<>(motherBoardService.updateGpu(motherBoardId, graphics), HttpStatus.OK);
    }

}
