package comp3350.superset.application;

import comp3350.superset.persistence.RoutinePersistence;
import comp3350.superset.persistence.WorkoutPersistence;
import comp3350.superset.persistence.stubs.RoutinePersistenceStub;
import comp3350.superset.persistence.stubs.WorkoutPersistenceStub;

public class Services
{
    private static WorkoutPersistence workoutPersistence = null;
    private static RoutinePersistence routinePersistence = null;

    public static synchronized WorkoutPersistence getWorkoutPersistence() {
        if(workoutPersistence == null) {
            //workoutPersistence = new WorkoutPersistenceHSQLDB(Main.getDBPathName());
            workoutPersistence = new WorkoutPersistenceStub();
        }
        return workoutPersistence;
    }

    public static synchronized RoutinePersistence getRoutinePersistence() {
        if(routinePersistence == null) {
            //routinePersistence = new RoutinePersistenceHSQLDB(Main.getDBPathName());
            routinePersistence = new RoutinePersistenceStub();
        }
        return routinePersistence;
    }
}