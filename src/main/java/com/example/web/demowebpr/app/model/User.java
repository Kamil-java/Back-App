package com.example.web.demowebpr.app.model;

import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Validated
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Min(18)
    @Max(99)
    private int age;
    @Min(50)
    @Max(272)
    private int height;
    @Min(20)
    @Max(400)
    private int weight;
    @NotBlank
    private String sex;
    @Min(1)
    @Max(7)
    private int workoutTime;
    private double result;


    public User() {
    }

    public User(int age, int height, int weight, @NotBlank String sex, int workoutTime) {
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.sex = sex;
        this.workoutTime = workoutTime;
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

    public void setResult(double result) {
        this.result = result;
    }

    public int getWorkoutTime() {
        return workoutTime;
    }

    public void setWorkoutTime(int workoutTime) {
        this.workoutTime = workoutTime;
    }
}
