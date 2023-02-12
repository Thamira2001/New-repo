package comp3350.srsys.tests.objects;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import comp3350.srsys.objects.Exercise;
import comp3350.srsys.objects.Routine;

public class RoutineTest {

    @Test
    public void testConstructorWithExerciseList() {
        List<Exercise> exerciseList = new ArrayList<>();
        Exercise exercise = new Exercise("push ups", 10, 120);
        exerciseList.add(exercise);
        Routine routine = new Routine("Upper Body", exerciseList);

        assertNotNull(routine);
        assertEquals("Upper Body", routine.getName());
        assertEquals(1, routine.getExercises().size());
        assertTrue(routine.getExercises().contains(exercise));
    }

    @Test
    public void testConstructorWithoutExerciseList() {
        Routine routine1 = new Routine("Cardio");
        Routine routine2 = new Routine("Resting");

        assertNotNull(routine1);
        assertNotNull(routine2);
        assertEquals("Cardio", routine1.getExercises());
        assertEquals("Resting", routine2.getExercises());
        assertEquals(0, routine1.getExercises().size());
        assertEquals(0, routine2.getExercises().size());
    }
    
    @Test
    public void testAddExercise() {
        Routine routine = new Routine("Upper Body");
        Exercise exercise1 = new Exercise("push ups", 10, 120);
        Exercise exercise2 = new Exercise("squat", 5, 60);
        assertTrue(routine.addExercise(exercise1));
        assertTrue(routine.addExercise(exercise2));
        assertEquals(2, routine.getExercises().size());
        assertTrue(routine.getExercises().contains(exercise1));
        assertTrue(routine.getExercises().contains(exercise2));
    }

    @Test
    public void testRemoveExercise() {
        List<Exercise> exerciseList = new ArrayList<>();
        Exercise exercise = new Exercise("push ups", 10, 120);
        exerciseList.add(exercise);
        Routine routine = new Routine("Upper Body", exerciseList);

        assertTrue(routine.removeExercise(exercise));
        assertEquals(0, routine.getExercises().size());
        assertFalse(routine.getExercises().contains(exercise));
    }
}
