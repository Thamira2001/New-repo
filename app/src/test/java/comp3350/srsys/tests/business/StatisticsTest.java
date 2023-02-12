package comp3350.srsys.tests.business;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import comp3350.srsys.business.AccessWorkouts;
import comp3350.srsys.business.Statistics;
import comp3350.srsys.objects.Routine;
import comp3350.srsys.objects.Workout;

public class StatisticsTest {

    @Test
    public void testAverageWorkoutDurationMin() {
        AccessWorkouts accessWorkouts = new AccessWorkouts() {
            //@Override
            public List<Workout> getWorkouts() {
                List<Workout> workouts = new ArrayList<>();
                Routine routine = new Routine("Routine 1");
                workouts.add(new Workout(routine, 0, 120));
                workouts.add(new Workout(routine, 0, 300));
                workouts.add(new Workout(routine, 0, 240));
                return workouts;
            }
        };
        Statistics statistics = new Statistics();
        assertEquals(120, statistics.averageWorkoutDurationMin());
    }
}

