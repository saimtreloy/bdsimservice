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

public class InternetBl extends AppCompatActivity {

    ButtonAwesome btnInternetBl0, btnInternetBl1, btnInternetBl2, btnInternetBl3, btnInternetBl4, btnInternetBl5, btnInternetBl6, btnInternetBl7, btnInternetBl8,
            btnInternetBl9, btnInternetBl10, btnInternetBl11, btnInternetBl12, btnInternetBl13, btnInternetBl14, btnInternetBl15, btnInternetBl16,
            btnInternetBl17, btnInternetBl18, btnInternetBl19, btnInternetBl20, btnInternetBl21, btnInternetBl22, btnInternetBl23, btnInternetBl24,
            btnInternetBl25, btnInternetBl26, btnInternetBl27, btnInternetBl28, btnInternetBl29, btnInternetBl30, btnInternetBl31, btnInternetBl32,
            btnInternetBl33, btnInternetBl34, btnInternetBl35, btnInternetBl36, btnInternetBl37, btnInternetBl38, btnInternetBl39, btnInternetBl40,
            btnInternetBl41, btnInternetBl42, btnInternetBl43;

    private final int REQUEST_CODE_CALL = 1;
    public int ButtonClickedChecked;
    String phoneNumber = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.ThemeBl);
        setContentView(R.layout.internet_bl);
        setTitle("Banglalink Internet Packages");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_appbar_banglalink);

        Initialization();

        btnInternetBl0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InternetBl.this, Browser.class);
                intent.putExtra("url", "http://www.banglalink.com.bd/en/services/banglalink-internet/packages/");
                startActivity(intent);
            }
        });

        CallButtonClicked(btnInternetBl1);
        CallButtonClicked(btnInternetBl2);
        CallButtonClicked(btnInternetBl3);
        CallButtonClicked(btnInternetBl4);
        CallButtonClicked(btnInternetBl5);
        CallButtonClicked(btnInternetBl6);
        CallButtonClicked(btnInternetBl7);
        CallButtonClicked(btnInternetBl8);
        CallButtonClicked(btnInternetBl9);
        CallButtonClicked(btnInternetBl10);
        CallButtonClicked(btnInternetBl11);
        CallButtonClicked(btnInternetBl12);
        CallButtonClicked(btnInternetBl13);
        CallButtonClicked(btnInternetBl14);
        CallButtonClicked(btnInternetBl15);
        CallButtonClicked(btnInternetBl16);
        CallButtonClicked(btnInternetBl17);
        CallButtonClicked(btnInternetBl18);
        CallButtonClicked(btnInternetBl19);
        CallButtonClicked(btnInternetBl20);
        CallButtonClicked(btnInternetBl21);
        CallButtonClicked(btnInternetBl22);
        CallButtonClicked(btnInternetBl23);
        CallButtonClicked(btnInternetBl24);
        CallButtonClicked(btnInternetBl25);
        CallButtonClicked(btnInternetBl26);
        CallButtonClicked(btnInternetBl27);
        CallButtonClicked(btnInternetBl28);
        CallButtonClicked(btnInternetBl29);
        CallButtonClicked(btnInternetBl30);
        CallButtonClicked(btnInternetBl31);
        CallButtonClicked(btnInternetBl32);
        CallButtonClicked(btnInternetBl33);
        CallButtonClicked(btnInternetBl34);
        CallButtonClicked(btnInternetBl35);
        CallButtonClicked(btnInternetBl36);
        CallButtonClicked(btnInternetBl37);
        CallButtonClicked(btnInternetBl38);
        CallButtonClicked(btnInternetBl39);
        CallButtonClicked(btnInternetBl40);
        CallButtonClicked(btnInternetBl41);
        CallButtonClicked(btnInternetBl42);
        CallButtonClicked(btnInternetBl43);

    }


    public void Initialization(){
        btnInternetBl0 = (ButtonAwesome) findViewById(R.id.btnInternetBl0);
        btnInternetBl1 = (ButtonAwesome) findViewById(R.id.btnInternetBl1);
        btnInternetBl2 = (ButtonAwesome) findViewById(R.id.btnInternetBl2);
        btnInternetBl3 = (ButtonAwesome) findViewById(R.id.btnInternetBl3);
        btnInternetBl4 = (ButtonAwesome) findViewById(R.id.btnInternetBl4);
        btnInternetBl5 = (ButtonAwesome) findViewById(R.id.btnInternetBl5);
        btnInternetBl6 = (ButtonAwesome) findViewById(R.id.btnInternetBl6);
        btnInternetBl7 = (ButtonAwesome) findViewById(R.id.btnInternetBl7);
        btnInternetBl8 = (ButtonAwesome) findViewById(R.id.btnInternetBl8);
        btnInternetBl9 = (ButtonAwesome) findViewById(R.id.btnInternetBl9);
        btnInternetBl10 = (ButtonAwesome) findViewById(R.id.btnInternetBl10);
        btnInternetBl11 = (ButtonAwesome) findViewById(R.id.btnInternetBl11);
        btnInternetBl12 = (ButtonAwesome) findViewById(R.id.btnInternetBl12);
        btnInternetBl13 = (ButtonAwesome) findViewById(R.id.btnInternetBl13);
        btnInternetBl14 = (ButtonAwesome) findViewById(R.id.btnInternetBl14);
        btnInternetBl15 = (ButtonAwesome) findViewById(R.id.btnInternetBl15);
        btnInternetBl16 = (ButtonAwesome) findViewById(R.id.btnInternetBl16);
        btnInternetBl17 = (ButtonAwesome) findViewById(R.id.btnInternetBl17);
        btnInternetBl18 = (ButtonAwesome) findViewById(R.id.btnInternetBl18);
        btnInternetBl19 = (ButtonAwesome) findViewById(R.id.btnInternetBl19);
        btnInternetBl20 = (ButtonAwesome) findViewById(R.id.btnInternetBl20);
        btnInternetBl21 = (ButtonAwesome) findViewById(R.id.btnInternetBl21);
        btnInternetBl22 = (ButtonAwesome) findViewById(R.id.btnInternetBl22);
        btnInternetBl23 = (ButtonAwesome) findViewById(R.id.btnInternetBl23);
        btnInternetBl24 = (ButtonAwesome) findViewById(R.id.btnInternetBl24);
        btnInternetBl25 = (ButtonAwesome) findViewById(R.id.btnInternetBl25);
        btnInternetBl26 = (ButtonAwesome) findViewById(R.id.btnInternetBl26);
        btnInternetBl27 = (ButtonAwesome) findViewById(R.id.btnInternetBl27);
        btnInternetBl28 = (ButtonAwesome) findViewById(R.id.btnInternetBl28);
        btnInternetBl29 = (ButtonAwesome) findViewById(R.id.btnInternetBl29);
        btnInternetBl30 = (ButtonAwesome) findViewById(R.id.btnInternetBl30);
        btnInternetBl31 = (ButtonAwesome) findViewById(R.id.btnInternetBl31);
        btnInternetBl32 = (ButtonAwesome) findViewById(R.id.btnInternetBl32);
        btnInternetBl33 = (ButtonAwesome) findViewById(R.id.btnInternetBl33);
        btnInternetBl34 = (ButtonAwesome) findViewById(R.id.btnInternetBl34);
        btnInternetBl35 = (ButtonAwesome) findViewById(R.id.btnInternetBl35);
        btnInternetBl36 = (ButtonAwesome) findViewById(R.id.btnInternetBl36);
        btnInternetBl37 = (ButtonAwesome) findViewById(R.id.btnInternetBl37);
        btnInternetBl38 = (ButtonAwesome) findViewById(R.id.btnInternetBl38);
        btnInternetBl39 = (ButtonAwesome) findViewById(R.id.btnInternetBl39);
        btnInternetBl40 = (ButtonAwesome) findViewById(R.id.btnInternetBl40);
        btnInternetBl41 = (ButtonAwesome) findViewById(R.id.btnInternetBl41);
        btnInternetBl42 = (ButtonAwesome) findViewById(R.id.btnInternetBl42);
        btnInternetBl43 = (ButtonAwesome) findViewById(R.id.btnInternetBl43);
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
