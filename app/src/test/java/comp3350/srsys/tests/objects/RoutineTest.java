package comp3350.srsys.tests.objects;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

import comp3350.srsys.objects.Exercise;
import comp3350.srsys.objects.ExerciseList;
import comp3350.srsys.objects.Routine;

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
        assertTrue(newRoutine.getExercises().isEmpty());
    }

    @Test
    public void testConstructorWithNameAndExerciseList() {
        String expectedName = "Test Routine";
        ExerciseList exerciseList = new ExerciseList();
        exerciseList.add(new Exercise("Exercise 1", 0));
        exerciseList.add(new Exercise("Exercise 2", 0));
        Routine newRoutine = new Routine(expectedName, exerciseList);
        assertEquals(expectedName, newRoutine.getName());
        assertFalse(newRoutine.getExercises().isEmpty());
        assertEquals(exerciseList, newRoutine.getExercises());
    }

    @Test
    public void testGetName() {
        assertEquals("Test Routine", routine.getName());
    }

    @Test
    public void testSetName() {
        String expectedName = "New Routine Name";
        routine.setName(expectedName);
        assertEquals(expectedName, routine.getName());
    }

    @Test
    public void testGetExercises() {
        assertTrue(routine.getExercises().isEmpty());
        ExerciseList exerciseList = new ExerciseList();
        exerciseList.add(new Exercise("Exercise 1", 0));
        exerciseList.add(new Exercise("Exercise 2", 0));
        routine.setExerciseList(exerciseList);
        assertFalse(routine.getExercises().isEmpty());
        assertEquals(exerciseList, routine.getExercises());
    }

    @Test
    public void testAddExercise() {
        assertTrue(routine.getExercises().isEmpty());
        Exercise exercise = new Exercise("Exercise 1", 0);
        assertTrue(routine.addExercise(exercise));
        assertFalse(routine.getExercises().isEmpty());
        assertTrue(routine.getExercises().size() == 1);
    }

    @Test
    public void testRemoveExercise() {
        assertTrue(routine.getExercises().isEmpty());
        Exercise exercise = new Exercise("Exercise 1", 0);
        assertFalse(routine.removeExercise(exercise));
        assertTrue(routine.getExercises().isEmpty());
        routine.addExercise(exercise);
        assertTrue(routine.removeExercise(exercise));
        assertTrue(routine.getExercises().isEmpty());
    }
}
