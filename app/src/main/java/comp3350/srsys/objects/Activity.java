package comp3350.srsys.objects;
public interface Activity {

    //provides interface for an exercise

    //methods
    public String getExercise();//returns the name 0f the exercise
    public void setExercise(String name);//sets the name of exercise

    public boolean equals(String exName);
    public String toString();

}
