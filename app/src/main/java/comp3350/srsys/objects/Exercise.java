package comp3350.srsys.objects;
public class Exercise implements ExerciseIntf {

    //instance variables
    private int expectedTime;   // seconds
    private int expectedReps;
    private int actualReps;
    private String name;

    //constructor
    public Exercise(String name, int expectedReps, int timeSeconds){
        this.name =name;
        this.expectedReps=expectedReps;
        this.expectedTime =timeSeconds;
    }

    @Override
    public int getTime() {
        return expectedTime;
    }

    @Override
    public int getExpReps() {
        return expectedReps;
    }

    @Override
    public void setExReps(int reps) {
        this.expectedReps=reps;
    }

    @Override
    public int getActReps() {
        return actualReps;
    }

    @Override
    public void setActReps(int actReps) {
        this.actualReps=actReps;
    }


    @Override
    public String getExercise() {
        return this.name;
    }

    @Override
    public void setExercise(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(String exerciseName) {
        boolean isEquals=false;

        if(name.equals(exerciseName))
            isEquals=true;

        return isEquals;
    }
}
