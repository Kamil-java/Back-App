package com.example.web.demowebpr.app.domian.diet;

import com.example.web.demowebpr.app.model.Diet;
import com.example.web.demowebpr.app.domian.diet.service.DietsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/diet")
@CrossOrigin
public class DietController {
    private final DietsService dietsService;

    @Autowired
    public DietController(DietsService dietsService) {
        this.dietsService = dietsService;
        dietsService.addDB();
    }

    @GetMapping("/")
    public List<Diet> getAll() {
        return dietsService.getAllDiets();
    }

    @GetMapping("/{id}")
    public Diet getDietsById(@PathVariable int id) {
        return dietsService.getDietById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND)
        );
    }

    @GetMapping("/result/{id}")
    public List<Diet> getResult(@PathVariable int id){
        return dietsService.getDietToUserResult(id);
    }

    @GetMapping("/for/{id}")
    public List<Diet> getDietsForAll(@PathVariable int id){
        return dietsService.getDietsFor(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/")
    public Diet addDiet(@RequestBody @Validated Diet diet) {
        return dietsService.addDiets(diet);
    }

    @PutMapping("/{id}")
    public Diet updateDiet(@RequestBody @Validated Diet diet,@PathVariable int id) {
        Diet oldDiet = dietsService.getDietById(id).orElse(addDiet(diet));
        oldDiet.setDiet(diet.getDiet());
        return dietsService.addDiets(oldDiet);
    }

    @DeleteMapping("/all")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAll() {
        dietsService.deleteAll();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable int id) {
        dietsService.deleteDietsById(id);
    }
}
