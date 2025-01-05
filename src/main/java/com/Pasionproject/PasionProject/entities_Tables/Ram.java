package com.Pasionproject.PasionProject.entities_Tables;


import com.Pasionproject.PasionProject.enums.SmallSize;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Ram {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private final String title = "RAM";

    @NotEmpty
    private String name;


    @NotNull
    private SmallSize size;


    private String amount;

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

    public SmallSize getSize() {
        return size;
    }

    public void setSize(SmallSize size) {
        this.size = size;
    }

    public String getTitle() {
        return title;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount() {
        this.amount = getSize().getType();
    }
}
