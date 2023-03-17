package comp3350.superset.tests.objects;

import org.junit.Test;
import static org.junit.Assert.*;

import comp3350.superset.objects.ExerciseList;
import comp3350.superset.objects.Routine;
import comp3350.superset.objects.Workout;

import java.time.Month;

public class WorkoutTest {

    @Test
    public void constructWorkout() {
        Routine r = new Routine("hello");
        Workout w1 = new Workout(r, 1, 100);
        Workout w2 = new Workout(r, -1, 100);
        Workout w3 =  new Workout(r, 5, -100);

        assertEquals(100, w1.getDurationSec());  // expected
        assertEquals(1, w2.getMonth());          // edge: invalid month provided (set to 1)
        assertEquals(0, w3.getDurationSec()) ;   // edge: invalid duation (set to 0)
    }
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
