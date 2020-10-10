package com.example.web.demowebpr.app.model;

import org.springframework.validation.annotation.Validated;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Diet {
    @Id
    @GeneratedValue
    private Integer id;
    @NotBlank
    private String diet;

    public Diet() {
    }

    public Diet(@NotBlank @Validated String diet) {
        this.diet = diet;
    }

    public Integer getId() {
        return id;
    }

    public String getDiet() {
        return diet;
    }

    public void setDiet(String diet) {
        this.diet = diet;
    }
}
