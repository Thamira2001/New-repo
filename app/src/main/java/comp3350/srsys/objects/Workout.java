package comp3350.srsys.objects;
import java.util.Arrays;

public class Workout implements Workoutable {
    //instance variables
    private Set [] workout;
    private int workoutIndex;//used to index the array
    private int totalExpWTime;
    //constructor
    public Workout(){
        this.totalExpWTime=0;
        this.workoutIndex=0;
        this.workout=new Set[NUM_SETS];//creates an empty workout with 40 spots for sets
    }

    @Override
    public void addSet(Set set) {
        this.workout[workoutIndex]=set;
        this.workoutIndex++;
    }

    @Override
    public void totExpWorkoutTime() {
        for(int i=0; i<workoutIndex;i++){
            totalExpWTime+=workout[i].getTime();
        }
    }

    @Override
    public int getTotExpWTime() {
        return totalExpWTime;
    }

    @Override
    public int getTotalSets() {
        return workoutIndex;
    }
}
