package com.example.web.demowebpr.app.mechanic;


import com.example.web.demowebpr.app.model.User;

public class CalculatorKcal {
    private final User user;

    public CalculatorKcal(User user) {
        this.user = user;
    }

    public int bmi(){
        if (user.getSex()
                .toUpperCase().equals("MAN")) {
            return (int)((9.99 * user.getWeight()) + (6.25 * user.getHeight()) - (4.92 * user.getAge()) + 5);
        }
        return (int)((9.99 * user.getWeight()) + (6.25 * user.getHeight()) - (4.92 * user.getAge()) -161);
    }
}
