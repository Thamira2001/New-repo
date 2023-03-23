package comp3350.superset.objects;

import android.graphics.drawable.Drawable;
import android.net.Uri;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Update {

    private Uri imageUri;
    private Date date;
    private int weight;

    public Update(Uri imageUri, Calendar date)
    {
        this.imageUri = imageUri;
        this.date = date.getTime();
        this.weight = -1;
    }

    public Update(Uri imageUri, Calendar date, int weight)
    {
        this.imageUri = imageUri;
        this.date = date.getTime();
        this.weight = weight;
    }

    public Uri getImageUri()
    {
        return imageUri;
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
