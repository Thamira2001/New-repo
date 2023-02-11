package comp3350.srsys.presentation;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
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
import comp3350.srsys.business.AccessWorkouts;
import comp3350.srsys.objects.Exercise;
import comp3350.srsys.objects.Workout;

public class MyRoutinesActivity extends Activity {

    private AccessWorkouts accessWorkouts;
    private List<Workout> workoutList;
    private Workout newWorkout;
    private ArrayList<String> items;
    private Exercise exercises;
    private List<Exercise> exerciseList;
    private ArrayAdapter<Workout> workoutArrayAdapter;
    private ArrayAdapter<String> itemsAdapter;
    private ListView listWorkout;
    private Button addRoutine;
    private Button addToWorkout;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_routines);

        accessWorkouts = new AccessWorkouts();
        try
        {
            exerciseList = new ArrayList<>();
            workoutList = accessWorkouts.getWorkouts();
            //workoutArrayAdapter = new ArrayAdapter<Workout>(this, android.R.layout.simple_list_item_1, workoutList);
        }
        catch (final Exception e)
        {
            Messages.fatalError(this, e.getMessage());
        }
        listWorkout = findViewById(R.id.listWorkout);
        listWorkout.setAdapter(workoutArrayAdapter);

        addRoutine = findViewById(R.id.addingWorkout);

        addRoutine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addItem(view);
            }
        });

        items = new ArrayList<>();
        itemsAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, items);
        listWorkout.setAdapter(itemsAdapter);
        setUpListViewListener();

    }

    private void setUpListViewListener() {
        listWorkout.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Context context = getApplicationContext();
                Toast.makeText(context, "Activity Removed", Toast.LENGTH_LONG).show();

                items.remove(i);
                itemsAdapter.notifyDataSetChanged();
                workoutList.remove(i);
                workoutArrayAdapter.notifyDataSetChanged();
                return true;
            }
        });
    }

    private void addItem(View view) {
        EditText input = findViewById(R.id.editActivity);
        String exerciseName = input.getText().toString();

        if(!(exerciseName.equals(""))){
            itemsAdapter.add(exerciseName);
            exercises = new Exercise(exerciseName);
            exerciseList.add(exercises);
            newWorkout = new Workout(exerciseList);

            addToWorkout = findViewById(R.id.addtoworkout);

            addToWorkout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    addItem(view);
                    workoutList.add(newWorkout);
                }
            });
            //newExercise.addSet(exercises);
            //workoutList.add(exercises);
            //workoutArrayAdapter.add(object);
            input.setText("");
        }
        else {
            Toast.makeText(getApplicationContext(), "Please add the exercise...", Toast.LENGTH_LONG).show();
        }
    }
}
