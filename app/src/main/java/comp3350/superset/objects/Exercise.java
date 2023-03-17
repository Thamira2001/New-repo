// Purpose: defines an exercise with name, numReps, and duration

package comp3350.superset.objects;
public class Exercise {

    //instance variables
    private String name;
    private int durationSec;   // seconds
    private int numReps;

    public Exercise(String name, int numReps, int durationSec){
        this.name = name;
        this.durationSec = (durationSec >= 0) ? durationSec : 0;
        this.numReps = numReps;
    }
    public Exercise(String name, int durationSec) {
        this(name, 0, durationSec);
    }

    // getters
    public String getName() {
        return this.name;
    }
    public int getDurationSec() {return durationSec;}
    public int getNumReps() {
        return numReps;
    }

    // setters
    public void setName(String name) {
        this.name = name;
    }
    public void setDurationSec(int sec) {this.durationSec = (sec >= 0) ? sec : 0;}
    public void setNumReps(int reps) {
        this.numReps = (reps>=0) ? reps : 0;
    }

}
