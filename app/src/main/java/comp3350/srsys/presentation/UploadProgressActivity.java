package comp3350.srsys.presentation;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;

import comp3350.srsys.R;

public class UploadProgressActivity extends Activity {

    ImageView preview;
    DatePicker date;
    EditText weight;

    int SELECT_PICTURE = 200;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_progress);

        preview = findViewById(R.id.preview);
        date = findViewById(R.id.datePicker);
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
                }
            }
        }
    }

    public void buttonUploadOnClick(View v)
    {
        preview.getDrawable(); // image file
        System.out.println(date.getDayOfMonth()); // day
        System.out.println(date.getMonth()); // month (starts from 0)
        System.out.println(date.getYear()); // year
        System.out.println(weight.getText()); // entered text (can be blank/whitespace)
    }
}
