package com.Pasionproject.PasionProject.services;


import com.Pasionproject.PasionProject.entities_Tables.*;
import com.Pasionproject.PasionProject.repos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SearchService {


    @Autowired
    CaseRepo caseRepo;
    @Autowired
    ComputerRepo computerRepo;
    @Autowired
    CpuRepo cpuRepo;
    @Autowired
    GraphicsRepo graphicsRepo;
    @Autowired
    HDDRepo hddRepo;
    @Autowired
    MotherBoardRepo motherBoardRepo;
    @Autowired
    PowerSupplyRepo powerSupplyRepo;
    @Autowired
    RamRepo ramRepo;
    @Autowired
    SSDRepo ssdRepo;





    public List<PcCase> searchForCase(String title){
        title = title.toLowerCase();
        return caseRepo.findPcCaseByTitle(title);
    }

    public List<Computer> searchForComputer(String title){
       title = title.toLowerCase();
        return computerRepo.findComputerByTitle(title);
    }

    public List<Cpus> searchForCpu(String title){
        title = title.toLowerCase();
        return cpuRepo.findCpusByTitle(title);
    }

    public List<Graphics> searchForGraphics(String title){
        title = title.toLowerCase();
        return graphicsRepo.findGraphicsByTitle(title);
    }

    public List<HDD> searchForHdd(String title){
        title = title.toLowerCase();
        return hddRepo.findHddByTitle(title);
    }
    public List<MotherBoard> searchForMotherBoard(String title){
        title = title.toLowerCase();
        return motherBoardRepo.findMotherBoardByTitle(title);
    }

    public List<PowerSupply> searchForPowerSupply(String title){
        title = title.toLowerCase();
        return powerSupplyRepo.findPowerSupplyByTitle(title);
    }

    public List<Ram> searchForRam(String title){
        title = title.toLowerCase();
        return ramRepo.findRamRyTitle(title);
    }

    public List<SSDrive> searchForSsd(String title){
        title = title.toLowerCase();
        return ssdRepo.findSSDriveByTitle(title);
    }




    public Boolean findAllSsd(String title){
        for (SSDrive ssd: ssdRepo.findAll()){
            if (ssd.getTitle().equalsIgnoreCase(title)){
                return true;
            }
        }
        return false;
    }

    public Boolean findAllRam(String title){
        for (Ram ram: ramRepo.findAll()){
            if (ram.getTitle().equalsIgnoreCase(title)){
                return true;
            }
        }
        return false;
    }

    public Boolean findAllPowerSupply(String title){
        for (PowerSupply powerSupply: powerSupplyRepo.findAll()){
            if (powerSupply.getTitle().equalsIgnoreCase(title)){
                return true;
            }
        }
        return false;
    }


    public Boolean findAllMotherBoard(String title){
        for (MotherBoard motherBoard: motherBoardRepo.findAll()){
            if (motherBoard.getTitle().equalsIgnoreCase(title)){
                return true;
            }
        }
        return false;
    }




    public Boolean findAllHdd(String title){

        for (HDD hdd: hddRepo.findAll()){
            if (hdd.getTitle().equalsIgnoreCase(title)){
                return true;
            }
        } return false;
    }

    public Boolean findAllGraphics(String title){

        for (Graphics graphic:graphicsRepo.findAll()){
            if (graphic.getTitle().equalsIgnoreCase(title)){
                return true;
            }
        } return false;
    }


    public Boolean findAllCpu(String title){

        for (Cpus cpu: cpuRepo.findAll()){
            if (cpu.getTitle().equalsIgnoreCase(title)){
                return true;
            }
        } return false;
    }


    public Boolean findAllCase(String title){

        for (PcCase pcCase: caseRepo.findAll()){
            if (pcCase.getTitle().equalsIgnoreCase(title)){
                return true;
            }
        } return false;
    }


    public Boolean findAllComputer(String title){

        for (Computer computer: computerRepo.findAll()){
            if (computer.getTitle().equalsIgnoreCase(title)){
                return true;
                }
        } return false;
    }


}








