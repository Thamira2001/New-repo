package comp3350.srsys.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import comp3350.srsys.tests.business.AccessRoutinesTest;
import comp3350.srsys.tests.business.AccessWorkoutsTest;
import comp3350.srsys.tests.business.StatisticsTest;
import comp3350.srsys.tests.objects.ExerciseTest;
import comp3350.srsys.tests.objects.RoutineTest;
import comp3350.srsys.tests.objects.WorkoutTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        ExerciseTest.class,
        RoutineTest.class,
        WorkoutTest.class,
        StatisticsTest.class,
        AccessWorkoutsTest.class,
        AccessRoutinesTest.class,
})
public class AllTests {}
