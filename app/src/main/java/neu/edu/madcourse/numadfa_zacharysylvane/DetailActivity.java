package neu.edu.madcourse.numadfa_zacharysylvane;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;


public class DetailActivity extends AppCompatActivity {
    private static final String TAG = "DetailActivity___";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.v(TAG, "onCreate()");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
    }
}
