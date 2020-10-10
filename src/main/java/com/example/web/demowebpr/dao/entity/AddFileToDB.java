package com.example.web.demowebpr.dao.entity;


import com.example.web.demowebpr.mechanic.ReadFile;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class AddFileToDB {
    public Set<Diets> add(){
        List<String> diet = new ReadFile().reader("FileToRead/Diets.txt");
        Set<Diets> diets = new LinkedHashSet<>();
        for (String s : diet) {
            diets.add(new Diets(s));
        }
        return diets;
    }
}
