package comp3350.superset.tests.business;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import comp3350.superset.business.AccessRoutines;
import comp3350.superset.objects.Exercise;
import comp3350.superset.objects.ExerciseList;
import comp3350.superset.objects.Routine;
import comp3350.superset.persistence.stubs.RoutinePersistenceStub;

public class AccessRoutinesTest {
    private AccessRoutines ar;

    @Before
    public void setUp() {
        ar = new AccessRoutines(new RoutinePersistenceStub());
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

        assertTrue(ar.insertRoutine(routine));
        assertTrue(ar.getRoutines().contains(routine));
    }
}

