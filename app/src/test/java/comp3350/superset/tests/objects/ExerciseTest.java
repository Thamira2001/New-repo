package comp3350.superset.tests.objects;



import org.junit.Test;
import static org.junit.Assert.*;

import comp3350.superset.objects.Exercise;

public class ExerciseTest {

    @Test
    public void testConstructor1() {
        Exercise exercise = new Exercise("pushups", 10, 30);
        assertEquals("pushups", exercise.getName());
        assertEquals(10, exercise.getNumReps());
        assertEquals(30, exercise.getDurationSec());
    }
    @Test
    public void testConstructorNegativeDuration() {
        Exercise exercise = new Exercise("situps", -45);
        assertEquals("situps", exercise.getName());
        assertEquals(0, exercise.getNumReps());
        assertEquals(0, exercise.getDurationSec());
    }

    @Test
    public void testGetName() {
        Exercise e1 = new Exercise("pullups", 5, 20);
        Exercise e2 = new Exercise("", 5, 20);

        assertEquals("pullups", e1.getName());    // expected
        assertEquals("", e2.getName());  // edge: empty name
    }

    @Test
    public void testGetDurationSec() {
        Exercise e1 = new Exercise("jumping jacks", 0, 60);
        Exercise e2 = new Exercise("jumping jacks", 0, 0);

        assertEquals(60, e1.getDurationSec());  // expected
        assertEquals(0, e2.getDurationSec());   // edge: no duration
    }

    // Test the getNumReps method
    @Test
    public void testGetNumReps() {
        Exercise e1 = new Exercise("lunges", 12, 0);
        Exercise e2 = new Exercise("lunges", 0, 0);

        assertEquals(12, e1.getNumReps());  // expected
        assertEquals(0, e2.getNumReps());   // edge: 0 value
    }

    @Test
    public void testSetName() {
        Exercise exercise = new Exercise("planks", 0, 30);
        exercise.setName("crunches");
        assertEquals("crunches", exercise.getName());   // expected
        exercise.setName("");
        assertEquals("", exercise.getName());   // edge: empty name
    }

    @Test
    public void testSetDurationSec() {
        Exercise e = new Exercise("squats", 0, 45);

        // expected
        e.setDurationSec(60);
        assertEquals(60, e.getDurationSec());

        // edge: 0 value
        e.setDurationSec(0);
        assertEquals(0, e.getDurationSec());

        // edge: negative value
        e.setDurationSec(-60);
        assertEquals(0, e.getDurationSec());

    }

    @Test
    public void testSetNumReps() {
        Exercise e = new Exercise("burpees", 0, 0);
        e.setNumReps(20);
        assertEquals(20, e.getNumReps());

        // edge: 0 value
        e.setNumReps(0);
        assertEquals(0, e.getNumReps());

        // edge: neg value
        e.setNumReps(-10);
        assertEquals(0, e.getNumReps());
    }
}

