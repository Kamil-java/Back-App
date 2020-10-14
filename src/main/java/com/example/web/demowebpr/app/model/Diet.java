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
    @NotBlank
    private String titleDiet;

    public Diet() {
    }

    public Diet(@NotBlank @Validated String diet, @NotBlank @Validated String titleDiet) {
        this.diet = diet;
        this.titleDiet = titleDiet;
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

    public String getTitleDiet() {
        return titleDiet;
    }

    public void setTitleDiet(String titleDiet) {
        this.titleDiet = titleDiet;
    }
}
