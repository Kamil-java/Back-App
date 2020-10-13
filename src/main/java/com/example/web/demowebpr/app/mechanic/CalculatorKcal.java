package com.example.web.demowebpr.app.mechanic;


import com.example.web.demowebpr.app.model.User;

public class CalculatorKcal {
    private final User user;

    public CalculatorKcal(User user) {
        this.user = user;
    }

    private int bmr(){
        if (user.getSex()
                .toUpperCase().equals("MAN")) {
            return (int)((9.99 * user.getWeight()) + (6.25 * user.getHeight()) - (4.92 * user.getAge()) + 5);
        }
        return (int)((9.99 * user.getWeight()) + (6.25 * user.getHeight()) - (4.92 * user.getAge()) -161);
    }

    private int eat(){
        return (user.getWorkoutTime()*60*8)/7;
    }

    private int neat(){
        return bmr()+eat()+500;
    }
    private int tdee(){
        return (int) (neat()+(0.1*neat()));
    }

    public int result(){
        return tdee()+300;
    }
}
