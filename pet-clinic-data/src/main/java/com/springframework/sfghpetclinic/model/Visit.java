package com.springframework.sfghpetclinic.model;

import java.time.LocalDate;

/**
 * @author <a href="pulkit.aggarwal@upgrad.com">Pulkit Aggarwal</a>
 * @version 1.0
 * @since 10/09/21
 */
public class Visit extends BaseEntity {
    private LocalDate date;
    private String description;
    private Pet pet;

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }
}
