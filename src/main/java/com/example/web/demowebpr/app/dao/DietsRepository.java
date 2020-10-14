package com.example.web.demowebpr.app.dao;

import com.example.web.demowebpr.app.model.Diet;
import com.example.web.demowebpr.app.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DietsRepository extends JpaRepository<Diet, Integer> {
    @Query("SELECT m FROM User m WHERE m.id=:id")
    User getResult(@Param("id") int id);
}
