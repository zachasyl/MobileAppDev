package neu.edu.madcourse.numadfa_zacharysylvane;


import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

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
        private Bitmap bitmap = null;

        @Override
        public void run(){
            JSONObject jObject;

            try {
                URL url = new URL(string_format);
                String resp = NetworkUtil.httpResponse(url);

                jObject = new JSONObject(resp);

                Integer i = 1;

                while (true ) {
                        // the first JSONObject that returns may not be an exact match
                        // for isntance, if a user types in "a", multiple drinks with the letter a
                        // may show up. We want a return only if the first object's name is an exact match with the ingredient
                        //for instance margarita will have multiple margaritas but the first is "margarita"
                        // our search is for finding an exact match to learn the ingredients.
                        if (!((jObject.getJSONArray("drinks").getJSONObject(0).get("strDrink")).toString().equalsIgnoreCase(user_Drink.getText().toString()))){
                            break;
                        }
                        String ingredient = "strIngredient" + i;
                        one_ingredient = jObject.getJSONArray("drinks").getJSONObject(0).get(ingredient).toString();
                        // When there is no longer an ingredient
                        if (one_ingredient.equals("null")) {
                            break;
                        }


                        all_ingreditents += one_ingredient + "\n";
                        bitmap = BitmapFactory.decodeStream((InputStream) new URL(
                                jObject.getJSONArray("drinks").getJSONObject(0).get("strDrinkThumb").toString()
                        ).getContent());

                        i += 1;

                    }
            } catch (IOException | JSONException e) {
                textHandler.post(new Runnable() {
                    @Override
                    public void run() {

                        TextView result_view = (TextView)findViewById(R.id.result_textview);
                        final ImageView f = (ImageView)findViewById(R.id.imageView);
                        result_view.setText("Error No Drink Found.");
                        f.setImageBitmap(null);
                    }
                });
                e.printStackTrace();
            }
            textHandler.post(new Runnable() {
                @Override
                public void run() {

                    TextView result_view = (TextView)findViewById(R.id.result_textview);
                    final ImageView f = (ImageView)findViewById(R.id.imageView);

                        if (all_ingreditents.length() >0 ) {
                            result_view.setText((CharSequence) all_ingreditents);
                            f.setImageBitmap(bitmap);
                        }
                        else{
                                // Either there were multiple drinks but the first was
                                // not an exact match, or there was no match.
                                result_view.setText("No Drink Found.");
                                f.setImageBitmap(null);
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
