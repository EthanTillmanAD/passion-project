package com.Pasionproject.PasionProject.services;

import com.Pasionproject.PasionProject.entities_Tables.SSDrive;
import com.Pasionproject.PasionProject.exception.NotFoundException;
import com.Pasionproject.PasionProject.repos.SSDRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SSDService {

    @Autowired
    SSDRepo sddRepo;

    public SSDrive createSdd(SSDrive sdd){
        return sddRepo.save(sdd);
    }

    public List<SSDrive> allSsd(){
        List<SSDrive> ssds = new ArrayList<>();
        for (SSDrive ssd: sddRepo.findAll()){
            ssds.add(ssd);
        }
        return ssds;
    }

    public SSDrive findSddById(Long id){
        for (SSDrive ssd: allSsd()){
            if (ssd.getId().equals(id)){
                return ssd;
            }
        }
        throw new NotFoundException("Ssd not found with id: " + id);
    }

    public SSDrive updateSdd(SSDrive ssd, Long id){

        SSDrive updateSsd = findSddById(id);

        updateSsd.setName(ssd.getName());
        updateSsd.setSize(ssd.getSize());

        return sddRepo.save(updateSsd);
    }

    public void deleteHddById(Long id){
        sddRepo.deleteById(id);
    }
}
