package comp3350.superset.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import comp3350.superset.tests.business.AccessRoutinesTest;
import comp3350.superset.tests.business.AccessWorkoutsTest;
import comp3350.superset.tests.business.StatisticsTest;
import comp3350.superset.tests.objects.ExerciseListTest;
import comp3350.superset.tests.objects.ExerciseTest;
import comp3350.superset.tests.objects.RoutineTest;
import comp3350.superset.tests.objects.WorkoutTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        ExerciseTest.class,
        ExerciseListTest.class,
        RoutineTest.class,
        WorkoutTest.class,
        StatisticsTest.class,
        AccessWorkoutsTest.class,
        AccessRoutinesTest.class,
})
public class AllTests {}
