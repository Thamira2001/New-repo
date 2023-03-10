package comp3350.superset.business;

import java.time.Month;
import java.util.List;

import comp3350.superset.objects.Workout;

public class Statistics {

    AccessWorkouts accessWorkouts;
    List<Workout> workoutList;

    public Statistics() {
        accessWorkouts = new AccessWorkouts();
        workoutList = accessWorkouts.getWorkouts();
    }

    public Statistics(List<Workout> workoutList) {
        this.workoutList = workoutList;
    }

    // calculate average workout duration
    public int averageWorkoutDurationMin() {
        int durationSec = 0;
        for(int i = 0; i < workoutList.size(); i++) {
            Workout w = workoutList.get(i);
            durationSec += w.getDurationSec();
        }
        return workoutList.size() == 0 ? 0 : durationSec/workoutList.size()/60;
    }

    public int[] workoutMinutesByMonth() {
        int[] monthData = new int[12];
        for(int i = 0; i < workoutList.size(); i++) {
            Workout w = workoutList.get(i);
            int month = w.getMonth();
            int durationMinutes = w.getDurationSec()/60;
            monthData[month-1] += durationMinutes;
        }
        return monthData;
    }
}
