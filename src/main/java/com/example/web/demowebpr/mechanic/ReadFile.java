package com.example.web.demowebpr.mechanic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadFile {
    public List<String> reader(String path) {
        List<String> diet = new ArrayList<>();
        try {
            BufferedReader reader1 = new BufferedReader(new FileReader(path));
            while (reader1.ready()) {
                diet.add(reader1.readLine());
            }
            reader1.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return diet;
    }
}
