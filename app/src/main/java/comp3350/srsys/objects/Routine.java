// Purpose: Contains list of exercises

package comp3350.srsys.objects;

import java.util.ArrayList;
import java.util.List;

public class Routine {

    String name;
    List<Exercise> exerciseList;

    public Routine(String name, List<Exercise> exerciseList){
        this.name = name;
        this.exerciseList = exerciseList;
    }
    public Routine(String name){
        this(name, new ArrayList<>());
    }

    public String getName() {return this.name;}

    public boolean addExercise(Exercise e) {
        return exerciseList.add(e);
    }

    public boolean removeExercise(Exercise e) {
        return exerciseList.remove(e);
    }

}
