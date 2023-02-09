package comp3350.srsys.tests.objects;

import comp3350.srsys.objects.Exercise;

import org.junit.Test;
import static org.junit.Assert.*;
public class ExerciseTest {
    @Test
    public void testExercise(){
        //checking for valid data
        System.out.println("\n Starting testExercise\n");
        Exercise ex= new Exercise("Shoulder Press");

        //check whether it is not null
        assertNotNull("should be true\n",ex);
        //check for valid data
        assertTrue("should be True!\n", "Shoulder Press".equals(ex));


        //check for invalid data
        assertTrue("should be false\n", "Leg Press".equals(ex));


        System.out.println("\n End of testExercise");



    }
}
