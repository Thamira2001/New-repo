package comp3350.srsys.objects;

import java.util.ArrayList;
import java.util.List;

public class Workout implements Workoutable {
    //instance variables
    private List<Exercise> exercises;
    private int totalWorkoutTime;
    //constructor
    public Workout(){
        this.totalWorkoutTime =0;
        this.exercises =new ArrayList<>();
    }

    //TODO: new constructor for testing
    public Workout(List<Exercise> s){
        this.totalWorkoutTime = 0;
        this.exercises = s;
    }

    @Override
    public void addSet(Exercise exercise) {
        exercises.add(exercise);
    }

    private void calcTotalWorkoutTime() {
        for(int i = 0; i< exercises.size(); i++){
            totalWorkoutTime += exercises.get(i).getTime();
        }
    }

    @Override
    public int getTotalWorkoutTime() {
        calcTotalWorkoutTime();
        return totalWorkoutTime;
    }

    @Override
    public int getTotalSets() {
        return exercises.size();
    }
}
