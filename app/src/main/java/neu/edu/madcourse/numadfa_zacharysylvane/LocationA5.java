package neu.edu.madcourse.numadfa_zacharysylvane;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
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


public class LocationA5 extends AppCompatActivity {
    private static final int MY_PERMISSIONS_REQUEST_ACCESS_COARSE_LOCATION = 1;
    Button fetch_location;
    TextView user_location;
    private FusedLocationProviderClient myFusedLocationClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_location);

        fetch_location = (Button) findViewById(R.id.fetch_location);
        user_location = findViewById(R.id.user_location);
        myFusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
        Double latitude;
        Double longitude;

        fetch_location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                fetchLocation();

            }
        });

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
}

