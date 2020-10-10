package com.example.web.demowebpr.app.model;

import com.example.web.demowebpr.app.mechanic.CalculatorKcal;

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
    private double result;

    public User() {
    }

    public User(int age, int height, int weight, @NotBlank String sex) {
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.sex = sex;
        this.result = getResult();
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

    public double getResult() {
        return result;
    }

    public double setResult(double result) {
        this.result = result;
            return result;
    }
}
