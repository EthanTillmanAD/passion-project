package com.Pasionproject.PasionProject.controllers;


import com.Pasionproject.PasionProject.entities_Tables.*;
import com.Pasionproject.PasionProject.exception.NotFoundException;
import com.Pasionproject.PasionProject.services.MotherBoardService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private final Logger logger = LoggerFactory.getLogger(MotherBoardController.class);


    @PostMapping("/motherboard/cpu/{cpuId}/graphics/{graphicsId}/ssd/{ssdId}/hdd/{hddId}/ramOne/{ramOneId}/ramTwo/{ramTwoId}")
    public ResponseEntity<MotherBoard> buildMotherBoard (@Valid @PathVariable Long cpuId, @PathVariable Long graphicsId, @PathVariable Long ssdId,
                                                         @PathVariable Long hddId, @PathVariable Long ramOneId, @PathVariable Long ramTwoId ){
        logger.info("Building MotherBoard With Cpu Id: " + cpuId + ", Gpu Id: " + graphicsId + ", Ssd Id: " + ssdId + ", Hdd Id: " + hddId +
                ", First Ram Id: " + ramOneId + ", And Second Ram Id: " + ramTwoId);
        return new ResponseEntity<>(motherBoardService.buildMotherBoardByPiece(cpuId,graphicsId,hddId,ssdId,ramOneId,ramTwoId), HttpStatus.CREATED);
    }

   @GetMapping("/motherboard")
   public ResponseEntity<List<MotherBoard>> allMotherBoards(){
        logger.info("Pulling Up All MotherBoards In System");
        return new ResponseEntity<>(motherBoardService.getAllMotherBoards(), HttpStatus.OK);
   }

   @GetMapping("/motherboard/{motherboardId}")
   public ResponseEntity<MotherBoard> getAMotherBoard(@PathVariable Long motherboardId){
        logger.info("Pulling Up MotherBoard With Id: " + motherboardId);
        return new ResponseEntity<>(motherBoardService.findMotherBoardById(motherboardId), HttpStatus.OK);
   }

   @PutMapping("/motherboard/{motherBoardId}/cpu")
   public ResponseEntity<MotherBoard> upgradeCpu(@PathVariable Long motherBoardId, @RequestBody Cpus cpu){
        logger.info("Updating Cpu");
        return new ResponseEntity<>(motherBoardService.updateCpu(motherBoardId, cpu), HttpStatus.OK);
   }

    @PutMapping("/motherboard/{motherBoardId}/hdd/{hddId}")
    public ResponseEntity<MotherBoard> addHdd(@PathVariable Long motherBoardId, @PathVariable Long hddId){
        logger.info("Adding Hdd");
        return new ResponseEntity<>(motherBoardService.addHddToMotherBoard(motherBoardId,hddId), HttpStatus.OK);
    }

    @PutMapping("/motherboard/{motherBoardId}/ssd/{ssdId}")
    public ResponseEntity<MotherBoard> addSsd(@PathVariable Long motherBoardId, @PathVariable Long ssdId){
        logger.info("Adding Ssd");
        return new ResponseEntity<>(motherBoardService.addSsdToMotherBoard(motherBoardId, ssdId), HttpStatus.OK);
    }

    @PutMapping("/motherboard/{motherBoardId}/ram/{ramId}")
    public ResponseEntity<MotherBoard> upgradeRam(@PathVariable Long motherBoardId, @RequestBody Ram ram, @PathVariable Long ramId){
        logger.info("Updating Ram");
        return new ResponseEntity<>(motherBoardService.updateRam(motherBoardId, ram, ramId), HttpStatus.OK);
    }

    @PutMapping("/motherboard/{motherBoardId}/ram")
    public ResponseEntity<MotherBoard> addRam(@PathVariable Long motherBoardId, @RequestBody Ram ram){
        logger.info("Adding Ram");
        return new ResponseEntity<>(motherBoardService.addRamToMotherboard(motherBoardId,ram), HttpStatus.OK);
    }

    @PutMapping("/motherboard/{motherBoardId}/graphics/{graphicsId}")
    public ResponseEntity<MotherBoard> upgradeGpu(@PathVariable Long motherBoardId, @PathVariable Long graphicsId){
        logger.info("Updating Gpu");
        return new ResponseEntity<>(motherBoardService.updateGpu(motherBoardId, graphicsId), HttpStatus.OK);
    }

    @DeleteMapping("/motherboard/{motherboardId}")
    public ResponseEntity<Void> deleteMotherBoard(@PathVariable Long motherboardId){

        if (motherBoardService.checkForMotherboard(motherboardId)){
            motherBoardService.deleteMotherBoardById(motherboardId);
            logger.info("Disassembling MotherBoard With Id: " + motherboardId);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        throw new NotFoundException("Motherboard not found with id : " + motherboardId);

    }

}
