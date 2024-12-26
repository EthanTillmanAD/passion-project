package com.Pasionproject.PasionProject.services;

import com.Pasionproject.PasionProject.entities_Tables.PowerSupply;
import com.Pasionproject.PasionProject.exception.NotFoundException;
import com.Pasionproject.PasionProject.repos.PowerSupplyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PowerSupplyService {

    @Autowired
    PowerSupplyRepo powerSupplyRepo;

    public PowerSupply createPowerSupply(PowerSupply powerSupply){
        return powerSupplyRepo.save(powerSupply);
    }

    public List<PowerSupply> listAllPowerSupply(){
        List<PowerSupply> powerSupplies = new ArrayList<>();

        for (PowerSupply powerSupply: powerSupplyRepo.findAll()){
            powerSupplies.add(powerSupply);
        }
        return powerSupplies;
    }

    public PowerSupply findPowerSupplyById(Long id){
            for (PowerSupply powerSupply: listAllPowerSupply()){
                if (powerSupply.getId().equals(id)){
                    return powerSupply;
                }
            }
            throw new NotFoundException("Power Supply not found with id: "+ id);
    }

    public PowerSupply updatePowerSupplyInfo(Long id, PowerSupply powerSupply){
        PowerSupply powerSupply1 = findPowerSupplyById(id);

        powerSupply1.setWatts(powerSupply.getWatts());
        powerSupply1.setName(powerSupply.getName());

       return powerSupplyRepo.save(powerSupply1);
    }

    public void deletePowerSupplyById(Long id){
        powerSupplyRepo.deleteById(id);
    }


}
