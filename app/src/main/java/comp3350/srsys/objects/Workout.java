package comp3350.srsys.objects;

public class Workout {
    private Routine routine;
    private long startTime;
    private long endTime;

    public Workout(Routine r) {
        this(r, -1, -1);
    }

    public Workout(Routine r, long startTime, long endTime) {
        this.routine = r;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public void startWorkout() {
        if(startTime == -1)
            this.startTime = System.currentTimeMillis();
    }

    public void endWorkout(){
        if(endTime == -1)
            this.endTime = System.currentTimeMillis();
    }



}
