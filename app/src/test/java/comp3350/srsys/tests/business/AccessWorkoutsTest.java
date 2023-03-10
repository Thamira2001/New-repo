package comp3350.srsys.tests.business;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import comp3350.srsys.business.AccessWorkouts;
import comp3350.srsys.objects.Workout;
import comp3350.srsys.persistence.WorkoutPersistence;
import comp3350.srsys.persistence.stubs.WorkoutPersistenceStub;

public class AccessWorkoutsTest {

    private AccessWorkouts awUsingStub;
    private WorkoutPersistence workoutStub;

    @Before
    public void setUp() {
        workoutStub = new WorkoutPersistenceStub();
        awUsingStub = new AccessWorkouts(workoutStub);
    }

    @Test
    public void testGetWorkouts() {
        List<Workout> workouts = awUsingStub.getWorkouts();
        assertNotNull(workouts);
        assertEquals(workoutStub.getWorkoutSequential(), awUsingStub.getWorkouts());
    }

    @Test
    public void testGetWorkoutsNotEmpty() {
        List<Workout> workouts = awUsingStub.getWorkouts();
        assertTrue(workouts.size() > 0);
        assertNotNull(workouts.get(0));
    }

    @Test
    public void testGetWorkoutsCorrectSize() {
        List<Workout> workouts = awUsingStub.getWorkouts();
        int expectedSize = 2;
        assertEquals(expectedSize, workouts.size());
    }
}
