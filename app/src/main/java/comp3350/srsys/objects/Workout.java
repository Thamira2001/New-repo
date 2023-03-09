// Purpose: defines a workout with start and end times

package comp3350.srsys.objects;

import java.time.LocalDate;
import java.time.Month;

public class Workout {
    private Routine routine;
    private long startTimeSec;
    private long endTimeSec;
    private LocalDate date;

    public Workout(Routine r) {
        this(r, -1, -1);
    }

    public Workout(Routine r, long startTimeSec, long endTimeSec) {
        this.routine = r;
        this.startTimeSec = startTimeSec;
        this.endTimeSec = endTimeSec;
        this.date = LocalDate.now();
    }

    public Routine getRoutine() {
        return routine;
    }

    public long getStartTimeSec() {return startTimeSec;}
    public long getEndTimeSec() {return endTimeSec;}

    public int getDurationSec() {return (int)(endTimeSec - startTimeSec);}
    public Month getMonth() {return date.getMonth();}

    public void startWorkout() {
        if(startTimeSec == -1)
            this.startTimeSec = System.currentTimeMillis()/1000;
    }

    public void endWorkout(){
        if(endTimeSec == -1)
            this.endTimeSec = System.currentTimeMillis()/1000;
    }

}
