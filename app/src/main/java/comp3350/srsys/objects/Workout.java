// Purpose: defines a workout with start and end times

package comp3350.srsys.objects;

import java.time.LocalDate;
import java.time.Month;

public class Workout {
    private Routine routine;
    private LocalDate date;
    private int durationSec;

    public Workout(Routine r, int durationSec){
        this.routine = r;
        this.durationSec = durationSec;
    }

    public Routine getRoutine() {
        return routine;
    }

    public int getDurationSec() {return durationSec;}
    public Month getMonth() {return date.getMonth();}


}
