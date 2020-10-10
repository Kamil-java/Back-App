package com.example.web.demowebpr.app.dao;

import com.example.web.demowebpr.app.model.Diet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DietsRepository extends JpaRepository<Diet, Integer> {

}
