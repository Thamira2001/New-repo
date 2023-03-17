package comp3350.superset.objects;

import android.graphics.drawable.Drawable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Update {

    private Drawable picture;
    private Date date;
    private int weight;

    public Update(Drawable picture, Calendar date)
    {
        this.picture = picture;
        this.date = date.getTime();
        weight = -1;
    }

    public Update(Drawable picture, Calendar date, int weight)
    {
        this.picture = picture;
        this.date = date.getTime();
        this.weight = weight;
    }

    public Drawable getPicture()
    {
        return picture;
    }

    public String getDate()
    {
        return new SimpleDateFormat("EEEE, MMMM d, yyyy").format(date);
    }

    public int getWeight()
    {
        return weight;
    }
}
