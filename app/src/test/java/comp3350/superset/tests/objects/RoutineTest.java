package comp3350.superset.tests.objects;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

import comp3350.superset.objects.Exercise;
import comp3350.superset.objects.ExerciseList;
import comp3350.superset.objects.Routine;

public class RoutineTest {

    private Routine routine;

    @Before
    public void setUp() {
        routine = new Routine("Test Routine");
    }

    @Test
    public void testConstructorWithName() {
        String expectedName = "Test Routine";
        Routine newRoutine = new Routine(expectedName);

        assertEquals(expectedName, newRoutine.getName());
        // constructs with empty ExerciseList
        assertTrue(newRoutine.getExercises().isEmpty());
        assertNotNull(newRoutine.getExercises());
    }

    @Test
    public void testConstructorWithNameAndExerciseList() {
        String expectedName = "Test Routine";
        ExerciseList exerciseList = new ExerciseList();
        exerciseList.add(new Exercise("Exercise 1", 0));
        exerciseList.add(new Exercise("Exercise 2", 0));
        Routine newRoutine = new Routine(expectedName, exerciseList);


        assertEquals(expectedName, newRoutine.getName());
        // constructs with exerciseList
        assertFalse(newRoutine.getExercises().isEmpty());
        assertEquals(exerciseList, newRoutine.getExercises());
    }

    @Test
    public void testGetName() {
        assertEquals("Test Routine", routine.getName());
    }

    @Test
    public void testSetName() {
        routine.setName("new");
        assertEquals("new", routine.getName()); // expected
        routine.setName("");
        assertEquals("", routine.getName());    // edge: empty name
    }

    @Test
    public void testGetExercises() {
        // start with empty
        assertTrue(routine.getExercises().isEmpty());
        ExerciseList exerciseList = new ExerciseList();
        exerciseList.add(new Exercise("Exercise 1", 0));
        exerciseList.add(new Exercise("Exercise 2", 0));
        routine.setExerciseList(exerciseList);

        // ensure correct exerciseList returned
        assertFalse(routine.getExercises().isEmpty());
        assertEquals(exerciseList, routine.getExercises());
    }

    @Test
    public void testAddExercise() {
        // Start with empty
        assertTrue(routine.getExercises().isEmpty());
        Exercise exercise = new Exercise("Exercise 1", 0);

        // ensure addition successful
        assertTrue(routine.addExercise(exercise));
        assertFalse(routine.getExercises().isEmpty());
        assertTrue(routine.getExercises().size() == 1);
    }

    @Test
    public void testRemoveExercise() {

        // start with empty
        assertTrue(routine.getExercises().isEmpty());
        Exercise exercise = new Exercise("Exercise 1", 0);

        // edge: remove from empty list
        assertFalse(routine.removeExercise(exercise));
        assertTrue(routine.getExercises().isEmpty());

        // expected
        routine.addExercise(exercise);
        assertTrue(routine.removeExercise(exercise));
        assertTrue(routine.getExercises().isEmpty());
    }
}
