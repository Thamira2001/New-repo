package comp3350.srsys.business;

import java.util.Collections;
import java.util.List;

import comp3350.srsys.application.Services;
import comp3350.srsys.objects.Workout;
import comp3350.srsys.persistence.WorkoutPersistence;

public class AccessWorkouts {
    private WorkoutPersistence workoutPersistence;
    private List<Workout> workouts;
    private Workout workout;
    private int currentWorkout;

    public AccessWorkouts() {
        workoutPersistence = Services.getWorkoutPersistence();
        workouts = null;
        workout = null;
        currentWorkout = 0;
    }

    public AccessWorkouts(final WorkoutPersistence workoutPersistence) {
        this();
        this.workoutPersistence = workoutPersistence;
    }

    public List<Workout> getWorkouts() {
        workouts = workoutPersistence.getWorkoutSequential();
        return Collections.unmodifiableList(workouts);
    }

    public Workout getSequential()
    {
        if(workouts == null)
        {
            workouts = workoutPersistence.getWorkoutSequential();
            currentWorkout = 0;
        }
        if(currentWorkout < workouts.size())
        {
            workout = workouts.get(currentWorkout);
            currentWorkout ++;
        }
        else
        {
            workouts = null;
            workout = null;
            currentWorkout = 0;
        }
        return workout;
    }

    boolean insertWorkout(final Workout currentWorkout) {
        return workoutPersistence.insertWorkout(currentWorkout);
    }

    boolean deleteWorkout(final Workout currentWorkout) {
        return workoutPersistence.deleteWorkout(currentWorkout);
    }
}