package comp3350.srsys.application;

import comp3350.srsys.persistence.RoutinePersistence;
import comp3350.srsys.persistence.WorkoutPersistence;
import comp3350.srsys.persistence.stubs.RoutinePersistenceStub;
import comp3350.srsys.persistence.stubs.WorkoutPersistenceStub;

public class Services
{
    private static WorkoutPersistence workoutPersistence = null;
    private static RoutinePersistence routinePersistence = null;


    public static synchronized WorkoutPersistence getWorkoutPersistence() {
        if(workoutPersistence == null) {
            workoutPersistence = new WorkoutPersistenceStub();
        }
        return workoutPersistence;
    }

    public static RoutinePersistence getRoutinePersistence() {
        if(routinePersistence == null) {
            routinePersistence = new RoutinePersistenceStub();
        }
        return routinePersistence;
    }
}
