package com.example.web.demowebpr.app.dao;

import com.example.web.demowebpr.app.model.Workout;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkoutRepository extends JpaRepository<Workout,Integer> {

}
