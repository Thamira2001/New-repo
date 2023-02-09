package comp3350.srsys.tests.objects;

import org.junit.Test;
import static org.junit.Assert.*;

import comp3350.srsys.objects.Set;

public class SetTest {
    @Test
    public void testSet(){
        System.out.println("\n start of testSet\n");
        Set newSet= new Set("Leg Press", 8, 120);

        assertNotNull("Should be true because the object is not null!",newSet);
        assertTrue("Should be true", "Leg Press".equals(newSet.getExercise()));

        assertTrue("sould be true because expected reps should be greater than 0", newSet.getExpReps() > 0);

        assertTrue("should be true because expected time for exercise should take more than 0s", newSet.getTime() > 0);

        
    }
}
