package comp3350.srsys.tests.objects;

import org.junit.Test;
import static org.junit.Assert.*;

import comp3350.srsys.objects.Routine;
import comp3350.srsys.objects.Workout;

public class WorkoutTest {
    private Routine routine = new Routine("Test Routine");

    @Test
    public void testConstructorWithStartAndEndTime() {
        long startTime = System.currentTimeMillis() / 1000;
        long endTime = startTime + 60;
        Workout workout = new Workout(routine, startTime, endTime);

        assertEquals(startTime, workout.getStartTimeSec());
        assertEquals(endTime, workout.getEndTimeSec());
    }

    @Test
    public void testConstructorWithoutStartAndEndTime() {
        Workout workout = new Workout(routine);

        assertEquals(-1, workout.getStartTimeSec());
        assertEquals(-1, workout.getEndTimeSec());
    }

    @Test
    public void testStartWorkout() {
        Workout workout = new Workout(routine);
        workout.startWorkout();
        assertTrue(workout.getStartTimeSec() > 0);
    }

    @Test
    public void testEndWorkout() {
        Workout workout = new Workout(routine);
        workout.startWorkout();
        workout.endWorkout();
        assertTrue(workout.getEndTimeSec() > 0);
    }
}

