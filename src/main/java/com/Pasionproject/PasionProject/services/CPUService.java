package com.Pasionproject.PasionProject.services;



import com.Pasionproject.PasionProject.entities_Tables.Cpus;
import com.Pasionproject.PasionProject.exception.NotFoundException;
import com.Pasionproject.PasionProject.repos.CpuRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class CPUService {

    @Autowired
    CpuRepo cpuRepo;


    public Cpus createCpu(Cpus cpu){
        return cpuRepo.save(cpu);
    }

    public List<Cpus> allSsd(){
        List<Cpus> cpus = new ArrayList<>();
        for (Cpus cpu: cpuRepo.findAll()){
            cpus.add(cpu);
        }
        return cpus;
    }

    public Cpus findCpuById(Long id){
        for (Cpus cpu: allSsd()){
            if (cpu.getId().equals(id)){
                return cpu;
            }
        }
        throw new NotFoundException("Cpu not found with id: " + id);
    }

    public Cpus updateCpu(Cpus cpu, Long id){

        Cpus updateCpu = findCpuById(id);

        updateCpu.setName(cpu.getName());
        updateCpu.setCores(cpu.getCores());

        return cpuRepo.save(updateCpu);
    }

    public void deleteCpuById(Long id){
        cpuRepo.deleteById(id);
    }

}
