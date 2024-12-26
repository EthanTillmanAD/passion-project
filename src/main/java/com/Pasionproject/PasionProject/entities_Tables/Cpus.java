package com.Pasionproject.PasionProject.entities_Tables;


import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

@Entity
public class Cpus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private final String title = "CPU";

    private String name;


    private Integer cores;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public  Integer getCores() {
        return cores;
    }

    public void setCores (Integer cores) {
        this.cores = cores;
    }

    public String getTitle() {
        return title;
    }


}
