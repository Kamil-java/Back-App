package com.example.web.demowebpr.app.mechanic;


import com.example.web.demowebpr.app.model.Person;

public class CalculatorKcal {
    private final Person person;

    public CalculatorKcal(Person person) {
        this.person = person;
    }

    private int bmr(){
        if (person.getSex()
                .toUpperCase().equals("MAN")) {
            return (int)((9.99 * person.getWeight()) + (6.25 * person.getHeight()) - (4.92 * person.getAge()) + 5);
        }
        return (int)((9.99 * person.getWeight()) + (6.25 * person.getHeight()) - (4.92 * person.getAge()) -161);
    }

    private int eat(){
        return (person.getWorkoutTime()*60*8)/7;
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
