package com.example.web.demowebpr.api;

import com.example.web.demowebpr.dao.entity.Diets;
import com.example.web.demowebpr.service.DietsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class DietsController {
    private final DietsService dietsService;

    @Autowired
    public DietsController(DietsService dietsService) {
        this.dietsService = dietsService;
    }

    @GetMapping("/diets")
    public List<Diets> getAll() {
        return dietsService.getAllDiets();
    }

    @GetMapping("/diet/{id}")
    public Diets getDietsById(@PathVariable int id) {
        return dietsService.getDietById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND)
        );
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/diet")
    public Diets addDiet(@RequestBody @Validated Diets diets) {
        return dietsService.addDiets(diets);
    }

    @PutMapping("/diet")
    public Diets updateDiet(@RequestBody @Validated Diets diets) {
        Diets oldDiet = dietsService.getDietById(diets.getId()).orElse(addDiet(diets));
        oldDiet.setDiet(diets.getDiet());
        return dietsService.addDiets(oldDiet);
    }

    @DeleteMapping("/diets/all")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAll() {
        dietsService.deleteAll();
    }

    @DeleteMapping("/diet/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable int id) {
        dietsService.deleteDietsById(id);
    }
}
