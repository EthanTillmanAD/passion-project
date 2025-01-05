package com.Pasionproject.PasionProject.entities_Tables;

import com.Pasionproject.PasionProject.enums.BigSize;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
public class SSDrive {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private final String title = "SSD";

    @NotEmpty
    private String name;

    @NotNull
    private BigSize size;

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

    public @NotNull BigSize getSize() {
        return size;
    }

    public void setSize(@NotNull BigSize size) {
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
