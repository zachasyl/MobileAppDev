package neu.edu.madcourse.numadfa_zacharysylvane;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;

// Based on code from the following:
//https://developer.android.com/training/location/retrieve-current
//https://developer.android.com/training/permissions/requesting


public class LocationA5 extends AppCompatActivity {


    private static final int MY_PERMISSIONS_REQUEST_ACCESS_COARSE_LOCATION = 1;
    Button fetch_location;
    TextView user_location;
    private FusedLocationProviderClient myFusedLocationClient;
    private static final String KEY_TEXT_VALUE = "textValue";



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_location);
        fetch_location = (Button) findViewById(R.id.fetch_location);
        user_location = findViewById(R.id.user_location);

        if (savedInstanceState != null) {
            // calls savedinstancestate to get the data from before screen turn.
            CharSequence savedText = savedInstanceState.getCharSequence(KEY_TEXT_VALUE);
            // changed orientation, set data.
            user_location.setText(savedText);

        }
        myFusedLocationClient = LocationServices.getFusedLocationProviderClient(this);

        fetch_location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                fetchLocation();

            }
        });

    }

//    whenever Android destroys and recreates your Activity on orientation change,
//    it calls onSaveInstanceState() and then oncreate. that which is saved in
//    the onsaveinstance we can get back from our oncreate code concerning savedinstance.
    @Override
    protected void onSaveInstanceState (Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putCharSequence(KEY_TEXT_VALUE, user_location.getText());
    }
    private void fetchLocation() {
        // Permission already granted
        if (ContextCompat.checkSelfPermission(LocationA5.this,
                Manifest.permission.ACCESS_COARSE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            //permission granted therefore we wont get following error

//            Call requires permission which may be rejected by user: code should explicitly
//            check to see if permission is available (with checkPermission) or explicitly
//            handle a potential SecurityException

            myFusedLocationClient.getLastLocation()
                    .addOnSuccessListener(this, new OnSuccessListener<Location>() {
                        @Override
                        public void onSuccess(Location location) {
                            // Got last known location.
                            if (location != null) {
                                Double latitude = location.getLatitude();
                                Double longitude = location.getLongitude();

                                user_location.setText("Latitude = " + latitude + "\nLongitude = " + longitude);

                            }
                        }
                    });

        }else{ //not granted

            ActivityCompat.requestPermissions(LocationA5.this,
                    new String[]{Manifest.permission.ACCESS_COARSE_LOCATION},
                    MY_PERMISSIONS_REQUEST_ACCESS_COARSE_LOCATION);
        }
    }
//    the only purpose of this right now is that  immediately when access is granted
//    for the first time, the user will not need to click the button again
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull @org.jetbrains.annotations.NotNull String[] permissions, @NonNull @org.jetbrains.annotations.NotNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode == MY_PERMISSIONS_REQUEST_ACCESS_COARSE_LOCATION){
            if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                fetchLocation();
            }
                else{

                }
            }

        }
}

