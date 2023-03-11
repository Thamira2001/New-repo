package comp3350.superset.business;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import comp3350.superset.application.Services;
import comp3350.superset.objects.Routine;
import comp3350.superset.persistence.RoutinePersistence;

public class AccessRoutines {

    private RoutinePersistence routinePersistence;
    private List<Routine> routineList;

    public AccessRoutines() {
        routinePersistence = Services.getRoutinePersistence();
        routineList = routinePersistence.getRoutineSequential();
    }
    public AccessRoutines(RoutinePersistence instance){
        routinePersistence = instance;
        routineList = routinePersistence.getRoutineSequential();
    }

    public List<Routine> getRoutines() {
        routineList = routinePersistence.getRoutineSequential();
        return Collections.unmodifiableList(routineList);
    }

    public List<String> getRoutineDisplayable() {
        List<String> displayable = new ArrayList<>();
        for(int i = 0; i < routineList.size(); i++) {
            Routine r = routineList.get(i);
            String content = r.getName();
            List<String> exDisplayable = r.getExercises().getNamesWithTime();
            for(int j = 0; j < exDisplayable.size(); j++) {
                content += "\n\t"+exDisplayable.get(j);
            }
            displayable.add(content);
        }
        return displayable;
    }

    public boolean insertRoutine(Routine currentRoutine) {
        return routinePersistence.insertRoutine(currentRoutine);
    }
}