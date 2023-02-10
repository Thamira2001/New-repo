package comp3350.srsys.persistence.stubs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import comp3350.srsys.objects.Exercise;
import comp3350.srsys.objects.Workout;
import comp3350.srsys.persistence.WorkoutPersistence;

public class WorkoutPersistenceStub implements WorkoutPersistence {
    private List<Workout> workouts;

    public WorkoutPersistenceStub() {
        this.workouts = new ArrayList<>();
        fillWithSampleWorkouts();
    }
    private void fillWithSampleWorkouts(){
        Exercise e1 = new Exercise("pushup", 10, 50);
        Exercise e2 = new Exercise("situp", 15, 120);
        Exercise e3 = new Exercise("bench press", 5, 45);

        List<Exercise> plan1 = new ArrayList<>();
        plan1.add(e1);
        plan1.add(e2);

        List<Exercise> plan2 = new ArrayList<>();
        plan2.add(e3);

        workouts.add(new Workout(plan1));
        workouts.add(new Workout(plan2));
    }

    @Override
    public List<Workout> getWorkoutSequential() {
        return Collections.unmodifiableList(workouts);
    }

    @Override
    public boolean insertWorkout(Workout w) {
        return this.workouts.add(w);
    }

    @Override
    public boolean deleteWorkout(Workout w) {
        return this.workouts.remove(w);
    }

}
