package comp3350.superset.presentation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import comp3350.superset.R;

public class ProgressActivity extends Activity
{
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress);
    }

    public void buttonUploadProgressOnClick(View v) {
        Intent upIntent = new Intent(ProgressActivity.this, UploadProgressActivity.class);
        ProgressActivity.this.startActivity(upIntent);
    }
}
