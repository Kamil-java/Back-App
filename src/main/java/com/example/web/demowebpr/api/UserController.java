package com.example.web.demowebpr.api;

import com.example.web.demowebpr.dao.entity.CalculatorKcal;
import com.example.web.demowebpr.dao.entity.User;
import com.example.web.demowebpr.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public List<User> getUsers() {
        return userService.getAll();
    }

    @GetMapping("/result/{id}")
    public double getResult(@PathVariable int id) {
        return new CalculatorKcal(getUser(id)).bmi();
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable Integer id) {
        return userService.getUserById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND)
        );
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/")
    public User addUser(@RequestBody @Validated User user) {
        return userService.addUser(user);
    }

    @PutMapping("/")
    public User updateUser(@RequestBody @Validated User user) {
        User oldUser = userService.getUserById(user.getId()).orElse(addUser(user));
        oldUser.setAge(user.getAge());
        oldUser.setHeight(user.getHeight());
        oldUser.setWeight(user.getWeight());
        oldUser.setSex(user.getSex());
        return userService.addUser(oldUser);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable Integer id) {
        if (userService.getUserById(id).isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        userService.deleteUserById(id);
    }
}
