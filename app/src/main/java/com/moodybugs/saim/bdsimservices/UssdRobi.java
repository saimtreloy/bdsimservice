package com.moodybugs.saim.bdsimservices;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class UssdRobi extends AppCompatActivity {

    ButtonAwesome btnUSSDRb1, btnUSSDRb2, btnUSSDRb3, btnUSSDRb4, btnUSSDRb5, btnUSSDRb6, btnUSSDRb7, btnUSSDRb8,
            btnUSSDRb9, btnUSSDRb10, btnUSSDRb11, btnUSSDRb12, btnUSSDRb13, btnUSSDRb14;

    private final int REQUEST_CODE_CALL = 1;
    public int ButtonClickedChecked;
    String phoneNumber = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.ThemeAirtel);
        setContentView(R.layout.ussd_robi);
        setTitle("Robi Important USSD");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_appbar_robi);

        Initialization();

        CallButtonClicked(btnUSSDRb1);
        CallButtonClicked(btnUSSDRb2);
        CallButtonClicked(btnUSSDRb3);
        CallButtonClicked(btnUSSDRb4);
        CallButtonClicked(btnUSSDRb5);
        CallButtonClicked(btnUSSDRb6);
        CallButtonClicked(btnUSSDRb7);
        CallButtonClicked(btnUSSDRb8);
        CallButtonClicked(btnUSSDRb9);
        CallButtonClicked(btnUSSDRb10);
        CallButtonClicked(btnUSSDRb11);
        CallButtonClicked(btnUSSDRb12);
        CallButtonClicked(btnUSSDRb13);
        CallButtonClicked(btnUSSDRb14);
    }

    public void Initialization() {
        btnUSSDRb1 = (ButtonAwesome) findViewById(R.id.btnUSSDRb1);
        btnUSSDRb2 = (ButtonAwesome) findViewById(R.id.btnUSSDRb2);
        btnUSSDRb3 = (ButtonAwesome) findViewById(R.id.btnUSSDRb3);
        btnUSSDRb4 = (ButtonAwesome) findViewById(R.id.btnUSSDRb4);
        btnUSSDRb5 = (ButtonAwesome) findViewById(R.id.btnUSSDRb5);
        btnUSSDRb6 = (ButtonAwesome) findViewById(R.id.btnUSSDRb6);
        btnUSSDRb7 = (ButtonAwesome) findViewById(R.id.btnUSSDRb7);
        btnUSSDRb8 = (ButtonAwesome) findViewById(R.id.btnUSSDRb8);
        btnUSSDRb9 = (ButtonAwesome) findViewById(R.id.btnUSSDRb9);
        btnUSSDRb10 = (ButtonAwesome) findViewById(R.id.btnUSSDRb10);
        btnUSSDRb11 = (ButtonAwesome) findViewById(R.id.btnUSSDRb11);
        btnUSSDRb12 = (ButtonAwesome) findViewById(R.id.btnUSSDRb12);
        btnUSSDRb13 = (ButtonAwesome) findViewById(R.id.btnUSSDRb13);
        btnUSSDRb14 = (ButtonAwesome) findViewById(R.id.btnUSSDRb14);
    }


    //Runtime Permission For Importing Contacts
    public void runtimePermission() {
        if (ButtonClickedChecked == 333) {
            if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
                makeCall(phoneNumber);
            } else {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    if (shouldShowRequestPermissionRationale(Manifest.permission.CALL_PHONE)) {
                        Toast.makeText(getApplicationContext(), "Permission required", Toast.LENGTH_SHORT).show();
                    }
                    requestPermissions(new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CODE_CALL);
                } else {
                    makeCall(phoneNumber);
                }
            }
        }
    }

    public void makeCall(String Number) {
        Intent callIntent = new Intent(Intent.ACTION_CALL);
        callIntent.setData(Uri.parse("tel:" + phoneNumber));
        callIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(callIntent);
    }


    //Requesting Permission result For Importing Contacts
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if (ButtonClickedChecked == 333) {
            if (requestCode == REQUEST_CODE_CALL) {
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    makeCall(phoneNumber);
                } else {
                    Toast.makeText(getApplicationContext(), "Call not processed", Toast.LENGTH_SHORT).show();
                }
            } else {
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
            }
        }
    }

    public void CallButtonClicked(final ButtonAwesome buttonAwesome) {
        buttonAwesome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ButtonClickedChecked = 333;
                String bNumber = buttonAwesome.getText().toString();
                phoneNumber = Uri.encode(bNumber);
                Log.d("Saim Check :", phoneNumber);
                runtimePermission();
                Toast.makeText(getApplicationContext(), "Your request has been processed", Toast.LENGTH_LONG).show();
            }
        });
    }
}
