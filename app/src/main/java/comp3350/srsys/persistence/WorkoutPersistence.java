package comp3350.srsys.persistence;

import comp3350.srsys.objects.Workout;

public interface WorkoutPersistence {
    boolean insertWorkout(final Workout w);

    boolean deleteWorkout(final Workout w);
}
