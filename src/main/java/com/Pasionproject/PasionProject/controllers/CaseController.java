package com.Pasionproject.PasionProject.controllers;

import com.Pasionproject.PasionProject.entities_Tables.PcCase;
import com.Pasionproject.PasionProject.services.CaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CaseController {

    @Autowired
    CaseService caseService;


    @GetMapping("/case")
    public ResponseEntity<List<PcCase>> allCases(){
        return new ResponseEntity<>(caseService.listOfCases(), HttpStatus.OK);
    }

    @PostMapping("/case")
    public ResponseEntity<PcCase> createCase(@RequestBody PcCase pcCase){
        return new ResponseEntity<>(caseService.createPcCase(pcCase), HttpStatus.CREATED);
    }

    @PutMapping("/case/{caseId}")
    public ResponseEntity<PcCase> updateCase(@PathVariable Long caseId, @RequestBody PcCase pcCase){
        return new ResponseEntity<>(caseService.updateCaseById(caseId, pcCase), HttpStatus.OK);
    }

    @DeleteMapping("/case/{caseId}")
    public void deleteCase(@PathVariable Long caseId){
        caseService.deleteCaseById(caseId);
    }

}
