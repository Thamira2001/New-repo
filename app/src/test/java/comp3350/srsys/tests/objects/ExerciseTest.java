package comp3350.srsys.tests.objects;

import org.junit.Test;
import static org.junit.Assert.*;

import comp3350.srsys.objects.Exercise;

public class ExerciseTest {

    @Test
    public void testConstructorWithNumReps() {
        Exercise exercise = new Exercise("Push-ups", 10, 60);
        assertEquals("Push-ups", exercise.getName());
        assertEquals(10, exercise.getNumReps());
        assertEquals(60, exercise.getDurationSec());
    }

    @Test
    public void testConstructorWithoutNumReps() {
        Exercise exercise = new Exercise("Running", 300);
        assertEquals("Running", exercise.getName());
        assertEquals(0, exercise.getNumReps());
        assertEquals(300, exercise.getDurationSec());
    }

    @Test
    public void testSettersAndGetters() {
        Exercise exercise = new Exercise("Push-ups", 10, 60);
        exercise.setName("Squats");
        exercise.setNumReps(20);
        exercise.setDurationSec(120);

        assertEquals("Squats", exercise.getName());
        assertEquals(20, exercise.getNumReps());
        assertEquals(120, exercise.getDurationSec());
    }

    @Test
    public void testEquals() {
        Exercise exercise1 = new Exercise("Push-ups", 10, 60);
        Exercise exercise2 = new Exercise("Push-ups", 20, 120);
        Exercise exercise3 = new Exercise("Squats", 20, 120);

        assertTrue(exercise1.equals("Push-ups"));
        assertTrue(exercise2.equals("Push-ups"));
        assertFalse(exercise3.equals("Push-ups"));
    }
}

