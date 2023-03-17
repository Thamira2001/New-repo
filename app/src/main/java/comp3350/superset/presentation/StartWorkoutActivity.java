package comp3350.superset.presentation;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import comp3350.superset.R;
import comp3350.superset.business.AccessRoutines;
import comp3350.superset.business.AccessWorkouts;
import comp3350.superset.objects.ExerciseList;
import comp3350.superset.objects.Routine;
import comp3350.superset.objects.Workout;


public class StartWorkoutActivity extends Activity implements OnItemSelectedListener
{
    private int sec = 0;
    private boolean isRunning;
    private boolean wasRunning;

    private AccessRoutines accessRoutines;
    private AccessWorkouts accessWorkouts;
    private List<Routine> routines;
    private Routine curRoutine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_workout);

        if (savedInstanceState != null) {
            sec = savedInstanceState.getInt("seconds");
            isRunning = savedInstanceState.getBoolean("running");
            wasRunning = savedInstanceState .getBoolean("wasRunning");
        }
        runningTimer();

        accessRoutines = new AccessRoutines();
        accessWorkouts = new AccessWorkouts();
        routines = accessRoutines.getRoutines();
        curRoutine = routines.get(0);
        List<String> routineNames = new ArrayList<>();
        for(int i = 0; i < routines.size(); i++) routineNames.add(routines.get(i).getName());

        // Setup routine spinner
        Spinner spinner = (Spinner) findViewById(R.id.exercisespinner);
        spinner.setOnItemSelectedListener(this);
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, routineNames);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);

        updateExerciseList();

    }
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        curRoutine = routines.get(position);
        updateExerciseList();
    }
    public void onNothingSelected(AdapterView<?> arg0) {
        curRoutine = routines.get(0);
    }

    public void updateExerciseList() {
        ExerciseList curExercises = curRoutine.getExercises();
        ListView listView = (ListView) findViewById(R.id.exerciseList);
        ArrayAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_activated_2, android.R.id.text1, curExercises.getNamesWithTime());
        listView.setAdapter(adapter);
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putInt("seconds", sec);
        savedInstanceState.putBoolean("running", isRunning);
        savedInstanceState.putBoolean("wasRunning", wasRunning);
    }

    @Override
    protected void onPause() {
        super.onPause();
        wasRunning = isRunning;
        isRunning = false;
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (wasRunning) {
            isRunning = true;
        }
    }

    public void onClickStart(View view) {
        isRunning = true;
    }
    public void onClickPause(View view) {
        isRunning = false;
    }
    private void runningTimer() {
        final TextView t_View = (TextView)findViewById(R.id.time_view);
        final Handler handle = new Handler();
        handle.post(new Runnable() {
            @Override
            public void run() {
                int hrs = sec / 3600;
                int mins = (sec % 3600) / 60;
                int secs = sec % 60;
                String time_t = String .format(Locale.getDefault(), "%02d:%02d:%02d", hrs,mins, secs);
                t_View.setText(time_t);
                if (isRunning) {
                    sec++;
                }
                handle.postDelayed(this, 1000);
            }
        });
    }

    public void onClickFinish(View view) {
        // create new workout instance
        Workout newW = new Workout(curRoutine, sec);
        accessWorkouts.insertWorkout(newW);

        // make toast prompt
        Toast.makeText(getApplicationContext(),"Workout Successfully Saved",Toast.LENGTH_SHORT).show();

        // exit page
        finish();
    }


}
