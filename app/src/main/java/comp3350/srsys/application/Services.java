package comp3350.srsys.application;

import comp3350.srsys.persistence.RoutinePersistence;
import comp3350.srsys.persistence.WorkoutPersistence;
import comp3350.srsys.persistence.stubs.RoutinePersistenceStub;
import comp3350.srsys.persistence.stubs.WorkoutPersistenceStub;

import comp3350.srsys.persistence.hsqldb.RoutinePersistenceHSQLDB;
import comp3350.srsys.persistence.hsqldb.WorkoutPersistenceHSQLDB;

public class Services
{
    private static WorkoutPersistence workoutPersistence = null;
    private static RoutinePersistence routinePersistence = null;

    public static synchronized WorkoutPersistence getWorkoutPersistence() {
        if(workoutPersistence == null) {
            workoutPersistence = new WorkoutPersistenceHSQLDB(Main.getDBPathName());
        }
        return workoutPersistence;
    }

    public static synchronized RoutinePersistence getRoutinePersistence() {
        if(routinePersistence == null) {
            routinePersistence = new RoutinePersistenceHSQLDB(Main.getDBPathName());
        }
        return routinePersistence;
    }
}