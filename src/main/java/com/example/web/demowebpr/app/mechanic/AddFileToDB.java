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
    public Set<Workout> addWorkout(String path){
        List<String> data = new ReadFile().reader(path);
        return data.stream().map(Workout::new).collect(Collectors.toCollection(LinkedHashSet::new));

    }
}
