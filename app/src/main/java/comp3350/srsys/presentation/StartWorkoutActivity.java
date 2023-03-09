package comp3350.srsys.presentation;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;
import java.util.Locale;
import comp3350.srsys.R;
import comp3350.srsys.business.AccessRoutines;
import comp3350.srsys.objects.Exercise;
import comp3350.srsys.objects.ExerciseList;
import comp3350.srsys.objects.Routine;


public class StartWorkoutActivity extends Activity
{
    private int sec = 0;
    private boolean isRunning;
    private boolean wasRunning;

    private AccessRoutines accessRoutines;
    List<Routine> routines;
    Routine curRoutine;

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
        routines = accessRoutines.getRoutines();

        // display dropdown to select routine
        curRoutine = routines.get(0);

        // display exercise list of corresponding routine
        ExerciseList curExercises = curRoutine.getExercises();
        ListView listView = (ListView) findViewById(R.id.exerciseList);
        ArrayAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_activated_2, android.R.id.text1, curExercises.getNames());
        listView.setAdapter(adapter);
    }
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putInt("seconds", sec);
        savedInstanceState.putBoolean("running", isRunning);
        savedInstanceState.putBoolean("wasRunning", wasRunning);
    }

    @Override
    protected void onPause()
    {
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
    public void onClickStop(View view) {
        isRunning = false;
    }
    public void onClickReset(View view) {
        isRunning = false;
        sec = 0;
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
}
