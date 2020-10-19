package com.example.web.demowebpr.app.domian.diet.service;

import com.example.web.demowebpr.app.dao.DietsRepository;
import com.example.web.demowebpr.app.mechanic.AddFileToDB;
import com.example.web.demowebpr.app.model.Diet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.LinkedList;
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
        dietsRepository.saveAll(new AddFileToDB().addDiet("FileToRead/Diets.txt", "FileToRead/TitleDiets.txt", "FileToRead/Kcal.txt","FileToRead/ForWhom.txt"));
    }

    public List<Diet> getAllDiets() {
        return dietsRepository.findAll();
    }

    public Optional<Diet> getDietById(int id) {
        return dietsRepository.findById(id);
    }

    public Diet getDietToUserResult(int id) {
        List<Diet> kcal = dietsRepository.findAll(Sort.by(Sort.Direction.ASC, "kcal"));
        for (Diet allDiet : kcal) {
            int result = (int) dietsRepository.getResult(id).getResult();
            if (result<=allDiet.getKcal()){
                    return allDiet;
                }
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    public List<Diet> getDietsFor(int id){
       return dietsRepository.getDietForWhom(id);
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
