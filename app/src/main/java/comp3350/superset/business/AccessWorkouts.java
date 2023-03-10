package comp3350.superset.business;

import java.util.Collections;
import java.util.List;

import comp3350.superset.application.Services;
import comp3350.superset.objects.Workout;
import comp3350.superset.persistence.WorkoutPersistence;

public class AccessWorkouts {
    private WorkoutPersistence workoutPersistence;
    private List<Workout> workouts;

    public AccessWorkouts() {
        workoutPersistence = Services.getWorkoutPersistence();
        workouts = null;
    }
    public AccessWorkouts(WorkoutPersistence instance) {
        workoutPersistence = instance;
    }

    public List<Workout> getWorkouts() {
        workouts = workoutPersistence.getWorkoutSequential();
        return Collections.unmodifiableList(workouts);
    }

    public boolean insertWorkout(final Workout currentWorkout) {
        return workoutPersistence.insertWorkout(currentWorkout);
    }
}