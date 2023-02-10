package comp3350.srsys.persistence;

import java.util.List;

import comp3350.srsys.objects.Workout;

public interface WorkoutPersistence {
    List<Workout> getWorkoutSequential();

    boolean insertWorkout(final Workout w);

    boolean deleteWorkout(final Workout w);
}
