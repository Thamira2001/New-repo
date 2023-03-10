package comp3350.srsys.objects;

import java.util.List;
import java.util.ArrayList;

public class ExerciseList {

    List<Exercise> exercises;

    public ExerciseList() {
        exercises = new ArrayList<>();
    }
    public ExerciseList(List<Exercise> es) {
        exercises = new ArrayList<>(es);
    }
    public int size() {return exercises.size();}
    public Exercise get(int i){return exercises.get(i);}
    public boolean add(Exercise e) {return exercises.add(e);}
    public boolean remove(Exercise e) {return exercises.remove(e);}
    public boolean isEmpty() {return exercises.isEmpty();}

    public List<String> getNames() {
        ArrayList<String> names = new ArrayList<>();
        for(int i = 0; i < exercises.size(); i++) {
            names.add(exercises.get(i).getName());
        }
        return names;
    }

    public List<String> getNamesWithTime() {
        ArrayList<String> res = new ArrayList<>();
        for(int i = 0; i < exercises.size(); i++) {
            Exercise e = exercises.get(i);
            res.add(e.getName() + "           " + e.getDurationSec() + " seconds");
        }
        return res;
    }
}
