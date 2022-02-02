package neu.edu.madcourse.numadfa_zacharysylvane;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

//        no switch technique. Commented out for my own practice. Did not use switch in main.
//        A = (Button) findViewById(R.id.A);
//
//        A.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                TextView tv = (TextView)findViewById(R.id.DetailActivityText);
//                tv.setText("Pressed:" + " A");
//            }
//        });

    }

    public void onClick(View view){
        TextView tv = (TextView)findViewById(R.id.PressedButton);
        switch(view.getId()){
            case R.id.A:
                tv.setText(" A");
                break;
            case R.id.B:
                tv.setText(" B");
                break;
            case R.id.C:
                tv.setText(" C");
                break;
            case R.id.D:
                tv.setText(" D");
                break;
            case R.id.E:
                tv.setText(" E");
                break;
            case R.id.F:
                tv.setText(" F");
                break;
        }

    }


}
