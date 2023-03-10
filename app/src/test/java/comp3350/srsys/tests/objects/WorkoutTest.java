package comp3350.srsys.tests.objects;

import org.junit.Test;
import static org.junit.Assert.*;

import comp3350.srsys.objects.ExerciseList;
import comp3350.srsys.objects.Routine;
import comp3350.srsys.objects.Workout;

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
        Workout workout = new Workout(routine, Month.MARCH, 60);
        assertEquals(Month.MARCH, workout.getMonth());
    }
}
