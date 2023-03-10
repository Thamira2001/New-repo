package comp3350.srsys.persistence.hsqldb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import comp3350.srsys.objects.Exercise;
import comp3350.srsys.objects.ExerciseList;
import comp3350.srsys.objects.Routine;
import comp3350.srsys.persistence.RoutinePersistence;

public class RoutinePersistenceHSQLDB implements RoutinePersistence {

    private final String dbPath;

    public RoutinePersistenceHSQLDB(final String dbPath) {
        this.dbPath = dbPath;
    }

    private Connection connection() throws SQLException {
        return DriverManager.getConnection("jdbc:hsqldb:file:" + dbPath + ";shutdown=true", "SA", "");
    }

    private Routine fromResultSet(final ResultSet rs) throws SQLException {
        final String name = rs.getString("NAME_R");
        final ExerciseList exerciseList = new ExerciseList();//getExerciseListFromResultSet(rs);
        return new Routine(name, exerciseList);
    }

    public ExerciseList getExerciseListFromResultSet(ResultSet rs) throws SQLException {
        ExerciseList exerciseList = new ExerciseList();

        while(rs.next()) {
            Exercise exercise = new Exercise();
            exercise.setName(rs.getString("name"));
            exercise.setDurationSec(rs.getInt("durationSec"));
            exercise.setNumReps(rs.getInt("numReps"));
            exerciseList.add(exercise);
        }
        return exerciseList;
    }

    @Override
    public List<Routine> getRoutineSequential() {
        final List<Routine> routines = new ArrayList<>();

        try(final Connection c = connection()) {
            final Statement st = c.createStatement();
            final ResultSet rs = st.executeQuery("SELECT * FROM routine");
            while(rs.next())
            {
                final Routine routine = fromResultSet(rs);
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
            final PreparedStatement rt = c.prepareStatement("INSERT INTO routine VALUES(?, ?)");
            rt.setString(1, currentRoutine.getName());
            rt.setString(2, exerciseListToString(currentRoutine.getExercises()));
            rt.executeUpdate();
            return true;
        } catch (final SQLException e) {
            throw new PersistenceException(e);
        }
    }

    public String exerciseListToString(ExerciseList exerciseList) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < exerciseList.size(); i++) {
            Exercise exercise = exerciseList.get(i);
            sb.append("Name: ").append(exercise.getName()).append("\n");
            sb.append("DurationSecond: ").append(exercise.getDurationSec()).append("\n");
            sb.append("Number of reps: ").append(exercise.getNumReps()).append("\n\n");
        }

        return sb.toString();
    }

    @Override
    public boolean removeRoutine(Routine currentRoutine) {
        if(currentRoutine == null) {
            return false;
        }
        try (final Connection c = connection()) {
            final PreparedStatement n = c.prepareStatement("DELETE FROM routine WHERE name = ?");
            n.setString(1, currentRoutine.getName());
            n.executeUpdate();
            final PreparedStatement el = c.prepareStatement("DELETE FROM routine WHERE exercise list = ?");
            el.setString(1, exerciseListToString(currentRoutine.getExercises()));
            el.executeUpdate();
            return true;
        } catch (final SQLException e) {
            throw new PersistenceException(e);
        }
    }


}