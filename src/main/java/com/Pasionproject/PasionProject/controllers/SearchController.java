package com.Pasionproject.PasionProject.controllers;

import com.Pasionproject.PasionProject.entities_Tables.Computer;
import com.Pasionproject.PasionProject.entities_Tables.PcCase;
import com.Pasionproject.PasionProject.exception.NotFoundException;
import com.Pasionproject.PasionProject.services.SearchService;
import jakarta.persistence.Table;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
public class SearchController {

    private final Logger logger = LoggerFactory.getLogger(SearchController.class);


    @Autowired
    SearchService searchService;


    @GetMapping("/search/all")
    public ResponseEntity<List<?>> searchCase(@RequestParam("title") String title){

        if (searchService.findAllComputer(title)){
            logger.info("All Computers Found");
            return new ResponseEntity<>(searchService.searchForComputer(title), HttpStatus.FOUND);//Computer
        } else if (searchService.findAllCpu(title)) {
            logger.info("All Cpu's Found");
            return new ResponseEntity<>(searchService.searchForCpu(title), HttpStatus.FOUND);//Cpu
        } else if (searchService.findAllGraphics(title)) {
            logger.info("All Gpu's Found");
            return new ResponseEntity<>(searchService.searchForGraphics(title), HttpStatus.FOUND);//Graphics
        } else if (searchService.findAllHdd(title)) {
            logger.info("All Hdd Found");
            return new ResponseEntity<>(searchService.searchForHdd(title), HttpStatus.FOUND);//HDD
        }else if (searchService.findAllMotherBoard(title)){
            logger.info("All MotherBoard's Found");
            return new ResponseEntity<>(searchService.searchForMotherBoard(title), HttpStatus.FOUND);//MotherBoard
        }else if (searchService.findAllPowerSupply(title)){
            logger.info("All PowerSuppies Found");
            return new ResponseEntity<>(searchService.searchForPowerSupply(title), HttpStatus.FOUND);//Power Supply
        } else if (searchService.findAllSsd(title)) {
            logger.info("All Ssd Found");
            return new ResponseEntity<>(searchService.searchForSsd(title), HttpStatus.FOUND);//SSD
        }else if (searchService.findAllRam(title)){
            logger.info("All Ram Found");
            return new ResponseEntity<>(searchService.searchForRam(title), HttpStatus.FOUND);//Ram
        } else if (searchService.findAllCase(title)) {
            logger.info("All Case's Found");
            return new ResponseEntity<>(searchService.searchForCase(title), HttpStatus.FOUND);
        }else{
            logger.info(title +  " Could Not Found Please Try Something Else");
            throw new NotFoundException("Title input cannot be found -> " + title);
        }



    }



}
