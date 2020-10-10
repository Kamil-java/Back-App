package com.example.web.demowebpr.dao.entity;

import javax.persistence.*;

@Entity
public class CalculatorKcal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @OneToOne
    private User user;

    public CalculatorKcal() {
    }

    public CalculatorKcal(User user) {
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public double bmi(){
        if (user.getSex()
                .toUpperCase().equals("MAN")) {
            return (9.99 * user.getWeight()) + (6.25 * user.getHeight()) - (4.92 * user.getAge()) + 5;
        }
        return (9.99 * user.getWeight()) + (6.25 * user.getHeight()) - (4.92 * user.getAge()) -161;
    }
}
