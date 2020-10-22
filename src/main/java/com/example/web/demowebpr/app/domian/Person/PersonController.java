package com.example.web.demowebpr.app.domian.Person;

import com.example.web.demowebpr.app.mechanic.CalculatorKcal;
import com.example.web.demowebpr.app.model.Person;
import com.example.web.demowebpr.app.domian.Person.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Validated
@RestController
@RequestMapping("/person")
@CrossOrigin
public class PersonController {
    private final PersonService userService;

    @Autowired
    public PersonController(PersonService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public List<Person> getUsers() {
        return userService.getAll();
    }


    @GetMapping("/{id}")
    public Person getUser(@PathVariable Integer id) {
        return userService.getUserById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND)
        );
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/")
    public Person addUser(@RequestBody @Validated Person person) {
        if (getUsers().size() == 4) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "You can't add more users!!!");
        }
        person.setResult(new CalculatorKcal(person).result());
        return userService.addUser(person);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Person> updateUser(@RequestBody @Validated Person person, @PathVariable int id) {
        Person oldPerson = userService.getUserById(id).orElse(addUser(person));
        oldPerson.setAge(person.getAge());
        oldPerson.setHeight(person.getHeight());
        oldPerson.setWeight(person.getWeight());
        oldPerson.setSex(person.getSex());
        oldPerson.setWorkoutTime(person.getWorkoutTime());
        oldPerson.setResult(new CalculatorKcal(oldPerson).result());
        if (userService.getUserById(id).isPresent()) {
            return ResponseEntity.ok(userService.addUser(oldPerson));
        } else {
            return ResponseEntity.status(HttpStatus.CREATED).body(oldPerson);
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
