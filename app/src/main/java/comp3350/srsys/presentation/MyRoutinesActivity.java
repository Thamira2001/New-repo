package comp3350.srsys.presentation;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Button;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import comp3350.srsys.R;
import comp3350.srsys.business.AccessRoutines;
import comp3350.srsys.business.AccessWorkouts;
import comp3350.srsys.objects.Exercise;
import comp3350.srsys.objects.Routine;
import comp3350.srsys.objects.Workout;

public class MyRoutinesActivity extends Activity {

    private AccessRoutines accessRoutines;
    private List<String> routineNames;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_routines);

        accessRoutines = new AccessRoutines();
        routineNames = accessRoutines.getRoutineNames();

        showCurrentRoutineList();
    }

    protected void onStart() {
        super.onStart();
        showCurrentRoutineList();
    }

    public void buttonGoToAddRoutineOnClick(View v) {
        Intent addRoutineIntent = new Intent(MyRoutinesActivity.this, AddRoutineActivity.class);
        MyRoutinesActivity.this.startActivity(addRoutineIntent);
    }

    private void showCurrentRoutineList() {
        accessRoutines = new AccessRoutines();
        routineNames = accessRoutines.getRoutineNames();
        ListView listView = (ListView) findViewById(R.id.idRoutineList);
        ArrayAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_activated_2, android.R.id.text1, routineNames);
        listView.setAdapter(adapter);
    }




}
