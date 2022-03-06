package neu.edu.madcourse.numadfa_zacharysylvane;

import android.os.Bundle;
import android.os.Handler;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.net.URL;

public class AtYourService extends AppCompatActivity {
    private Handler textHandler = new Handler();
    private static final String TAG = "WebServiceActivity";
    private String actual_url = "https://www.thecocktaildb.com/api/json/v1/1/search.php?s=";

    private EditText user_Drink;
    private URL url_format;
    private String string_format;
    private int i = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);

//        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
//        StrictMode.setThreadPolicy(policy);

        setContentView(R.layout.activity_web_service);
        user_Drink = (EditText)findViewById(R.id.user_Drink);


        TextView mTitleTextView = (TextView) findViewById(R.id.result_textview);

    }

}
