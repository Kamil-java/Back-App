package com.example.web.demowebpr.app.dao;

import com.example.web.demowebpr.app.model.Diet;
import com.example.web.demowebpr.app.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface DietsRepository extends JpaRepository<Diet, Integer> {
    @Query("SELECT m FROM Person m WHERE m.id=:id")
    Person getResult(@Param("id") int id);

    @Query("SELECT m FROM Diet m WHERE m.forWhom<=:forWhom")
    List<Diet> getDietForWhom(@Param("forWhom") int id);
}
