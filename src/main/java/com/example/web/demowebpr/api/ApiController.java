package com.example.web.demowebpr.api;

import com.example.web.demowebpr.mechanic.CalculatorKcal;
import com.example.web.demowebpr.dao.entity.Diets;
import com.example.web.demowebpr.dao.entity.User;
import com.example.web.demowebpr.service.DietsService;
import com.example.web.demowebpr.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ApiController {
    private final UserService userService;
    private final DietsService dietsService;

    @Autowired
    public ApiController(UserService userService, DietsService dietsService) {
        this.userService = userService;
        this.dietsService = dietsService;
        dietsService.addDB();
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return userService.getAll();
    }

    @GetMapping("/user/result/{id}")
    public double getResult(@PathVariable int id) {
        return new CalculatorKcal(getUser(id)).bmi();
    }

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable Integer id) {
        return userService.getUserById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND)
        );
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/user")
    public User addUser(@RequestBody @Validated User user) {
        return userService.addUser(user);
    }

    @PutMapping("/user")
    public User updateUser(@RequestBody @Validated User user) {
        User oldUser = userService.getUserById(user.getId()).orElse(addUser(user));
        oldUser.setAge(user.getAge());
        oldUser.setHeight(user.getHeight());
        oldUser.setWeight(user.getWeight());
        oldUser.setSex(user.getSex());
        return userService.addUser(oldUser);
    }

    @DeleteMapping("/user/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable Integer id) {
        if (userService.getUserById(id).isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        userService.deleteUserById(id);
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
