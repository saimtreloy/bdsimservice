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

public class InternetAirtel extends AppCompatActivity {

    ButtonAwesome btnInternetAr0, btnInternetAr1, btnInternetAr2, btnInternetAr3, btnInternetAr4, btnInternetAr5, btnInternetAr6, btnInternetAr7,
            btnInternetAr8, btnInternetAr9, btnInternetAr10, btnInternetAr11, btnInternetAr12, btnInternetAr13, btnInternetAr14,
            btnInternetAr15, btnInternetAr16, btnInternetAr17;

    private final int REQUEST_CODE_CALL = 1;
    public int ButtonClickedChecked;
    String phoneNumber = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.ThemeAirtel);
        setContentView(R.layout.internet_airtel);
        setTitle("Airtel Internet Packages");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_appbar_airtel);

        Initialization();

        btnInternetAr0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InternetAirtel.this, Browser.class);
                intent.putExtra("url", "http://www.bd.airtel.com/personal/3g/internet-package/3g-new-offers");
                startActivity(intent);
            }
        });

        CallButtonClicked(btnInternetAr1);
        CallButtonClicked(btnInternetAr2);
        CallButtonClicked(btnInternetAr3);
        CallButtonClicked(btnInternetAr4);
        CallButtonClicked(btnInternetAr5);
        CallButtonClicked(btnInternetAr6);
        CallButtonClicked(btnInternetAr7);
        CallButtonClicked(btnInternetAr8);
        CallButtonClicked(btnInternetAr9);
        CallButtonClicked(btnInternetAr10);
        CallButtonClicked(btnInternetAr11);
        CallButtonClicked(btnInternetAr12);
        CallButtonClicked(btnInternetAr13);
        CallButtonClicked(btnInternetAr14);
        CallButtonClicked(btnInternetAr15);
        CallButtonClicked(btnInternetAr16);
        CallButtonClicked(btnInternetAr17);
    }


    public void Initialization() {
        btnInternetAr0 = (ButtonAwesome) findViewById(R.id.btnInternetAr0);
        btnInternetAr1 = (ButtonAwesome) findViewById(R.id.btnInternetAr1);
        btnInternetAr2 = (ButtonAwesome) findViewById(R.id.btnInternetAr2);
        btnInternetAr3 = (ButtonAwesome) findViewById(R.id.btnInternetAr3);
        btnInternetAr4 = (ButtonAwesome) findViewById(R.id.btnInternetAr4);
        btnInternetAr5 = (ButtonAwesome) findViewById(R.id.btnInternetAr5);
        btnInternetAr6 = (ButtonAwesome) findViewById(R.id.btnInternetAr6);
        btnInternetAr7 = (ButtonAwesome) findViewById(R.id.btnInternetAr7);
        btnInternetAr8 = (ButtonAwesome) findViewById(R.id.btnInternetAr8);
        btnInternetAr9 = (ButtonAwesome) findViewById(R.id.btnInternetAr9);
        btnInternetAr10 = (ButtonAwesome) findViewById(R.id.btnInternetAr10);
        btnInternetAr11 = (ButtonAwesome) findViewById(R.id.btnInternetAr11);
        btnInternetAr12 = (ButtonAwesome) findViewById(R.id.btnInternetAr12);
        btnInternetAr13 = (ButtonAwesome) findViewById(R.id.btnInternetAr13);
        btnInternetAr14 = (ButtonAwesome) findViewById(R.id.btnInternetAr14);
        btnInternetAr15 = (ButtonAwesome) findViewById(R.id.btnInternetAr15);
        btnInternetAr16 = (ButtonAwesome) findViewById(R.id.btnInternetAr16);
        btnInternetAr17 = (ButtonAwesome) findViewById(R.id.btnInternetAr17);

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

    public void CallButtonClicked(final ButtonAwesome buttonAwesome){
        buttonAwesome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ButtonClickedChecked = 333;
                String bNumber = buttonAwesome.getText().toString();
                phoneNumber = bNumber.substring(0, bNumber.indexOf("#")) + Uri.encode("#");
                Log.d("Saim Check :", phoneNumber);
                runtimePermission();
                Toast.makeText(getApplicationContext(), "Your request has been processed", Toast.LENGTH_LONG).show();
            }
        });
    }
}
