package comp3350.srsys.business;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import comp3350.srsys.application.Services;
import comp3350.srsys.objects.Exercise;
import comp3350.srsys.objects.Routine;
import comp3350.srsys.persistence.RoutinePersistence;

public class AccessRoutines {

    private RoutinePersistence routinePersistence;
    private List<Routine> routineList;
    private Routine routine;
    private int currentRoutine;

    public AccessRoutines()
    {
        routinePersistence = Services.getRoutinePersistence();
        routineList = routinePersistence.getRoutineSequential();
        routine = null;
        currentRoutine = 0;
    }

    public List<Routine> getRoutines()
    {
        routineList = routinePersistence.getRoutineSequential();
        return Collections.unmodifiableList(routineList);
    }

    public Routine getSequential()
    {
        if (routineList == null)
        {
            routineList = routinePersistence.getRoutineSequential();
            currentRoutine = 0;
        }
        if (currentRoutine < routineList.size())
        {
            routine = routineList.get(currentRoutine);
            currentRoutine++;
        }
        else
        {
            routineList = null;
            routine = null;
            currentRoutine = 0;
        }
        return routine;
    }

    public List<String> getRoutineDisplayable() {
        List<String> displayable = new ArrayList<>();
        for(int i = 0; i < routineList.size(); i++) {
            Routine r = routineList.get(i);
            String content = r.getName();
            List<Exercise> exercises = r.getExercises();
            for(int j = 0; j < exercises.size(); j++) {
                Exercise e = exercises.get(j);
                content += "\n\t"+e.getName()+"   "+e.getDurationSec()+"sec";
            }
            displayable.add(content);
        }
        return displayable;
    }

    public boolean insertRoutine(Routine currentRoutine) {
        return routinePersistence.insertRoutine(currentRoutine);
    }

    public boolean removeRoutine(Routine currentRoutine) {
        return routinePersistence.removeRoutine(currentRoutine);
    }
}
