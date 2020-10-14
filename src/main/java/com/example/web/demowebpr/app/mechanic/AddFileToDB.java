package com.example.web.demowebpr.app.mechanic;


import com.example.web.demowebpr.app.model.Diet;
import com.example.web.demowebpr.app.model.Workout;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class AddFileToDB {

    public Set<Diet> addDiet(String pathDiet, String pathTitle){
        List<String> dataDiet = new ReadFile().reader(pathDiet);
        List<String> dataTitle = new ReadFile().reader(pathTitle);
        Set<Diet> data =new LinkedHashSet<>();
        for (int i = 0; i < dataDiet.size(); i++) {
            crateDiet(data, dataDiet.get(i),dataTitle.get(i));
        }
        return data;
    }
    public Set<Workout> addWorkout(String pathTitle, String pathWorkout, String pathIntensity){
        List<String> dataWorkout = new ReadFile().reader(pathWorkout);
        List<String> dataTitle = new ReadFile().reader(pathTitle);
        List<String> dataIntensity = new ReadFile().reader(pathIntensity);
        Set<Workout> data = new LinkedHashSet<>();
        for (int i = 0; i < dataWorkout.size(); i++) {
                crateWorkout(data,dataTitle.get(i),dataWorkout.get(i), dataIntensity.get(i));

        }
        return data;
    }


    private void crateWorkout(Set<Workout> data, String title, String workout, String intensity) {
        int i = Integer.parseInt(intensity);
        Workout trening = new Workout(title, workout, i);
        data.add(trening);
    }
    private void crateDiet(Set<Diet> data, String title, String diet) {
        Diet trening = new Diet(title, diet);
        data.add(trening);
    }
}
