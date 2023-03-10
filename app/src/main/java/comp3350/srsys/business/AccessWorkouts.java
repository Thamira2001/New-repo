package comp3350.srsys.business;

import java.util.Collections;
import java.util.List;

import comp3350.srsys.application.Services;
import comp3350.srsys.objects.Workout;
import comp3350.srsys.persistence.WorkoutPersistence;

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