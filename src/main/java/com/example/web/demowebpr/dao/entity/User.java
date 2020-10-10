package com.example.web.demowebpr.dao.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private int age;
    private int height;
    private int weight;
    @NotBlank
    private String sex;
    @OneToOne
    private CalculatorKcal kcal;

    public User() {
    }

    public User(int age, int height, int weight, @NotBlank String sex, CalculatorKcal kcal) {
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.sex = sex;
        this.kcal = kcal;
    }

    public Integer getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public CalculatorKcal getKcal() {
        return kcal;
    }

    public void setKcal(CalculatorKcal kcal) {
        this.kcal = kcal;
    }
}
