package comp3350.superset.tests.business;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import comp3350.superset.business.Statistics;
import comp3350.superset.objects.Routine;
import comp3350.superset.objects.Workout;

public class StatisticsTest {

    private Statistics statistics;
    private List<Workout> workoutList;
    private Routine r;

    @Before
    public void setUp() {
        workoutList = new ArrayList<Workout>();
        r = new Routine("testRoutine");
    }

    @Test
    public void testAverageWorkoutDurationMin() {
        workoutList.add(new Workout(r, 1800));
        workoutList.add(new Workout(r, 2400));
        workoutList.add(new Workout(r, 3600));
        workoutList.add(new Workout(r, 1200));
        workoutList.add(new Workout(r, 3000));
        int expectedAvgDuration = (1800 + 2400 + 3600 + 1200 + 3000) / 5 / 60;
        statistics = new Statistics(workoutList);
        assertEquals(expectedAvgDuration, statistics.averageWorkoutDurationMin());
    }

    @Test
    public void testWorkoutMinutesByMonth() {
        workoutList.add(new Workout(r, Month.JANUARY, 1800));
        workoutList.add(new Workout(r, Month.JANUARY, 2400));
        workoutList.add(new Workout(r, Month.MARCH, 3600));
        workoutList.add(new Workout(r, Month.APRIL, 1200));
        workoutList.add(new Workout(r, Month.MAY, 3000));
        statistics = new Statistics(workoutList);
        int[] expectedMonthData = {4200/60, 0, 3600/60, 1200/60, 3000/60, 0, 0, 0, 0, 0, 0, 0};
        int[] ans = statistics.workoutMinutesByMonth();
        assertArrayEquals(expectedMonthData, statistics.workoutMinutesByMonth());
    }
}
