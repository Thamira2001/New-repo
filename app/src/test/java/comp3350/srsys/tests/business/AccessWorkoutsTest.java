package comp3350.srsys.tests.business;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import comp3350.srsys.business.AccessWorkouts;
import comp3350.srsys.objects.Workout;

public class AccessWorkoutsTest {

    private AccessWorkouts accessWorkouts;

    @Before
    public void setUp() {
        accessWorkouts = new AccessWorkouts();
    }

    @Test
    public void testGetWorkouts() {
        List<Workout> workouts = accessWorkouts.getWorkouts();
        assertTrue(workouts != null);
    }

    @Test
    public void testGetWorkoutsNotEmpty() {
        List<Workout> workouts = accessWorkouts.getWorkouts();
        assertTrue(workouts.size() > 0);
    }

    @Test
    public void testGetWorkoutsContainsWorkout() {
        List<Workout> workouts = accessWorkouts.getWorkouts();
        Workout workout = workouts.get(0);
        assertTrue(workout != null);
    }

    @Test
    public void testGetWorkoutsCorrectSize() {
        List<Workout> workouts = accessWorkouts.getWorkouts();
        int expectedSize = 3;
        assertEquals(expectedSize, workouts.size());
    }
}
