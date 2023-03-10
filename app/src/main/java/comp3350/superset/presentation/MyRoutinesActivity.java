package comp3350.superset.presentation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;


import java.util.List;

import comp3350.superset.R;
import comp3350.superset.business.AccessRoutines;

public class MyRoutinesActivity extends Activity {

    private AccessRoutines accessRoutines;
    private List<String> routineDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_routines);

        accessRoutines = new AccessRoutines();
        routineDisplay = accessRoutines.getRoutineDisplayable();

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
        routineDisplay = accessRoutines.getRoutineDisplayable();
        ListView listView = (ListView) findViewById(R.id.idRoutineList);
        ArrayAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_activated_2, android.R.id.text1, routineDisplay);
        listView.setAdapter(adapter);
    }




}
