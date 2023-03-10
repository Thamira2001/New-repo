package comp3350.superset.persistence.hsqldb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import comp3350.superset.objects.ExerciseList;
import comp3350.superset.objects.Routine;
import comp3350.superset.objects.Workout;
import comp3350.superset.objects.Exercise;
import comp3350.superset.persistence.WorkoutPersistence;


public class WorkoutPersistenceHSQLDB implements WorkoutPersistence {

    private final String dbPath;

    public WorkoutPersistenceHSQLDB(final String dbPath) {
        this.dbPath = dbPath;
    }

    private Connection connection() throws SQLException {
        return DriverManager.getConnection("jdbc:hsqldb:file:" + dbPath + ";shutdown=true", "SA", "");
    }

    private Workout fromResultSet(final ResultSet rs) throws SQLException {
        final Routine routine = RoutinePersistenceHSQLDB.getRoutinefromResultSet(rs);
        final int month = rs.getInt("MONTH");
        final int duration = rs.getInt("DURATION");
        return new Workout(routine, month, duration);
    }

    @Override
    public List<Workout> getWorkoutSequential() {
        final List<Workout> workouts = new ArrayList<>();

        try(final Connection c = connection()) {
            final Statement st = c.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            final ResultSet rs = st.executeQuery("SELECT * FROM workout JOIN routine on workout.id_r = routine.id_r JOIN exercise on routine.id_r = exercise.id_r");
            while(rs.next())
            {
                final Workout workout = fromResultSet(rs);
                workouts.add(workout);
            }
            rs.close();
            st.close();

            return workouts;
        }
        catch(final SQLException e)
        {
            throw new PersistenceException(e);
        }
    }

    @Override
    public boolean insertWorkout(final Workout currentWorkout) {
        if(currentWorkout == null) {
            return false;
        }
        try (final Connection c = connection()) {
            final PreparedStatement st = c.prepareStatement("INSERT INTO workout VALUES(?, ?, ?, ?)");
            int idW = nextWorkoutID();
            st.setInt(1, idW);
            st.setInt(2, currentWorkout.getMonth());
            st.setInt(3, currentWorkout.getDurationSec());
            st.setInt(4, getRoutineID(currentWorkout.getRoutine()));
            st.executeUpdate();
            return true;
        } catch (final SQLException e) {
            throw new PersistenceException(e);
        }
    }

    private int nextWorkoutID() {
        try(final Connection c = connection()) {
            final Statement st = c.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            final ResultSet rs = st.executeQuery("SELECT MAX(ID_W) as maxID FROM workout");
            rs.next();
            int maxID = rs.getInt("maxID");
            return maxID + 1;
        }
        catch(final SQLException e) {
            throw new PersistenceException(e);
        }
    }

    private int getRoutineID(Routine r) {
        try(final Connection c = connection()) {
            final PreparedStatement ps = c.prepareStatement("SELECT ID_R from routine where routine.name_r = ?");
            ps.setString(1, r.getName());
            ResultSet rs = ps.executeQuery();
            rs.next();
            int idR = rs.getInt("ID_R");
            return idR;
        }
        catch(final SQLException e) {
            throw new PersistenceException(e);
        }
    }

}