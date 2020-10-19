package com.example.web.demowebpr.app.domian.user.service;

import com.example.web.demowebpr.app.dao.PersonRepository;
import com.example.web.demowebpr.app.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {
    private final PersonRepository personRepository;


    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> getAll() {
        return personRepository.findAll();
    }

    public Optional<Person> getUserById(Integer id) {
        return personRepository.findById(id);
    }

    public Person addUser(Person person) {
        return personRepository.save(person);
    }

    public void deleteUserById(Integer id) {
        personRepository.deleteById(id);
    }
}
