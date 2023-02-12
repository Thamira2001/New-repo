package comp3350.srsys.business;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import comp3350.srsys.application.Services;
import comp3350.srsys.objects.Routine;
import comp3350.srsys.objects.Student;
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

    public List<String> getRoutineNames() {
        List<String> routineNames = new ArrayList<>();
        for(int i = 0; i < routineList.size(); i++) {
            routineNames.add(routineList.get(i).getName());
        }
        return routineNames;
    }

    public boolean insertRoutine(Routine currentRoutine) {
        return routinePersistence.insertRoutine(currentRoutine);
    }

    public boolean removeRoutine(Routine currentRoutine) {
        return routinePersistence.removeRoutine(currentRoutine);
    }
}
