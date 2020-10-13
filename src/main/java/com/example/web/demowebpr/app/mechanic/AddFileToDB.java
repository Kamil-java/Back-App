package com.example.web.demowebpr.app.mechanic;


import com.example.web.demowebpr.app.model.Diet;
import com.example.web.demowebpr.app.model.Workout;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class AddFileToDB {

    public Set<Diet> addDiet(String path){
        List<String> data = new ReadFile().reader(path);
        return data.stream().map(Diet::new).collect(Collectors.toCollection(LinkedHashSet::new));
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
}
