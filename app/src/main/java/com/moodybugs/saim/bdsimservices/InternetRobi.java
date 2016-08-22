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

public class InternetRobi extends AppCompatActivity {

    ButtonAwesome btnInternetRobi0, btnInternetRobi1, btnInternetRobi2,btnInternetRobi3,btnInternetRobi4,btnInternetRobi5,btnInternetRobi6,btnInternetRobi7,
    btnInternetRobi8, btnInternetRobi9,btnInternetRobi10,btnInternetRobi11;

    private final int REQUEST_CODE_CALL = 1;
    public int ButtonClickedChecked;
    String phoneNumber = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.ThemeAirtel);
        setContentView(R.layout.internet_robi);
        setTitle("Robi Internet Packages");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_appbar_robi);

        Initialization();

        btnInternetRobi1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InternetRobi.this, Browser.class);
                intent.putExtra("url", "http://www.bd.airtel.com/personal/products-services/prepaid/packages-recharge/bundle-offers");
                startActivity(intent);
            }
        });

        CallButtonClicked(btnInternetRobi1);
        CallButtonClicked(btnInternetRobi2);
        CallButtonClicked(btnInternetRobi3);
        CallButtonClicked(btnInternetRobi4);
        CallButtonClicked(btnInternetRobi5);
        CallButtonClicked(btnInternetRobi6);
        CallButtonClicked(btnInternetRobi7);
        CallButtonClicked(btnInternetRobi8);
        CallButtonClicked(btnInternetRobi9);
        CallButtonClicked(btnInternetRobi10);
        CallButtonClicked(btnInternetRobi11);

    }


    public void Initialization(){
        btnInternetRobi1 = (ButtonAwesome) findViewById(R.id.btnInternetRobi1);
        btnInternetRobi1 = (ButtonAwesome) findViewById(R.id.btnInternetRobi1);
        btnInternetRobi2 = (ButtonAwesome) findViewById(R.id.btnInternetRobi2);
        btnInternetRobi3 = (ButtonAwesome) findViewById(R.id.btnInternetRobi3);
        btnInternetRobi4 = (ButtonAwesome) findViewById(R.id.btnInternetRobi4);
        btnInternetRobi5 = (ButtonAwesome) findViewById(R.id.btnInternetRobi5);
        btnInternetRobi6 = (ButtonAwesome) findViewById(R.id.btnInternetRobi6);
        btnInternetRobi7 = (ButtonAwesome) findViewById(R.id.btnInternetRobi7);
        btnInternetRobi8 = (ButtonAwesome) findViewById(R.id.btnInternetRobi8);
        btnInternetRobi9 = (ButtonAwesome) findViewById(R.id.btnInternetRobi9);
        btnInternetRobi10 = (ButtonAwesome) findViewById(R.id.btnInternetRobi10);
        btnInternetRobi11 = (ButtonAwesome) findViewById(R.id.btnInternetRobi11);
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
