package comp3350.superset.tests.business;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
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

        // expected
        workoutList.add(new Workout(r, 1800));
        workoutList.add(new Workout(r, 2400));
        workoutList.add(new Workout(r, 3600));
        workoutList.add(new Workout(r, 1200));
        workoutList.add(new Workout(r, 3000));
        int expectedAvgDuration = (1800 + 2400 + 3600 + 1200 + 3000) / 5 / 60;
        statistics = new Statistics(workoutList);
        assertEquals(expectedAvgDuration, statistics.averageWorkoutDurationMin());

        // edge: no workouts in list
        statistics = new Statistics(new ArrayList<>());
        assertEquals(0, statistics.averageWorkoutDurationMin());

        // edge: 1 workout in list
        statistics = new Statistics(Arrays.asList(new Workout(r, 60)));
        assertEquals(1, statistics.averageWorkoutDurationMin());

        // edge 1 work with no duration
        statistics = new Statistics(Arrays.asList(new Workout(r, 0)));
        assertEquals(0, statistics.averageWorkoutDurationMin());
    }

    @Test
    public void testWorkoutMinutesByMonth() {

        // expected
        workoutList.add(new Workout(r, 1, 1800));
        workoutList.add(new Workout(r, 1, 2400));
        workoutList.add(new Workout(r, 3, 3600));
        workoutList.add(new Workout(r, 4, 1200));
        workoutList.add(new Workout(r, 5, 3000));
        statistics = new Statistics(workoutList);
        int[] expectedMonthData = {4200/60, 0, 3600/60, 1200/60, 3000/60, 0, 0, 0, 0, 0, 0, 0};
        int[] ans = statistics.workoutMinutesByMonth();
        assertArrayEquals(expectedMonthData, statistics.workoutMinutesByMonth());

        // edge: no workouts in list
        statistics = new Statistics(new ArrayList<>());
        int[] exp = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        assertArrayEquals(exp, statistics.workoutMinutesByMonth());

        // edge 1 work with no duration
        statistics = new Statistics(Arrays.asList(new Workout(r, 0)));
        int[] expt = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        assertArrayEquals(expt, statistics.workoutMinutesByMonth());
    }
}
