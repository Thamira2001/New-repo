package comp3350.superset.presentation;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import comp3350.superset.R;
import comp3350.superset.business.AccessRoutines;
import comp3350.superset.objects.Exercise;
import comp3350.superset.objects.ExerciseList;
import comp3350.superset.objects.Routine;

public class AddRoutineActivity extends Activity {

    private ExerciseList exercises;
    private AccessRoutines accessRoutines;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_routine);

        accessRoutines = new AccessRoutines();
        exercises = new ExerciseList();

        // display exercise list
        ListView listView = (ListView) findViewById(R.id.exerciseList);
        ArrayAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_activated_2, android.R.id.text1, exercises.getNames());
        listView.setAdapter(adapter);
    }

    public void buttonCreateRoutineOnClick(View view) {
        // add routine
        EditText textName = (EditText) findViewById(R.id.inputRoutineName);
        String name = textName.getText().toString();
        Routine toAdd = new Routine(name, exercises);
        accessRoutines.insertRoutine(toAdd);

        // go to MyRoutines page
        finish();
    }

    public void buttonAddExerciseOnClick(View view) {
        EditText textName = (EditText) findViewById(R.id.exerciseName);
        String name = textName.getText().toString();

        EditText textDur = (EditText)findViewById(R.id.exerciseDuration);
        int duration;
        try{
            duration = Integer.parseInt(textDur.getText().toString());
        } catch (Exception e){
            duration = 0;
        }

        Exercise toAdd = new Exercise(name, duration);
        exercises.add(toAdd);
    }
}