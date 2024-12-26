package com.Pasionproject.PasionProject.controllers;

import com.Pasionproject.PasionProject.entities_Tables.Computer;
import com.Pasionproject.PasionProject.services.ComputerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ComputerController {

    @Autowired
    ComputerService computerService;

    @GetMapping("/computer")
    public ResponseEntity<List<Computer>> allComputers(){
        return new ResponseEntity<>(computerService.allComputersListed(), HttpStatus.OK);
    }

    @PostMapping("/computer/motherboard/{motherBoardId}/case/{caseId}/power/{powerId}")
    public ResponseEntity<Computer> buildComputer (@PathVariable Long motherBoardId, @PathVariable Long caseId, @PathVariable Long powerId){
        return new ResponseEntity<>(computerService.buildComputer(motherBoardId, powerId, caseId), HttpStatus.CREATED);
    }
}
