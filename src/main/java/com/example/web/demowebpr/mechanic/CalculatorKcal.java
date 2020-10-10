package com.example.web.demowebpr.mechanic;

import com.example.web.demowebpr.dao.entity.User;

public class CalculatorKcal {
    private final User user;

    public CalculatorKcal(User user) {
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
