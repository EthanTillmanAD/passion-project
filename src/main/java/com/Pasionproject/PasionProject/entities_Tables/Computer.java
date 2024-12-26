package com.Pasionproject.PasionProject.entities_Tables;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
public class Computer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private final String title = "COMPUTER";


    @OneToOne
    @JoinColumn(name = "pc_case")
    @NotNull
    private PcCase aCase;

    @OneToOne
    @JoinColumn(name = "power_supply")
    @NotNull
    private PowerSupply powerSupply;

    @OneToOne
    @JoinColumn(name = "mother_board")
    @NotNull
    private MotherBoard motherBoard;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PcCase getaCase() {
        return aCase;
    }

    public void setaCase(PcCase aCase) {
        this.aCase = aCase;
    }

    public PowerSupply getPowerSupply() {
        return powerSupply;
    }

    public void setPowerSupply(PowerSupply powerSupply) {
        this.powerSupply = powerSupply;
    }

    public MotherBoard getMotherBoard() {
        return motherBoard;
    }

    public void setMotherBoard(MotherBoard motherBoard) {
        this.motherBoard = motherBoard;
    }

    public String getTitle() {
        return title;
    }
}
