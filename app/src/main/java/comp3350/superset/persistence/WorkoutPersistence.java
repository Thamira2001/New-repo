package comp3350.superset.persistence;

import java.util.List;

import comp3350.superset.objects.Workout;

public interface WorkoutPersistence {
    List<Workout> getWorkoutSequential();

    boolean insertWorkout(final Workout w);
}
