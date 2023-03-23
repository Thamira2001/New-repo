package comp3350.superset.presentation;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.Calendar;
import java.util.Date;

import comp3350.superset.R;
import comp3350.superset.objects.Update;

public class UploadProgressActivity extends Activity {

    ImageView preview;
    DatePicker date;
    Uri imageURI;
    EditText weight;

    int SELECT_PICTURE = 200;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_progress);

        preview = findViewById(R.id.preview);
        date = findViewById(R.id.datePicker);
        imageURI = null;
        weight = findViewById(R.id.weight);

        imageChooser();

        preview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageChooser();
            }
        });
    }

    void imageChooser() {

        Intent i = new Intent();
        i.setType("image/*");
        i.setAction(Intent.ACTION_GET_CONTENT);

        startActivityForResult(Intent.createChooser(i, "Select Picture"), SELECT_PICTURE);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            if (requestCode == SELECT_PICTURE) {
                Uri selectedImageUri = data.getData();
                if (null != selectedImageUri) {
                    preview.setImageURI(selectedImageUri);
                    imageURI = selectedImageUri;
                }
            }
        }
        if (null == preview.getDrawable()) {
            finish();
        }
    }

    public void buttonUploadOnClick(View v) {
        Calendar currDate = new Calendar.Builder().build();
        Calendar setDate = new Calendar.Builder().setDate(date.getYear(), date.getMonth(), date.getDayOfMonth()).build();
        String strWeight = weight.getText().toString();
        Update update;

        currDate.setTime(new Date());
        if (!setDate.after(currDate)) {
            if (strWeight.isBlank()) {
                update = new Update(imageURI, setDate);
            }
            else if (Integer.parseInt(strWeight) > 0) {
                update = new Update(imageURI, setDate, Integer.parseInt(strWeight));
            }
            finish();
        }
    }
}
