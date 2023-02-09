package comp3350.srsys.objects;
public class Exercise implements Activity {

    private String exName;

    public Exercise(String exercise){
        this.exName=exercise;
    }
    @Override
    public String getExercise() {
        return exName;
    }

    @Override
    public void setExercise(String name) {
        this.exName=name;
    }

    //should have an equals function to check if nae of exercise can be used to match another exercise
    @Override
    public  boolean equals(String exName){
        if(getExercise().equals(exName))
            return true;

        return false;
    }


    @Override
    public String toString() {
        return "Exercise  is " +
                "exName='" + exName + '\'' +
                '}';
    }
}
