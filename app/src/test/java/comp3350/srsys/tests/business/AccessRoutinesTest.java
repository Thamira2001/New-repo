package comp3350.srsys.tests.business;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import comp3350.srsys.application.Services;
import comp3350.srsys.business.AccessRoutines;
import comp3350.srsys.objects.Exercise;
import comp3350.srsys.objects.Routine;
import comp3350.srsys.persistence.RoutinePersistence;

public class AccessRoutinesTest {
    private AccessRoutines accessRoutines;
    private RoutinePersistence mockRoutinePersistence;
    private List<Routine> testRoutineList;

    @BeforeEach
    public void setUp() {
        mockRoutinePersistence = Mockito.mock(RoutinePersistence.class);
        testRoutineList = new ArrayList<>();
        accessRoutines = new AccessRoutines();
    }

    @Test
    public void testGetRoutineDisplayable() {
        List<Exercise> exercises1 = new ArrayList<>();
        exercises1.add(new Exercise("Exercise1", 60));
        exercises1.add(new Exercise("Exercise2", 120));
        Routine routine1 = new Routine("Routine1", exercises1);
        testRoutineList.add(routine1);

        List<Exercise> exercises2 = new ArrayList<>();
        exercises2.add(new Exercise("Exercise3", 180));
        Routine routine2 = new Routine("Routine2", exercises2);
        testRoutineList.add(routine2);

        Mockito.when(mockRoutinePersistence.getRoutineSequential()).thenReturn(testRoutineList);

        List<String> expectedResult = new ArrayList<>();
        expectedResult.add("Routine1\n\tExercise1   60sec\n\tExercise2   120sec");
        expectedResult.add("Routine2\n\tExercise3   180sec");

        assertEquals(expectedResult, accessRoutines.getRoutineDisplayable());
    }

    @Test
    public void testInsertRoutine() {
        List<Exercise> exercises = new ArrayList<>();
        exercises.add(new Exercise("Exercise1", 60));
        Routine routine = new Routine("Routine1", exercises);

        Mockito.when(mockRoutinePersistence.insertRoutine(routine)).thenReturn(true);

        assertTrue(accessRoutines.insertRoutine(routine));
    }
}

