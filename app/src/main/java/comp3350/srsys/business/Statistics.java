package comp3350.srsys.business;

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
            durationSec += (int)(w.getEndTimeSec() - w.getStartTimeSec());
        }
        return durationSec/workoutList.size()/60;
    }
}
