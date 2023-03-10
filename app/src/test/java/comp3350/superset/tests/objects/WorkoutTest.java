package comp3350.superset.tests.objects;

import org.junit.Test;
import static org.junit.Assert.*;

import comp3350.superset.objects.ExerciseList;
import comp3350.superset.objects.Routine;
import comp3350.superset.objects.Workout;

import java.time.Month;

public class WorkoutTest {
    @Test
    public void testGetRoutine() {
        ExerciseList exercises = new ExerciseList();
        Routine routine = new Routine("Chest Day", exercises);
        Workout workout = new Workout(routine, 60);
        assertEquals(routine, workout.getRoutine());
    }

    @Test
    public void testGetDurationSec() {
        ExerciseList exercises = new ExerciseList();
        Routine routine = new Routine("Chest Day", exercises);
        Workout workout = new Workout(routine, 60);
        assertEquals(60, workout.getDurationSec());
    }

    @Test
    public void testGetMonth() {
        ExerciseList exercises = new ExerciseList();
        Routine routine = new Routine("Chest Day", exercises);
        Workout workout = new Workout(routine, 3, 60);
        assertEquals(Month.MARCH.getValue(), workout.getMonth());
    }
}
