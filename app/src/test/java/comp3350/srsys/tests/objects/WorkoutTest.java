package comp3350.srsys.tests.objects;

import org.junit.Test;
import static org.junit.Assert.*;

import comp3350.srsys.objects.Exercise;
import comp3350.srsys.objects.Workout;

public class WorkoutTest {
    @Test
    public void testWorkout(){
        Workout newW= new Workout();//creates an empty array and initializes the values of other instance variables to zero

        assertTrue("Should be true because instance variables are set to zero", newW.getTotalWorkoutTime()==0);
        assertTrue("Should be true because instance variables are set to zero", newW.getTotalSets()==0);


        //add a new set to Workout
        Exercise newExercise = new Exercise("Leg Press", 8, 120);
        newW.addSet(newExercise);

        assertTrue("Should be true because there is a set now added into the workout total expected workout time is set to > 0", newW.getTotalWorkoutTime() >0);
        assertTrue("Should be true because number of sets are now 1 so totalSets are set to 1", newW.getTotalSets()==1);


        System.out.println("End of workoutTest");



    }
}
