package comp3350.srsys.tests.objects;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import comp3350.srsys.objects.Exercise;
import comp3350.srsys.objects.Routine;

public class RoutineTest {

    @Test
    public void testConstructor() {
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
    public void testAddExercise() {
        Routine routine = new Routine("Upper Body");
        Exercise exercise = new Exercise("push ups", 10, 120);
        assertTrue(routine.addExercise(exercise));
        assertEquals(1, routine.getExercises().size());
        assertTrue(routine.getExercises().contains(exercise));
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
