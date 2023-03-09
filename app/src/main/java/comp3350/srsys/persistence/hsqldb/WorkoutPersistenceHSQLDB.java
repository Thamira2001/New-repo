package comp3350.srsys.persistence.hsqldb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import comp3350.srsys.objects.ExerciseList;
import comp3350.srsys.objects.Routine;
import comp3350.srsys.objects.Workout;
import comp3350.srsys.objects.Exercise;
import comp3350.srsys.persistence.WorkoutPersistence;


public class WorkoutPersistenceHSQLDB implements WorkoutPersistence {

    private final String dbPath;

    public WorkoutPersistenceHSQLDB(final String dbPath) {
        this.dbPath = dbPath;
    }

    private Connection connection() throws SQLException {
        return DriverManager.getConnection("jdbc:hsqldb:file:" + dbPath + ";shutdown=true", "SA", "");
    }

    private Workout fromResultSet(final ResultSet rs) throws SQLException {
        final Routine routine = getRoutineFromResultSet(rs);
        final int duration = rs.getInt("duration");
        return new Workout(routine, duration);
    }

    public Routine getRoutineFromResultSet(ResultSet rs) throws SQLException {
        Routine routine = new Routine("emptyName");
        ExerciseList exerciseList = new ExerciseList();

        // Set routine properties from ResultSet
        if (rs.next()) {
            routine.setName(rs.getString("routine_name"));
        }

        // Get exercise list from ResultSet
        rs.beforeFirst();
        while (rs.next()) {
            Exercise exercise = new Exercise();
            exercise.setName(rs.getString("name"));
            exercise.setDurationSec(rs.getInt("durationSec"));
            exercise.setNumReps(rs.getInt("numReps"));
            exerciseList.add(exercise);
        }

        routine.setExerciseList(exerciseList);
        return routine;
    }

    @Override
    public List<Workout> getWorkoutSequential() {
        final List<Workout> workouts = new ArrayList<>();

        try(final Connection c = connection()) {
            final Statement st = c.createStatement();
            final ResultSet rs = st.executeQuery("SELECT * FROM workouts");
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
            final PreparedStatement st = c.prepareStatement("INSERT INTO workouts VALUES(?, ?, ?)");
            st.setString(1, routineToString(currentWorkout.getRoutine()));
            st.setInt(2, currentWorkout.getDurationSec());
            st.executeUpdate();
            return true;
        } catch (final SQLException e) {
            throw new PersistenceException(e);
        }
    }

    public String routineToString(Routine routine) {
        StringBuilder sb = new StringBuilder();

        sb.append("Name: ").append(routine.getName()).append("\n");
        sb.append("Exercise List: ").append(routine.getExercises()).append("\n");
        ExerciseList exerciseList = routine.getExercises();
        for (int i = 0; i < exerciseList.size(); i++) {
            Exercise exercise =  exerciseList.get(i);
            sb.append("Name: ").append(exercise.getName()).append("\n");
            sb.append("DurationSecond: ").append(exercise.getDurationSec()).append("\n");
            sb.append("Number of reps: ").append(exercise.getNumReps()).append("\n\n");
        }
        return sb.toString();
    }

    @Override
    public boolean deleteWorkout(final Workout currentWorkout) {
        if(currentWorkout == null) {
            return false;
        }
        try (final Connection c = connection()) {
            final PreparedStatement rt = c.prepareStatement("DELETE FROM workout WHERE routine = ?");
            rt.setString(1, routineToString(currentWorkout.getRoutine()));
            rt.executeUpdate();
            final PreparedStatement st = c.prepareStatement("DELETE FROM workout WHERE start time = ?");
            //st.setLong(1, currentWorkout.getStartTimeSec());
            st.executeUpdate();
            final PreparedStatement et = c.prepareStatement("DELETE FROM workout WHERE end time = ?");
            //et.setLong(1, currentWorkout.getEndTimeSec());
            et.executeUpdate();
            return true;
        } catch (final SQLException e) {
            throw new PersistenceException(e);
        }

    }

}