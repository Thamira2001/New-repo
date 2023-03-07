package comp3350.srsys.business;

import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import comp3350.srsys.objects.Workout;

public class Statistics {

    AccessWorkouts accessWorkouts;
    List<Workout> workoutList;

    public Statistics() {
        accessWorkouts = new AccessWorkouts();
        workoutList = accessWorkouts.getWorkouts();
    }

    // calculate average workout duration
    public int averageWorkoutDurationMin() {
        int durationSec = 0;
        for(int i = 0; i < workoutList.size(); i++) {
            Workout w = workoutList.get(i);
            durationSec += w.getDurationSec();
        }
        return durationSec/workoutList.size()/60;
    }

    public int[] workoutMinutesByMonth() {
        int[] monthData = new int[12];
        for(int i = 0; i < workoutList.size(); i++) {
            Workout w = workoutList.get(i);
            Month m = w.getMonth();
            int durationMinutes = w.getDurationSec()/60;
            monthData[m.getValue()] += durationMinutes;
        }
        return monthData;
    }
}
