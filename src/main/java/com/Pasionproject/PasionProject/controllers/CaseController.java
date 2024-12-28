package com.Pasionproject.PasionProject.controllers;

import com.Pasionproject.PasionProject.entities_Tables.PcCase;
import com.Pasionproject.PasionProject.services.CaseService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CaseController {

    private final Logger logger = LoggerFactory.getLogger(CaseController.class);

    @Autowired
    CaseService caseService;


    @GetMapping("/case")
    public ResponseEntity<List<PcCase>> allCases(){
        logger.info("All Cases Listed");
        return new ResponseEntity<>(caseService.listOfCases(), HttpStatus.OK);
    }

    @GetMapping("/case/{caseId}")
    public ResponseEntity<PcCase> caseById(@PathVariable Long caseId){
        logger.info("Pulling Up Case With Id: " + caseId );
        return new ResponseEntity<>(caseService.findCaseById(caseId), HttpStatus.OK);
    }

    @PostMapping("/case")
    public ResponseEntity<PcCase> createCase(@Valid @RequestBody PcCase pcCase){
        logger.info("Creating A Case");
        return new ResponseEntity<>(caseService.createPcCase(pcCase), HttpStatus.CREATED);
    }

    @PutMapping("/case/{caseId}")
    public ResponseEntity<PcCase> updateCase(@PathVariable Long caseId, @RequestBody PcCase pcCase){
        logger.info("Updating Case Information");
        return new ResponseEntity<>(caseService.updateCaseById(caseId, pcCase), HttpStatus.OK);
    }

    @DeleteMapping("/case/{caseId}")
    public void deleteCase(@PathVariable Long caseId){
        logger.info("Deleting Case With Id: " + caseId);
        caseService.deleteCaseById(caseId);
    }

}
