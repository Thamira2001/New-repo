package comp3350.superset.tests.business;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import comp3350.superset.business.AccessWorkouts;
import comp3350.superset.objects.Workout;
import comp3350.superset.persistence.WorkoutPersistence;
import comp3350.superset.persistence.stubs.WorkoutPersistenceStub;

public class AccessWorkoutsTest {

    private AccessWorkouts aw;
    private WorkoutPersistence p;
    @Before
    public void setup() {
        p = new WorkoutPersistenceStub();
        aw = new AccessWorkouts(p);
    }

    @Test
    public void testGetWorkouts() {
        List<Workout> workouts = aw.getWorkouts();
        assertNotNull(workouts);
        assertEquals(p.getWorkoutSequential(), workouts);
    }

    @Test
    public void testGetWorkoutsNotEmpty() {
        List<Workout> workouts = aw.getWorkouts();
        assertTrue(workouts.size() > 0);
        assertNotNull(workouts.get(0));
    }

    @Test
    public void testGetWorkoutsCorrectSize() {
        List<Workout> workouts = aw.getWorkouts();
        int expectedSize = 2;
        assertEquals(expectedSize, workouts.size());
    }
}
