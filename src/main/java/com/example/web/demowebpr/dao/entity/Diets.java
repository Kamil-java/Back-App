package com.example.web.demowebpr.dao.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Diets {
    @Id
    @GeneratedValue
    private Integer id;
    private String diet;

    public Diets() {
    }

    public Diets(String diet) {
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
