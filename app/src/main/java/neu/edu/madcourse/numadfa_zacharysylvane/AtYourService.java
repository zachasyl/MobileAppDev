package neu.edu.madcourse.numadfa_zacharysylvane;


import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URL;


public class AtYourService extends AppCompatActivity {

    private Handler textHandler = new Handler();
    private static final String TAG = "WebServiceActivity";
    private String actual_url = "https://www.thecocktaildb.com/api/json/v1/1/search.php?s=";

    private EditText user_Drink;
    private String string_format;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
//        StrictMode.setThreadPolicy(policy);

        setContentView(R.layout.activity_web_service);
        user_Drink = (EditText)findViewById(R.id.user_Drink);

    }

    public void runOnRunnableThread(View view){
        runnableThread runnableThread = new runnableThread();
        new Thread(runnableThread).start();

    }

    class runnableThread implements Runnable{

        String one_ingredient = "";
        String all_ingreditents = "";

        @Override
        public void run(){
            JSONObject jObject;

            try {
                URL url = new URL(string_format);
                String resp = NetworkUtil.httpResponse(url);

                jObject = new JSONObject(resp);

                Integer i = 1;

                while (true ) {
                        String ingredient = "strIngredient" + i;
                        one_ingredient = jObject.getJSONArray("drinks").getJSONObject(0).get(ingredient).toString();
                        if (one_ingredient.equals("null")) {
                            break;
                        }

                        all_ingreditents += one_ingredient + "\n";
                        i += 1;

                    }
            } catch (IOException | JSONException e) {
                e.printStackTrace();
            }
            textHandler.post(new Runnable() {
                @Override
                public void run() {

                    TextView result_view = (TextView)findViewById(R.id.result_textview);

                        if (all_ingreditents.length() >0 ) {
                            result_view.setText((CharSequence) all_ingreditents);
                        }
                }
            });
        }
    }
    public void callWebserviceButtonHandler(View view)   {
        string_format = actual_url + user_Drink.getText().toString();
            runOnRunnableThread(view);

    }
}
