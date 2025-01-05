package com.Pasionproject.PasionProject.services;

import com.Pasionproject.PasionProject.entities_Tables.*;
import com.Pasionproject.PasionProject.exception.NotFoundException;
import com.Pasionproject.PasionProject.exception.TooManyResoursesAddedException;
import com.Pasionproject.PasionProject.repos.CpuRepo;
import com.Pasionproject.PasionProject.repos.MotherBoardRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class MotherBoardService {

    @Autowired
    MotherBoardRepo motherBoardRepo;
    @Autowired
    CPUService cpuService;
    @Autowired
    GraphicsService graphicsService;
    @Autowired
    HDDService hddService;
    @Autowired
    SSDService ssdService;
    @Autowired
    RamService ramService;

    MotherBoard motherBoard;





    public MotherBoard buildMotherBoardByPiece(Long cpu, Long graphics, Long hdd, Long ssd, Long ram1, Long ram2, String name){

        Cpus myCpu = cpuService.findCpuById(cpu);
        Graphics myGraphics = graphicsService.findGraphicsById(graphics);
        HDD myHdd = hddService.findHddById(hdd);
        SSDrive ssDrive = ssdService.findSddById(ssd);
        Ram firstRam = ramService.findById(ram1);
        Ram secondRam = ramService.findById(ram2);

        if (!firstRam.equals(secondRam)){
            MotherBoard motherBoard = new MotherBoard();

            motherBoard.setCpu(myCpu);
            motherBoard.setGraphics(myGraphics);
            motherBoard.addHdd(myHdd);
            motherBoard.addSsd(ssDrive);
            motherBoard.addRam(firstRam);
            motherBoard.addRam(secondRam);
            motherBoard.setName(name);

            return motherBoardRepo.save(motherBoard);
        }

        throw new NotFoundException("2 ram required");


    }

    public List<MotherBoard> getAllMotherBoards(){
        List<MotherBoard> motherBoards = new ArrayList<>();
        for(MotherBoard motherBoard: motherBoardRepo.findAll()){
            motherBoards.add(motherBoard);
        }

        return motherBoards;
    }

    public MotherBoard findMotherBoardById(Long id){
        for (MotherBoard motherBoard : getAllMotherBoards()){
            if (motherBoard.getId().equals(id)){
                return motherBoard;
            }
        }
        throw new NotFoundException("Motherboard not found with id: " + id);

    }

    public MotherBoard updateCpu(Long id, Cpus cpu){


        motherBoard = findMotherBoardById(id);
        Cpus cpus =  motherBoard.getCpu();


        Cpus cpus1 = cpuService.updateCpu(cpu, cpus.getId());
        motherBoard.setCpu(cpus1);

       return motherBoardRepo.save(motherBoard);
    }

    public MotherBoard updateRam(Long id, Ram ram, Long ramId){

        motherBoard = findMotherBoardById(id);

        for (Ram ramPreinstalled: motherBoard.getRam()){
            if (ramPreinstalled.getId().equals(ramId)){
                ramPreinstalled.setSize(ram.getSize());
                ramPreinstalled.setName(ram.getName());
            }
        }


        return motherBoardRepo.save(motherBoard);
    }

    public MotherBoard addRamToMotherboard (Long id, Ram ram){

        motherBoard = findMotherBoardById(id);

        if (motherBoard.getRam().size() < 4){
            ramService.createRam(ram);
            motherBoard.addRam(ram);

            return motherBoardRepo.save(motherBoard);
        }
        throw new TooManyResoursesAddedException("MotherBoard has 4 sticks or ram already");
    }

    public MotherBoard addHddToMotherBoard(Long id, Long hddId){
        motherBoard = findMotherBoardById(id);
       HDD hdd = hddService.findHddById(hddId);

        motherBoard.addHdd(hdd);
       return motherBoardRepo.save(motherBoard);

    }

    public MotherBoard addSsdToMotherBoard(Long id, Long ssdId){
        motherBoard = findMotherBoardById(id);
        SSDrive ssd = ssdService.findSddById(ssdId);
        motherBoard.addSsd(ssd);
        return motherBoardRepo.save(motherBoard);

    }

    public MotherBoard updateGpu(Long id, Long graphicsId){
        motherBoard = findMotherBoardById(id);
        Graphics graphics = graphicsService.findGraphicsById(graphicsId);
        motherBoard.setGraphics(graphics);

        return motherBoardRepo.save(motherBoard);
    }

    public void deleteMotherBoardById(Long id){
        motherBoardRepo.deleteById(id);
    }

    public Boolean checkForMotherboard(Long id){
        for(MotherBoard motherBoard1 : getAllMotherBoards()){
            if (motherBoard1.getId().equals(id)){
                return true;
            }
        }
        return false;
    }

}
