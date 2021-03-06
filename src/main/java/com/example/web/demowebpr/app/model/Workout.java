package com.example.web.demowebpr.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Workout {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank
    private String titleWorkout;
    @NotBlank
    private String workout;
    private int intensity;

    public Workout() {
    }

    public Workout(@NotBlank String titleWorkout, @NotBlank String workout) {
        this.titleWorkout = titleWorkout;
        this.workout = workout;
    }

    public Workout(@NotBlank String titleWorkout, @NotBlank String workout, int intensity) {
        this.titleWorkout = titleWorkout;
        this.workout = workout;
        this.intensity = intensity;
    }

    public Integer getId() {
        return id;
    }

    public String getWorkout() {
        return workout;
    }

    public void setWorkout(String workout) {
        this.workout = workout;
    }

    public String getTitleWorkout() {
        return titleWorkout;
    }

    public void setTitleWorkout(String titleWorkout) {
        this.titleWorkout = titleWorkout;
    }

    public int getIntensity() {
        return intensity;
    }

    public void setIntensity(int intensity) {
        this.intensity = intensity;
    }
}
