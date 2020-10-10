package com.example.web.demowebpr.service;

import com.example.web.demowebpr.dao.DietsRepository;
import com.example.web.demowebpr.dao.entity.AddFileToDB;
import com.example.web.demowebpr.dao.entity.Diets;
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
    public Iterable<Diets> addDB(){
        return dietsRepository.saveAll(new AddFileToDB().add());
    }

    public List<Diets> getAllDiets(){
        return dietsRepository.findAll();
    }

    public Optional<Diets> getDietById(int id){
        return dietsRepository.findById(id);
    }

    public Diets addDiets(Diets diets){
        return dietsRepository.save(diets);
    }

    public void deleteAll(){
        dietsRepository.deleteAll();
    }

    public void deleteDietsById(int id){
        dietsRepository.deleteById(id);
    }

}
