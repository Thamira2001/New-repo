package comp3350.srsys.persistence.stubs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import comp3350.srsys.objects.Routine;
import comp3350.srsys.persistence.RoutinePersistence;

public class RoutinePersistenceStub implements RoutinePersistence {

    private List<Routine> routineList;

    public RoutinePersistenceStub() {
        this.routineList = new ArrayList<>();

        // stub values
        routineList.add(new Routine("Routine1"));
        routineList.add(new Routine("Routine2"));
        routineList.add(new Routine("Routine3"));
    }

    @Override
    public List<Routine> getRoutineSequential() {
        return Collections.unmodifiableList(routineList);
    }

    @Override
    public boolean insertRoutine(Routine r) {
        return routineList.add(r);
    }

    @Override
    public boolean removeRoutine(Routine r) {
        return routineList.remove(r);
    }
}
