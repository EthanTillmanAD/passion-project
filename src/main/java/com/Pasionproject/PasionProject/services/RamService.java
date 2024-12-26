package com.Pasionproject.PasionProject.services;

import com.Pasionproject.PasionProject.entities_Tables.Ram;
import com.Pasionproject.PasionProject.exception.NotFoundException;
import com.Pasionproject.PasionProject.repos.RamRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RamService {

    @Autowired
    private RamRepo ramRepo;

    public Ram createRam(Ram ram){
       return ramRepo.save(ram);
    }

    public List<Ram> listOfCreatedRam(){
        List<Ram> allRam = new ArrayList<>();

        for (Ram ram: ramRepo.findAll()){
            allRam.add(ram);
        }
        return allRam;
    }

    public Ram findById(Long id){

        for (Ram ram1: listOfCreatedRam()){
            if (ram1.getId().equals(id)){
                return ram1;
            }
        }
            throw new NotFoundException("Ram with id: " + id + " not found");
    }

    public Ram adjustRam(Ram ram, Long id){

        Ram ramToUpdate = findById(id);

        ramToUpdate.setName(ram.getName());
        ramToUpdate.setSize(ram.getSize());

       return ramRepo.save(ramToUpdate);

    }

    public void removeRamById(Long id){
        ramRepo.deleteById(id);
    }




}
