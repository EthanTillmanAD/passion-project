package com.Pasionproject.PasionProject.entities_Tables;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

@Entity
@Table(name = "mother_board")
public class MotherBoard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private final String title = "MB";

    @OneToOne
    @JoinColumn(name = "graphics")
    @NotNull
    private Graphics graphics;

    @OneToOne
    @JoinColumn(name = "cpu")
    @NotNull
    private Cpus cpu;

    @OneToMany
    @JoinColumn(name = "ram")
    @NotNull
    @Size(min = 2, max = 4)
    private Set<Ram> ram = new HashSet<>();

    @OneToMany
    @JoinColumn(name = "ssdrive")
    @NotNull
    private Set<SSDrive> ssd = new HashSet<>();

    @OneToMany
    @JoinColumn(name = "hdd")
    @NotNull
    private Set<HDD> hdd = new HashSet<>();




    public MotherBoard() {



    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Graphics getGraphics() {
        return graphics;
    }

    public void setGraphics(Graphics graphics) {
        this.graphics = graphics;
    }

    public Cpus getCpu() {
        return cpu;
    }

    public void setCpu(Cpus cpu) {
        this.cpu = cpu;
    }

    public Set<Ram> getRam() {
        return ram;
    }

    public void setRam(Set<Ram> ram) {
        this.ram = ram;
    }

    public  Set<SSDrive> getSsd() {
        return ssd;
    }

    public void setSsd( Set<SSDrive> ssd) {
        this.ssd = ssd;
    }

    public  Set<HDD> getHdd() {
        return hdd;
    }

    public void setHdd( Set<HDD> hdd) {
        this.hdd = hdd;
    }

    public void addRam (Ram ram){
        this.ram.add(ram);
    }
    public void addHdd(HDD hdd){
        this.hdd.add(hdd);
    }
    public void addSsd(SSDrive ssd){
        this.ssd.add(ssd);
    }

    public String getTitle() {
        return title;
    }
}
