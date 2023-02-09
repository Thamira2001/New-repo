package comp3350.srsys.objects;
public interface Setable extends Activity {
    //interface for set class
    //each set has a exercise variable(to know which type of exercise this sts falls under)
    //each set has number of expected reps
    //each set has a number actual reps


    //methods

    //returns the expected time for set to be completed in seconds
    public int getTime();

    //returns the expected reps of the exercise
    public int getExpReps();
    //sets the expected reps of the exercise
    public void setExReps(int reps);

    //returns the actual reps completed
    public int getActReps();
    //sets the actual reps completed
    public void setActReps(int actReps);


}
