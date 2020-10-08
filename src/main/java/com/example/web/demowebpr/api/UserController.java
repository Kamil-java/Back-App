package com.example.web.demowebpr.api;

import com.example.web.demowebpr.dao.entity.User;
import com.example.web.demowebpr.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Validated
@RestController
@RequestMapping("/api")
@CrossOrigin
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/")
    public List<User> GetUsers() {
        return userService.getAll();
    }
    @GetMapping("/{id}")
    public User GetUser(@PathVariable Integer id) {
        return userService.getUserById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND)
        );
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/")
    public User PostUser(@RequestBody @Validated User user) {
        return userService.addUser(user);
    }
    @PutMapping("/")
    public User PutUser(@RequestBody @Validated User user) {
        User oldUser = userService.getUserById(user.getId()).orElse(PostUser(user));
        oldUser.setAge(user.getAge());
        oldUser.setHeight(user.getHeight());
        oldUser.setWeight(user.getWeight());
        oldUser.setSex(user.getSex());
        return userService.addUser(oldUser);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void DeleteUser(@PathVariable Integer id) {
        if (userService.getUserById(id).isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        userService.deleteUserById(id);
    }
}
