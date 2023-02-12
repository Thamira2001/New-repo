package comp3350.srsys.presentation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;

import comp3350.srsys.R;
import comp3350.srsys.business.AccessRoutines;
import comp3350.srsys.objects.Exercise;
import comp3350.srsys.objects.Routine;

public class AddRoutineActivity extends Activity {

    private List<Exercise> exercises;
    private List<String> exerciseNames;
    private AccessRoutines accessRoutines;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_routine);

        accessRoutines = new AccessRoutines();
        exercises = new ArrayList<>();
        exerciseNames = new ArrayList<>();

        // display exercise list
        // routine name list
        ListView listView = (ListView) findViewById(R.id.exerciseList);
        ArrayAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_activated_2, android.R.id.text1, exerciseNames);
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
        addExercise(toAdd);
    }

    private void addExercise(Exercise e) {
        exercises.add(e);
        exerciseNames.add(e.getName());
    }
}