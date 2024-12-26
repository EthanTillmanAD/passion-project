package com.Pasionproject.PasionProject.services;

import com.Pasionproject.PasionProject.entities_Tables.Computer;
import com.Pasionproject.PasionProject.entities_Tables.MotherBoard;
import com.Pasionproject.PasionProject.entities_Tables.PcCase;
import com.Pasionproject.PasionProject.entities_Tables.PowerSupply;
import com.Pasionproject.PasionProject.exception.NotFoundException;
import com.Pasionproject.PasionProject.repos.ComputerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ComputerService {

    @Autowired
    ComputerRepo computerRepo;
    @Autowired
    CaseService caseService;
    @Autowired
    MotherBoardService motherBoardService;
    @Autowired
    PowerSupplyService powerSupplyService;



    public Computer buildComputer(Long motherBoard1, Long powerSupply1, Long pcCase1){
        Computer computer = new Computer();

        PcCase pcCase = caseService.findCaseById(pcCase1);
        MotherBoard motherBoard = motherBoardService.findMotherBoardById(motherBoard1);
        PowerSupply powerSupply = powerSupplyService.findPowerSupplyById(powerSupply1);


        computer.setaCase(pcCase);
        computer.setMotherBoard(motherBoard);
        computer.setPowerSupply(powerSupply);

       return computerRepo.save(computer);
    }

    public List<Computer> allComputersListed(){
        List<Computer> computers = new ArrayList<>();
        for (Computer computer: computerRepo.findAll()){
            computers.add(computer);
        }
        return computers;
    }

    public Computer findComputerById(Long id){
        for (Computer computer: allComputersListed()){
            if (computer.getId().equals(id)){
                return computer;
            }
        }
        throw new NotFoundException("Computer not found with id: " + id);
    }

    public void deleteComputerById(Long id){
        computerRepo.deleteById(id);
    }

    public Computer changeMotherBoard(Long computerId, Long motherBoardId){

        Computer computer = findComputerById(computerId);

        MotherBoard motherBoard = motherBoardService.findMotherBoardById(motherBoardId);

        computer.setMotherBoard(motherBoard);

      return computerRepo.save(computer);
    }

    public Computer changePowerSupply(Long computerId, Long powerId){

        Computer computer = findComputerById(computerId);
        PowerSupply powerSupply = powerSupplyService.findPowerSupplyById(powerId);

        computer.setPowerSupply(powerSupply);

        return computerRepo.save(computer);
    }

    public Computer changeCase(Long computerId, Long caseId){
        Computer computer = findComputerById(computerId);
        PcCase pcCase = caseService.findCaseById(caseId);

        computer.setaCase(pcCase);
        return computerRepo.save(computer);
    }


    public Boolean checkForComputer(Long id){
        for (Computer computer: allComputersListed()){
            if (computer.getId().equals(id)){
                return true;

            }
        }

        return false;
    }
}
