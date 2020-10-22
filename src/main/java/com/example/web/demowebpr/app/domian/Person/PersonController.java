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
    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/")
    public List<Person> getPerson() {
        return personService.getAll();
    }


    @GetMapping("/{id}")
    public Person getPerson(@PathVariable Integer id) {
        return personService.getPersonById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND)
        );
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/")
    public Person addPerson(@RequestBody @Validated Person person) {
        if (getPerson().size() == 4) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "You can't add more users!!!");
        }
        person.setResult(new CalculatorKcal(person).result());
        return personService.addUser(person);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Person> updateUser(@RequestBody @Validated Person person, @PathVariable int id) {
        Person oldPerson = personService.getPersonById(id).orElse(addPerson(person));
        oldPerson.setAge(person.getAge());
        oldPerson.setHeight(person.getHeight());
        oldPerson.setWeight(person.getWeight());
        oldPerson.setSex(person.getSex());
        oldPerson.setWorkoutTime(person.getWorkoutTime());
        oldPerson.setResult(new CalculatorKcal(oldPerson).result());
        if (personService.getPersonById(id).isPresent()) {
            return ResponseEntity.ok(personService.addUser(oldPerson));
        } else {
            return ResponseEntity.status(HttpStatus.CREATED).body(oldPerson);
        }


    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable Integer id) {
        if (personService.getPersonById(id).isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        personService.deletePersonById(id);
    }
}
