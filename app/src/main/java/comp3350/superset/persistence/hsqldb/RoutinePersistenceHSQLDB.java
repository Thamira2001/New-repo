package comp3350.superset.persistence.hsqldb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import comp3350.superset.objects.Exercise;
import comp3350.superset.objects.ExerciseList;
import comp3350.superset.objects.Routine;
import comp3350.superset.persistence.RoutinePersistence;

public class RoutinePersistenceHSQLDB implements RoutinePersistence {

    private final String dbPath;

    public RoutinePersistenceHSQLDB(final String dbPath) {
        this.dbPath = dbPath;
    }

    private Connection connection() throws SQLException {
        return DriverManager.getConnection("jdbc:hsqldb:file:" + dbPath + ";shutdown=true", "SA", "");
    }

    public static Routine getRoutinefromResultSet(final ResultSet rs) throws SQLException {
        final int rID = rs.getInt("ID_R");
        final String name = rs.getString("NAME_R");
        final ExerciseList exerciseList = getExerciseListFromResultSet(rs, rID);

        return new Routine(name, exerciseList);
    }

    public static ExerciseList getExerciseListFromResultSet(ResultSet rs, int curRID) throws SQLException {

        ExerciseList exerciseList = new ExerciseList();

         do {
            String name = rs.getString("NAME_E");
            int dur = rs.getInt("DURATION_SEC");
            int numReps = rs.getInt("NUMREPS");
            exerciseList.add(new Exercise(name, dur, numReps));
        } while(rs.next() && rs.getInt("ID_R") == curRID);

         rs.previous();

        return exerciseList;
    }

    @Override
    public List<Routine> getRoutineSequential() {
        final List<Routine> routines = new ArrayList<>();

        try(final Connection c = connection()) {
            final Statement st = c.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            final ResultSet rs = st.executeQuery("SELECT * FROM routine LEFT JOIN exercise on routine.id_r = exercise.id_r");
            while(rs.next()) {
                final Routine routine = getRoutinefromResultSet(rs);
                routines.add(routine);
            }
            rs.close();
            st.close();

            return routines;
        }
        catch(final SQLException e)
        {
            throw new PersistenceException(e);
        }
    }

    @Override
    public boolean insertRoutine(Routine currentRoutine) {
        if(currentRoutine == null) {
            return false;
        }
        try (final Connection c = connection()) {
            // insert new routine
            PreparedStatement rt = c.prepareStatement("INSERT INTO routine VALUES(?, ?)");
            int routineID = nextRoutineID();
            rt.setInt(1, routineID);
            rt.setString(2, currentRoutine.getName());
            rt.executeUpdate();

            // insert new exercises, linked to routine id
            ExerciseList eList = currentRoutine.getExercises();
            for(int i = 0; i < eList.size(); i++) {
                Exercise e = eList.get(i);
                rt = c.prepareStatement("INSERT INTO exercise VALUES(?, ?, ?, ?)");
                // name, duration, reps, rid
                rt.setString(1, e.getName());
                rt.setInt(2, e.getDurationSec());
                rt.setInt(3, e.getNumReps());
                rt.setInt(4, routineID);
                rt.executeUpdate();
            }
            return true;
        } catch (final SQLException e) {
            throw new PersistenceException(e);
        }
    }

    private int nextRoutineID() {
        try(final Connection c = connection()) {
            final Statement st = c.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            final ResultSet rs = st.executeQuery("SELECT MAX(ID_R) as maxID FROM routine");
            rs.next();
            int maxID = rs.getInt("maxID");
            return maxID + 1;
        }
        catch(final SQLException e) {
            throw new PersistenceException(e);
        }
    }


}