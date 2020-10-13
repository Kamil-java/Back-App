package com.example.web.demowebpr.app.domian.workout.service;

import com.example.web.demowebpr.app.dao.WorkoutRepository;
import com.example.web.demowebpr.app.mechanic.AddFileToDB;
import com.example.web.demowebpr.app.model.Workout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorkoutService {
    private final WorkoutRepository workoutRepository;

    @Autowired
    public WorkoutService(WorkoutRepository workoutRepository) {
        this.workoutRepository = workoutRepository;
    }

    public void addDB(){
        workoutRepository.saveAll(new AddFileToDB().addWorkout("FileToRead/TitleWorkout.txt","FileToRead/Workout.txt", "FileToRead/Intensity.txt"));
    }

    public List<Workout> getAllWorkouts() {
        return workoutRepository.findAll();
    }

    public Optional<Workout> getWorkoutById(int id) {
        return workoutRepository.findById(id);
    }

    public Workout addWorkout(Workout Workout) {
        return workoutRepository.save(Workout);
    }

    public void deleteAll() {
        workoutRepository.deleteAll();
    }

    public void deleteWorkoutById(int id) {
        workoutRepository.deleteById(id);
    }
}
