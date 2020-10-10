package com.example.web.demowebpr.app.domian.diet.service;

import com.example.web.demowebpr.app.dao.DietsRepository;
import com.example.web.demowebpr.app.mechanic.AddFileToDB;
import com.example.web.demowebpr.app.model.Diet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DietsService {
    private final DietsRepository dietsRepository;

    @Autowired
    public DietsService(DietsRepository dietsRepository) {
        this.dietsRepository = dietsRepository;
    }

    public void addDB() {
        dietsRepository.saveAll(new AddFileToDB().addDiet("FileToRead/Diets.txt"));
    }

    public List<Diet> getAllDiets() {
        return dietsRepository.findAll();
    }

    public Optional<Diet> getDietById(int id) {
        return dietsRepository.findById(id);
    }

    public Diet addDiets(Diet diet) {
        return dietsRepository.save(diet);
    }

    public void deleteAll() {
        dietsRepository.deleteAll();
    }

    public void deleteDietsById(int id) {
        dietsRepository.deleteById(id);
    }

}
