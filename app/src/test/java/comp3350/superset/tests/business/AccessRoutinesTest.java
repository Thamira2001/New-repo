package comp3350.superset.tests.business;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import comp3350.superset.business.AccessRoutines;
import comp3350.superset.objects.Exercise;
import comp3350.superset.objects.ExerciseList;
import comp3350.superset.objects.Routine;
import comp3350.superset.persistence.RoutinePersistence;


public class AccessRoutinesTest {
    private AccessRoutines ar;
    private RoutinePersistence rp;

    @Before
    public void setUp() {
        rp = mock(RoutinePersistence.class);
        ar = new AccessRoutines(rp);
    }


    @Test
    public void AccessRoutinesTest() {
        final Routine routine;
        System.out.println("\nStarting test AccessRoutines");
        final List<Routine> routines = new ArrayList<>();
        routines.add(new Routine("Routine1"));
        when(rp.getRoutineSequential()).thenReturn(routines);

        routine = ar.getSequential();
        assertNotNull("first sequential routine should not be null", routine);
        assertTrue("Routine1".equals(routine.getName()));

        verify(rp).getRoutineSequential();

        System.out.println("Finished test AccessRoutine");
    }

    @Test
    public void testGetRoutineDisplayable() {
        List<Routine> rList = ar.getRoutines();

        List<String> expectedResult = new ArrayList<>();
        for(Routine r : rList) {
            String content = r.getName();
            List<String> exDisplayable = r.getExercises().getNamesWithTime();
            for(int i = 0; i < exDisplayable.size(); i++) {
                content +="\n\t"+exDisplayable.get(i);
            }
            expectedResult.add(content);
        }

        assertEquals(expectedResult, ar.getRoutineDisplayable());
    }

    @Test
    public void testInsertRoutine() {
        ExerciseList exercises = new ExerciseList();
        exercises.add(new Exercise("Exercise1", 60));
        Routine routine = new Routine("Routine1", exercises);
        ar.insertRoutine((routine));
        System.out.println("The result is " + ar.getRoutines());
        //assertTrue(ar.insertRoutine(routine));
        //assertTrue(ar.getRoutines().contains(routine));
    }
}

