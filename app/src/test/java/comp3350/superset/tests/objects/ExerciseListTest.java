package comp3350.superset.tests.objects;


import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import comp3350.superset.objects.Exercise;
import comp3350.superset.objects.ExerciseList;

public class ExerciseListTest {

    @Test
    public void testGetNames() {

        List<String> names = Arrays.asList("Pushups", "Squats", "");

        ExerciseList el = new ExerciseList();
        el.add(new Exercise(names.get(0), 5));
        el.add(new Exercise(names.get(1), 0));
        el.add(new Exercise(names.get(2), 15));

        assertEquals(3, el.size());
        assertEquals(names.get(0), el.getNames().get(0));   // expected
        assertEquals(names.get(1), el.getNames().get(1));   // edge: 0 duration
        assertEquals(names.get(2), el.getNames().get(2));   // edge: empty name
    }

    @Test
    public void testGetNamesWithTime() {
        List<String> names = Arrays.asList("Pushups", "Squats", "");
        List<Integer> times = Arrays.asList(5,0,15);

        ExerciseList el = new ExerciseList();
        el.add(new Exercise(names.get(0), 5));
        el.add(new Exercise(names.get(1), -5));
        el.add(new Exercise(names.get(2), 15));

        assertEquals(3, el.size());
        // expected case
        assertEquals(names.get(0) + "           "+times.get(0)+" seconds", el.getNamesWithTime().get(0));
        // edge: negative duration
        assertEquals(names.get(1) + "           "+times.get(1)+" seconds", el.getNamesWithTime().get(1));
        // edge: empty name
        assertEquals(names.get(2) + "           "+times.get(2)+" seconds", el.getNamesWithTime().get(2));
    }
}
