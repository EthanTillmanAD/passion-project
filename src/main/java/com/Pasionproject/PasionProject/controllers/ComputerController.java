package com.Pasionproject.PasionProject.controllers;

import com.Pasionproject.PasionProject.entities_Tables.Computer;
import com.Pasionproject.PasionProject.exception.NotFoundException;
import com.Pasionproject.PasionProject.services.ComputerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ComputerController {

    @Autowired
    ComputerService computerService;

    @GetMapping("/computer")
    public ResponseEntity<List<Computer>> allComputers(){
        return new ResponseEntity<>(computerService.allComputersListed(), HttpStatus.OK);
    }

    @GetMapping("/computer/{computerId}")
    public ResponseEntity<Computer> computerById(@PathVariable Long computerId){
        return new ResponseEntity<>(computerService.findComputerById(computerId), HttpStatus.OK);
    }

    @PostMapping("/computer/motherboard/{motherBoardId}/case/{caseId}/power/{powerId}")
    public ResponseEntity<Computer> buildComputer (@PathVariable Long motherBoardId, @PathVariable Long caseId, @PathVariable Long powerId){
        return new ResponseEntity<>(computerService.buildComputer(motherBoardId, powerId, caseId), HttpStatus.CREATED);
    }

    @PutMapping("/computer/{computerId}/motherboard/{motherboardId}")
    public ResponseEntity<Computer> updateMotherboard(@PathVariable Long computerId, @PathVariable Long motherboardId){
        return new ResponseEntity<>(computerService.changeMotherBoard(computerId,motherboardId), HttpStatus.ACCEPTED);
    }

    @PutMapping("/computer/{computerId}/power/{powerId}")
    public ResponseEntity<Computer> updatePower(@PathVariable Long computerId, @PathVariable Long powerId){
        return new ResponseEntity<>(computerService.changePowerSupply(computerId, powerId), HttpStatus.ACCEPTED);
    }

    @PutMapping("/computer/{computerId}/case/{caseId}")
    public ResponseEntity<Computer> updateCase(@PathVariable Long computerId, @PathVariable Long caseId){
        return new ResponseEntity<>(computerService.changeCase(computerId, caseId), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/computer/{computerId}")
    public ResponseEntity<Void> deleteComputer (@PathVariable Long computerId){

        if (computerService.checkForComputer(computerId)) {
            computerService.deleteComputerById(computerId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        throw new NotFoundException("computer not found with id : " + computerId);
    }

}
