package com.Pasionproject.PasionProject.entities_Tables;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
public class Cpus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private final String title = "CPU";

    @NotEmpty
    private String name;

    @NotNull
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


    public int getCores() {
        return cores;
    }

    public void setCores( int cores) {
        this.cores = cores;
    }

    public String getTitle() {
        return title;
    }


}
