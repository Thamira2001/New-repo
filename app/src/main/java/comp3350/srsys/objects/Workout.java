package comp3350.srsys.objects;

import java.util.List;

public class Workout {
    private Routine routine;
    private long startTimeSec;
    private long endTimeSec;

    public Workout(Routine r) {
        this(r, -1, -1);
    }

    public Workout(Routine r, long startTimeSec, long endTimeSec) {
        this.routine = r;
        this.startTimeSec = startTimeSec;
        this.endTimeSec = endTimeSec;
    }

    public long getStartTimeSec() {return startTimeSec;}
    public long getEndTimeSec() {return endTimeSec;}

    public void startWorkout() {
        if(startTimeSec == -1)
            this.startTimeSec = System.currentTimeMillis()/1000;
    }

    public void endWorkout(){
        if(endTimeSec == -1)
            this.endTimeSec = System.currentTimeMillis()/1000;
    }



}
