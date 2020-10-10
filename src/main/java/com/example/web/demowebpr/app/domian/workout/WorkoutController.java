package com.example.web.demowebpr.app.domian.workout;

import com.example.web.demowebpr.app.domian.workout.service.WorkoutService;
import com.example.web.demowebpr.app.model.Workout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

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
    public Workout getDietsById(@PathVariable int id) {
        return workoutService.getWorkoutById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND)
        );
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/")
    public Workout addDiet(@RequestBody @Validated Workout workout) {
        return workoutService.addWorkout(workout);
    }

    @PutMapping("/{id}")
    public Workout updateDiet(@RequestBody @Validated Workout workout,@PathVariable int id) {
        Workout oldWorkout = workoutService.getWorkoutById(id).orElse(addDiet(workout));
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
