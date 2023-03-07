package comp3350.srsys.presentation;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;
import java.util.Locale;
import comp3350.srsys.R;


public class StartWorkoutActivity extends Activity
{
    private int sec = 0;
    private boolean isRunning;
    private boolean wasRunning;

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
