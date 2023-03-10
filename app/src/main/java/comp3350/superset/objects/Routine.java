// Purpose: Contains list of exercises

package comp3350.superset.objects;

public class Routine {

    String name;
    ExerciseList exerciseList;

    public Routine(String name, ExerciseList exerciseList){
        this.name = name;
        this.exerciseList = exerciseList;
    }
    public Routine(String name){
        this(name, new ExerciseList());
    }

    public String getName() {return this.name;}
    public void setName(String name) {this.name = name;}

    public ExerciseList getExercises() {
        return exerciseList;
    }

    public void setExerciseList(ExerciseList exerciseList) {
        this.exerciseList = exerciseList;
    }

    public boolean addExercise(Exercise e) {
        return exerciseList.add(e);
    }

    public boolean removeExercise(Exercise e) {
        return exerciseList.remove(e);
    }

}
