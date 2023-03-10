package comp3350.superset.persistence.stubs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import comp3350.superset.objects.Exercise;
import comp3350.superset.objects.ExerciseList;
import comp3350.superset.objects.Routine;
import comp3350.superset.objects.Workout;
import comp3350.superset.persistence.WorkoutPersistence;

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

        ExerciseList eList = new ExerciseList();
        eList.add(e1);
        eList.add(e2);
        Routine r1 = new Routine("r1", eList);

        ExerciseList eList2 = new ExerciseList();
        eList2.add(e3);
        Routine r2 = new Routine("r2", eList2);

        workouts.add(new Workout(r1, 60*30));
        workouts.add(new Workout(r2, 60*10));
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
