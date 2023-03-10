// Purpose: defines a workout with routine, day, and duration

package comp3350.superset.objects;

import java.time.LocalDate;
import java.time.Month;

public class Workout {
    private Routine routine;
    private LocalDate date;
    private int durationSec;

    public Workout(Routine r, int durationSec){
        this.routine = r;
        this.date = LocalDate.now();
        this.durationSec = durationSec;
    }

    public Workout(Routine r, Month month, int durationSec){
        this.routine = r;
        this.date = LocalDate.of(2023 ,month, 01);
        this.durationSec = durationSec;
    }

    public Routine getRoutine() {
        return routine;
    }

    public int getDurationSec() {return durationSec;}
    public Month getMonth() {return date.getMonth();}


}
