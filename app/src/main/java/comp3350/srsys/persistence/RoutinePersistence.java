package comp3350.srsys.persistence;

import java.util.List;

import comp3350.srsys.objects.Routine;

public interface RoutinePersistence {

    List<Routine> getRoutineSequential();

    boolean insertRoutine(Routine r);

    boolean removeRoutine(Routine r);
    
}
