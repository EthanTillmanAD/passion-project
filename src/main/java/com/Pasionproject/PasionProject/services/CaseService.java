package com.Pasionproject.PasionProject.services;

import com.Pasionproject.PasionProject.entities_Tables.PcCase;
import com.Pasionproject.PasionProject.exception.NotFoundException;
import com.Pasionproject.PasionProject.repos.CaseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CaseService {

    @Autowired
    CaseRepo caseRepo;


    public List<PcCase> listOfCases (){
        List<PcCase> cases = new ArrayList<>();

        for (PcCase pcCase: caseRepo.findAll()){
            cases.add(pcCase);
        }
        return cases;
    }

    public PcCase findCaseById(Long id){
        for(PcCase pcCase: listOfCases()){
            if (pcCase.getId().equals(id)){
                return pcCase;
            }
        }
        throw new NotFoundException("Pc case not found with id: " + id);
    }

    public PcCase createPcCase (PcCase pcCase){
       return caseRepo.save(pcCase);
    }

    public void deleteCaseById(Long id){
        caseRepo.deleteById(id);
    }

    public PcCase updateCaseById(Long id, PcCase pcCase){
        PcCase case1 = findCaseById(id);

        case1.setName(pcCase.getName());
        case1.setColor(pcCase.getColor());

       return caseRepo.save(case1);

    }


}
