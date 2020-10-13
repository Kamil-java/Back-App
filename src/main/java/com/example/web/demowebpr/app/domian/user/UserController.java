package com.example.web.demowebpr.app.domian.user;

import com.example.web.demowebpr.app.mechanic.CalculatorKcal;
import com.example.web.demowebpr.app.model.User;
import com.example.web.demowebpr.app.domian.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Validated
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


    @GetMapping("/{id}")
    public User getUser(@PathVariable Integer id) {
        return userService.getUserById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND)
        );
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/")
    public User addUser(@RequestBody @Validated User user) {
        if (getUsers().size() == 4) {
            throw new ResponseStatusException(HttpStatus.INSUFFICIENT_STORAGE, "You can't add more users!!!");
        }
        user.setResult(new CalculatorKcal(user).result());
        return userService.addUser(user);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@RequestBody @Validated User user, @PathVariable int id) {
        User oldUser = userService.getUserById(id).orElse(addUser(user));
        oldUser.setAge(user.getAge());
        oldUser.setHeight(user.getHeight());
        oldUser.setWeight(user.getWeight());
        oldUser.setSex(user.getSex());
        oldUser.setWorkoutTime(user.getWorkoutTime());
        oldUser.setResult(new CalculatorKcal(oldUser).result());
        if (userService.getUserById(id).isPresent()) {
            return ResponseEntity.ok(userService.addUser(oldUser));
        } else {
            return ResponseEntity.status(HttpStatus.CREATED).body(oldUser);
        }


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
