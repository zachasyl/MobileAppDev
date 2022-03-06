package neu.edu.madcourse.numadfa_zacharysylvane;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button button;
    Button newActivity;
    Button collectorActivity;
    Button myLocation;
    Button AtYourService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.button1);
        newActivity = (Button) findViewById(R.id.button2);
        collectorActivity = (Button) findViewById(R.id.linkCollector);
        myLocation = (Button) findViewById(R.id.myLocation);
        AtYourService = (Button) findViewById(R.id.AtYourService);

//        TextView L = findViewById(R.id.google);
//        L.setMovementMethod(LinkMovementMethod.getInstance());
//        L.setText(Html.fromHtml(text));
//        String url = "http://www.example.com";
//        Intent i = new Intent(Intent.ACTION_VIEW);
//        i.setData(Uri.parse(url));
//        startActivity(i);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Personal.class);
                startActivity(intent);
//                Toast.makeText(getApplicationContext(),
//                        "Zachary Sylvane" + "\n" + "sylvane.z@northeastern.edu", Toast.LENGTH_LONG).show();
            }
        });

        newActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                startActivity(intent);
            }
        });

        collectorActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Recycler.class);
                startActivity(intent);
            }
        });

        myLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, LocationA5.class);
                startActivity(intent);
            }
        });
        AtYourService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AtYourService.class);
                startActivity(intent);
            }
        });


    }
}