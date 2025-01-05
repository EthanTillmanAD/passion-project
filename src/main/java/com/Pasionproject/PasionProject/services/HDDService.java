package com.Pasionproject.PasionProject.services;


import com.Pasionproject.PasionProject.entities_Tables.HDD;
import com.Pasionproject.PasionProject.exception.NotFoundException;
import com.Pasionproject.PasionProject.repos.HDDRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HDDService {

    @Autowired
    HDDRepo hddRepo;

    public HDD createHdd(HDD hdd){

       HDD newHdd = hddRepo.save(hdd);

        newHdd.setAmount();
        return hddRepo.save(newHdd);
    }

    public List<HDD> allHdd(){
        List<HDD> hdds = new ArrayList<>();
        for (HDD hdd: hddRepo.findAll()){
            hdds.add(hdd);
        }
        return hdds;
    }

    public HDD findHddById(Long id){
        for (HDD hdd: allHdd()){
            if (hdd.getId().equals(id)){
                return hdd;
            }
        }
        throw new NotFoundException("HDD not found with id: " + id);
    }

    public HDD updateHdd(HDD hdd, Long id){

       HDD updateHdd = findHddById(id);

       updateHdd.setName(hdd.getName());
       updateHdd.setSize(hdd.getSize());
       updateHdd.setAmount();

       return hddRepo.save(updateHdd);
    }

    public void deleteHddById(Long id){
        hddRepo.deleteById(id);
    }


}
