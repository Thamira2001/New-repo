package comp3350.srsys.objects;
public interface Workoutable {

    //Interface for Workout class
    //it is going to have a list(for now im making it an array of 40) of sets that make up the workout
    //have an expected finish time using the total of all set completion times
    //actual start and finish times can be used to calculate actual time taken for completion of workout
    // rest time = actual time - expected time
    //didnt implement the actual time part yet 


    //Constant:
    public static final int NUM_SETS = 40;

    //Methods

    //adds the set to the workout
    public void addSet(Set set);

    //calculates the total expected  workout time
    public void totExpWorkoutTime();

    //returns expected total workout time
    public int getTotExpWTime();

    //returns the number of sets in the workout
    public int getTotalSets();

}
