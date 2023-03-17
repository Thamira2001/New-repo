// Purpose: defines a workout with routine, day, and duration

package comp3350.superset.objects;

import java.time.LocalDate;
import java.time.Month;

public class Workout {
    private Routine routine;
    private int month;
    private int durationSec;

    public Workout(Routine r, int durationSec){
        this.routine = r;
        this.month = LocalDate.now().getMonth().getValue();
        this.durationSec = (durationSec >= 0) ? durationSec : 0;
    }

    public Workout(Routine r, int month, int durationSec){
        this.routine = r;
        this.month = (0 < month && month <= 12) ? month : 1;
        this.durationSec = (durationSec >= 0) ? durationSec : 0;
    }

    public Routine getRoutine() {
        return routine;
    }

    public int getDurationSec() {return durationSec;}
    public int getMonth() {return month;}


}
