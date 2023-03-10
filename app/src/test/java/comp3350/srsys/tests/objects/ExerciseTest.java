package comp3350.srsys.tests.objects;



import org.junit.Test;
import static org.junit.Assert.*;

import comp3350.srsys.objects.Exercise;

public class ExerciseTest {

    @Test
    public void testConstructor1() {
        Exercise exercise = new Exercise("pushups", 10, 30);
        assertEquals("pushups", exercise.getName());
        assertEquals(10, exercise.getNumReps());
        assertEquals(30, exercise.getDurationSec());
    }
    @Test
    public void testConstructor2() {
        Exercise exercise = new Exercise("situps", 45);
        assertEquals("situps", exercise.getName());
        assertEquals(0, exercise.getNumReps());
        assertEquals(45, exercise.getDurationSec());
    }

    @Test
    public void testGetName() {
        Exercise exercise = new Exercise("pullups", 5, 20);
        assertEquals("pullups", exercise.getName());
    }

    @Test
    public void testGetDurationSec() {
        Exercise exercise = new Exercise("jumping jacks", 0, 60);
        assertEquals(60, exercise.getDurationSec());

        exercise = new Exercise("jumping jacks", 0, 0);
        assertEquals(0, exercise.getDurationSec());
    }

    // Test the getNumReps method
    @Test
    public void testGetNumReps() {
        Exercise exercise = new Exercise("lunges", 12, 0);
        assertEquals(12, exercise.getNumReps());

        exercise = new Exercise("lunges", 0, 0);
        assertEquals(0, exercise.getNumReps());
    }

    @Test
    public void testSetName() {
        Exercise exercise = new Exercise("planks", 0, 30);
        exercise.setName("crunches");
        assertEquals("crunches", exercise.getName());
    }

    @Test
    public void testSetDurationSec() {
        Exercise exercise = new Exercise("squats", 0, 45);
        exercise.setDurationSec(60);
        assertEquals(60, exercise.getDurationSec());
    }

    @Test
    public void testSetNumReps() {
        Exercise exercise = new Exercise("burpees", 0, 0);
        exercise.setNumReps(20);
        assertEquals(20, exercise.getNumReps());
    }
}

