package comp3350.superset.application;

import comp3350.superset.persistence.RoutinePersistence;
import comp3350.superset.persistence.WorkoutPersistence;
import comp3350.superset.persistence.hsqldb.RoutinePersistenceHSQLDB;
import comp3350.superset.persistence.hsqldb.WorkoutPersistenceHSQLDB;
import comp3350.superset.persistence.stubs.RoutinePersistenceStub;
import comp3350.superset.persistence.stubs.WorkoutPersistenceStub;

public class Services {
    private static WorkoutPersistence workoutPersistence = null;
    private static RoutinePersistence routinePersistence = null;

    public static synchronized WorkoutPersistence getWorkoutPersistence() {
        if(workoutPersistence == null) {
            workoutPersistence = new WorkoutPersistenceHSQLDB(Main.getDBPathName());
        }
        return workoutPersistence;
    }

    public static synchronized RoutinePersistence getRoutinePersistence() {
        System.out.println("PRINTING ROUTINE PERSISTENCE" + routinePersistence);
        if(routinePersistence == null) {
            routinePersistence = new RoutinePersistenceHSQLDB(Main.getDBPathName());
        }
        return routinePersistence;
    }
}