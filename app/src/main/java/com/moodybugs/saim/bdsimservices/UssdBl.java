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

public class UssdBl extends AppCompatActivity {

    ButtonAwesome btnUSSDBl1, btnUSSDBl2, btnUSSDBl3, btnUSSDBl4, btnUSSDBl5, btnUSSDBl6, btnUSSDBl7, btnUSSDBl8,
            btnUSSDBl9, btnUSSDBl10, btnUSSDBl11, btnUSSDBl12, btnUSSDBl13, btnUSSDBl14, btnUSSDBl15, btnUSSDBl16, btnUSSDBl17;
    
    private final int REQUEST_CODE_CALL = 1;
    public int ButtonClickedChecked;
    String phoneNumber = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.ThemeBl);
        setContentView(R.layout.ussd_bl);
        setTitle("Banglalink Important USSD");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_appbar_banglalink);

        Initialization();

        CallButtonClicked(btnUSSDBl1);
        CallButtonClicked(btnUSSDBl2);
        CallButtonClicked(btnUSSDBl3);
        CallButtonClicked(btnUSSDBl4);
        CallButtonClicked(btnUSSDBl5);
        CallButtonClicked(btnUSSDBl6);
        CallButtonClicked(btnUSSDBl7);
        CallButtonClicked(btnUSSDBl8);
        CallButtonClicked(btnUSSDBl9);
        CallButtonClicked(btnUSSDBl10);
        CallButtonClicked(btnUSSDBl11);
        CallButtonClicked(btnUSSDBl12);
        CallButtonClicked(btnUSSDBl13);
        CallButtonClicked(btnUSSDBl14);
        CallButtonClicked(btnUSSDBl15);
        CallButtonClicked(btnUSSDBl16);
        CallButtonClicked(btnUSSDBl17);
    }

    public void Initialization(){
        btnUSSDBl1 = (ButtonAwesome) findViewById(R.id.btnUSSDBl1);
        btnUSSDBl2 = (ButtonAwesome) findViewById(R.id.btnUSSDBl2);
        btnUSSDBl3 = (ButtonAwesome) findViewById(R.id.btnUSSDBl3);
        btnUSSDBl4 = (ButtonAwesome) findViewById(R.id.btnUSSDBl4);
        btnUSSDBl5 = (ButtonAwesome) findViewById(R.id.btnUSSDBl5);
        btnUSSDBl6 = (ButtonAwesome) findViewById(R.id.btnUSSDBl6);
        btnUSSDBl7 = (ButtonAwesome) findViewById(R.id.btnUSSDBl7);
        btnUSSDBl8 = (ButtonAwesome) findViewById(R.id.btnUSSDBl8);
        btnUSSDBl9 = (ButtonAwesome) findViewById(R.id.btnUSSDBl9);
        btnUSSDBl10 = (ButtonAwesome) findViewById(R.id.btnUSSDBl10);
        btnUSSDBl11 = (ButtonAwesome) findViewById(R.id.btnUSSDBl11);
        btnUSSDBl12 = (ButtonAwesome) findViewById(R.id.btnUSSDBl12);
        btnUSSDBl13 = (ButtonAwesome) findViewById(R.id.btnUSSDBl13);
        btnUSSDBl14 = (ButtonAwesome) findViewById(R.id.btnUSSDBl14);
        btnUSSDBl15 = (ButtonAwesome) findViewById(R.id.btnUSSDBl15);
        btnUSSDBl16 = (ButtonAwesome) findViewById(R.id.btnUSSDBl16);
        btnUSSDBl17 = (ButtonAwesome) findViewById(R.id.btnUSSDBl17);
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
                phoneNumber = Uri.encode(bNumber);
                Log.d("Saim Check :", phoneNumber);
                runtimePermission();
                Toast.makeText(getApplicationContext(), "Your request has been processed", Toast.LENGTH_LONG).show();
            }
        });
    }
}
