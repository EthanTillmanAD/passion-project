package com.Pasionproject.PasionProject.controllers;


import com.Pasionproject.PasionProject.entities_Tables.*;
import com.Pasionproject.PasionProject.exception.NotFoundException;
import com.Pasionproject.PasionProject.services.MotherBoardService;
import jakarta.validation.Valid;
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
    public ResponseEntity<MotherBoard> buildMotherBoard (@Valid @PathVariable Long cpuId, @PathVariable Long graphicsId, @PathVariable Long ssdId,
                                                         @PathVariable Long hddId, @PathVariable Long ramOneId, @PathVariable Long ramTwoId ){

        return new ResponseEntity<>(motherBoardService.buildMotherBoardByPiece(cpuId,graphicsId,hddId,ssdId,ramOneId,ramTwoId), HttpStatus.CREATED);
    }

//    @PostMapping("/motherboard")
//    public ResponseEntity<MotherBoard> buildMotherBoardAllTogether(@RequestBody MotherBoard motherBoard){
//        return new ResponseEntity<>(motherBoardService.buildAllAtOnce(motherBoard), HttpStatus.CREATED);
//    }

   @GetMapping("/motherboard")
   public ResponseEntity<List<MotherBoard>> allMotherBoards(){
        return new ResponseEntity<>(motherBoardService.getAllMotherBoards(), HttpStatus.OK);
   }

   @GetMapping("/motherboard/{motherboardId}")
   public ResponseEntity<MotherBoard> getAMotherBoard(@PathVariable Long motherboardId){
        return new ResponseEntity<>(motherBoardService.findMotherBoardById(motherboardId), HttpStatus.OK);
   }

   @PutMapping("/motherboard/{motherBoardId}/cpu")
   public ResponseEntity<MotherBoard> upgradeCpu(@PathVariable Long motherBoardId, @RequestBody Cpus cpu){

        return new ResponseEntity<>(motherBoardService.updateCpu(motherBoardId, cpu), HttpStatus.OK);
   }
    @PutMapping("/motherboard/{motherBoardId}/hdd/{hddId}")
    public ResponseEntity<MotherBoard> addHdd(@PathVariable Long motherBoardId, @PathVariable Long hddId){
        return new ResponseEntity<>(motherBoardService.addHddToMotherBoard(motherBoardId,hddId), HttpStatus.OK);
    }
    @PutMapping("/motherboard/{motherBoardId}/ssd/{ssdId}")
    public ResponseEntity<MotherBoard> addSsd(@PathVariable Long motherBoardId, @PathVariable Long ssdId){
        return new ResponseEntity<>(motherBoardService.addSsdToMotherBoard(motherBoardId, ssdId), HttpStatus.OK);
    }
    @PutMapping("/motherboard/{motherBoardId}/ram/{ramId}")
    public ResponseEntity<MotherBoard> upgradeRam(@PathVariable Long motherBoardId, @RequestBody Ram ram, @PathVariable Long ramId){
        return new ResponseEntity<>(motherBoardService.updateRam(motherBoardId, ram, ramId), HttpStatus.OK);
    }
    @PutMapping("/motherboard/{motherBoardId}/ram")
    public ResponseEntity<MotherBoard> addRam(@PathVariable Long motherBoardId, @RequestBody Ram ram){
        return new ResponseEntity<>(motherBoardService.addRamToMotherboard(motherBoardId,ram), HttpStatus.OK);
    }

    @PutMapping("/motherboard/{motherBoardId}/graphics/{graphicsId}")
    public ResponseEntity<MotherBoard> upgradeGpu(@PathVariable Long motherBoardId, @PathVariable Long graphicsId){
        return new ResponseEntity<>(motherBoardService.updateGpu(motherBoardId, graphicsId), HttpStatus.OK);
    }

    @DeleteMapping("/motherboard/{motherboardId}")
    public ResponseEntity<Void> deleteMotherBoard(@PathVariable Long motherboardId){

        if (motherBoardService.checkForMotherboard(motherboardId)){
            motherBoardService.deleteMotherBoardById(motherboardId);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        throw new NotFoundException("Motherboard not found with id : " + motherboardId);

    }

}
