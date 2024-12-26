package com.Pasionproject.PasionProject.services;

import com.Pasionproject.PasionProject.entities_Tables.Graphics;
import com.Pasionproject.PasionProject.entities_Tables.HDD;
import com.Pasionproject.PasionProject.exception.NotFoundException;
import com.Pasionproject.PasionProject.repos.GraphicsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GraphicsService {

    @Autowired
    GraphicsRepo graphicsRepo;

    public Graphics createGraphics(Graphics graphics){
        return graphicsRepo.save(graphics);
    }

    public List<Graphics> allGraphics(){
        List<Graphics> graphics = new ArrayList<>();
        for (Graphics graphic: graphicsRepo.findAll()){
            graphics.add(graphic);
        }
        return graphics;
    }

    public Graphics findGraphicsById(Long id){
        for (Graphics graphics: allGraphics()){
            if (graphics.getId().equals(id)){
                return graphics;
            }
        }
        throw new NotFoundException("Graphics card not found with id: " + id);
    }

    public Graphics updateGraphicsCard(Graphics graphics, Long id){

        Graphics updateGraphics = findGraphicsById(id);

        updateGraphics.setName(graphics.getName());
        updateGraphics.setSize(graphics.getSize());

        return graphicsRepo.save(updateGraphics);
    }

    public void deleteGraphicsById(Long id){
        graphicsRepo.deleteById(id);
    }

}
