package com.example.web.demowebpr.app.dao;

import com.example.web.demowebpr.app.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Integer> {

}
