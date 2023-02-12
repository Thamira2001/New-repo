package comp3350.srsys.tests.objects;

import org.junit.Test;
import static org.junit.Assert.*;

import comp3350.srsys.objects.Exercise;

public class ExerciseTest {
    @Test
    public void testSet(){
        System.out.println("\n start of testSet\n");
        Exercise newExercise = new Exercise("Leg Press", 8, 120);

        assertNotNull("Should be true because the object is not null!", newExercise);
        assertTrue("Should be true", "Leg Press".equals(newExercise.getName()));

        assertTrue("sould be true because expected reps should be greater than 0", newExercise.getNumReps() > 0);

        assertTrue("should be true because expected time for exercise should take more than 0s", newExercise.getDurationSec() > 0);

        
    }
}
