package comp3350.superset.persistence.stubs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import comp3350.superset.objects.Exercise;
import comp3350.superset.objects.ExerciseList;
import comp3350.superset.objects.Routine;
import comp3350.superset.persistence.RoutinePersistence;

public class RoutinePersistenceStub implements RoutinePersistence {

    private List<Routine> routineList;

    public RoutinePersistenceStub() {
        this.routineList = new ArrayList<>();

        ExerciseList el1 = new ExerciseList();
        ExerciseList el2 = new ExerciseList();
        Exercise e1 = new Exercise("e1", 5);
        Exercise e2 = new Exercise("e2", 10);
        el1.add(e1);
        el1.add(e2);
        el2.add(e2);

        // stub values
        routineList.add(new Routine("Routine1", el1));
        routineList.add(new Routine("Routine2", el2));
        routineList.add(new Routine("Routine3", el1));
    }

    @Override
    public List<Routine> getRoutineSequential() {
        return Collections.unmodifiableList(routineList);
    }

    @Override
    public boolean insertRoutine(Routine r) {
        return routineList.add(r);
    }
}
