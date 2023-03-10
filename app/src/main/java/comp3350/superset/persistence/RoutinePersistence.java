package comp3350.superset.persistence;

import java.util.List;

import comp3350.superset.objects.Routine;

public interface RoutinePersistence {

    List<Routine> getRoutineSequential();

    boolean insertRoutine(Routine r);

    boolean removeRoutine(Routine r);
    
}
