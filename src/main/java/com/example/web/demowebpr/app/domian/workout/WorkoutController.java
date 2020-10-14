package com.example.web.demowebpr.app.domian.workout;

import com.example.web.demowebpr.app.domian.workout.service.WorkoutService;
import com.example.web.demowebpr.app.model.Workout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.constraints.Min;
import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("workout/")
@CrossOrigin
public class WorkoutController {
    private final WorkoutService workoutService;

    @Autowired
    public WorkoutController(WorkoutService workoutService) {
        this.workoutService = workoutService;
        workoutService.addDB();
    }

    @GetMapping("/")
    public List<Workout> getAll() {
        return workoutService.getAllWorkouts();
    }

    @GetMapping("/{id}")
    public Workout getWorkoutById(@PathVariable int id) {
        return workoutService.getWorkoutById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND)
        );
    }

    @GetMapping("/intensive")
    public List<Workout> getIntensiveWorkout(){
        return workoutService.getStrongWorkout(2);
    }
    @GetMapping("/optimal")
    public List<Workout> getOptimalWorkout(){
        return workoutService.getStrongWorkout(1);
    }


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/")
    public Workout addWorkout(@RequestBody @Validated Workout workout) {
        if (getAll().size() == 30){
            throw new ResponseStatusException(HttpStatus.INSUFFICIENT_STORAGE);
        }
        return workoutService.addWorkout(workout);
    }

    @PutMapping("/{id}")
    public Workout updateWorkout(@RequestBody @Validated Workout workout,@PathVariable int id) {
        Workout oldWorkout = workoutService.getWorkoutById(id).orElse(addWorkout(workout));
        oldWorkout.setTitleWorkout(workout.getTitleWorkout());
        oldWorkout.setWorkout(workout.getWorkout());
        return workoutService.addWorkout(oldWorkout);
    }

    @DeleteMapping("/all")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAll() {
        workoutService.deleteAll();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable int id) {
        workoutService.deleteWorkoutById(id);
    }
}
