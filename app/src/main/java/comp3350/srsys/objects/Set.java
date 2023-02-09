package comp3350.srsys.objects;
public class Set implements Setable {

    //instance variables
    private int expTime;
    private int expectedReps;
    private int actualReps;
    private String exName;

    //constructor
    public Set(String nameOfExercise,int expReps, int time){
        this.expTime=time;
        this.exName=nameOfExercise;
        this.expectedReps=expReps;
    }

    @Override
    public int getTime() {
        return expTime;
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
        return this.exName;
    }

    @Override
    public void setExercise(String name) {
        this.exName = name;
    }

    @Override
    public boolean equals(String exName) {
        boolean isEquals=false;

        if(exName.equals(exName))
            isEquals=true;

        return isEquals;
    }
}
