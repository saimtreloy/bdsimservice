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

public class UssdGp extends AppCompatActivity {

    ButtonAwesome btnUSSDGp1, btnUSSDGp2, btnUSSDGp3, btnUSSDGp4, btnUSSDGp5, btnUSSDGp6, btnUSSDGp7, btnUSSDGp8,
            btnUSSDGp9, btnUSSDGp10, btnUSSDGp11, btnUSSDGp12, btnUSSDGp13, btnUSSDGp14, btnUSSDGp15, btnUSSDGp16, btnUSSDGp17,
            btnUSSDGp18, btnUSSDGp19;
    
    private final int REQUEST_CODE_CALL = 1;
    public int ButtonClickedChecked;
    String phoneNumber = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.ThemeGp);
        setContentView(R.layout.ussd_gp);
        setTitle("GP Important USSD");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_appbar_gp);

        Initialization();

        CallButtonClicked(btnUSSDGp1);
        CallButtonClicked(btnUSSDGp2);
        CallButtonClicked(btnUSSDGp3);
        CallButtonClicked(btnUSSDGp4);
        CallButtonClicked(btnUSSDGp5);
        CallButtonClicked(btnUSSDGp6);
        CallButtonClicked(btnUSSDGp7);
        CallButtonClicked(btnUSSDGp8);
        CallButtonClicked(btnUSSDGp9);
        CallButtonClicked(btnUSSDGp10);
        CallButtonClicked(btnUSSDGp11);
        CallButtonClicked(btnUSSDGp12);
        CallButtonClicked(btnUSSDGp13);
        CallButtonClicked(btnUSSDGp14);
        CallButtonClicked(btnUSSDGp15);
        CallButtonClicked(btnUSSDGp16);
        CallButtonClicked(btnUSSDGp17);
        CallButtonClicked(btnUSSDGp18);
        CallButtonClicked(btnUSSDGp19);
    }


    public void Initialization(){
        btnUSSDGp1 = (ButtonAwesome) findViewById(R.id.btnUSSDGp1);
        btnUSSDGp2 = (ButtonAwesome) findViewById(R.id.btnUSSDGp2);
        btnUSSDGp3 = (ButtonAwesome) findViewById(R.id.btnUSSDGp3);
        btnUSSDGp4 = (ButtonAwesome) findViewById(R.id.btnUSSDGp4);
        btnUSSDGp5 = (ButtonAwesome) findViewById(R.id.btnUSSDGp5);
        btnUSSDGp6 = (ButtonAwesome) findViewById(R.id.btnUSSDGp6);
        btnUSSDGp7 = (ButtonAwesome) findViewById(R.id.btnUSSDGp7);
        btnUSSDGp8 = (ButtonAwesome) findViewById(R.id.btnUSSDGp8);
        btnUSSDGp9 = (ButtonAwesome) findViewById(R.id.btnUSSDGp9);
        btnUSSDGp10 = (ButtonAwesome) findViewById(R.id.btnUSSDGp10);
        btnUSSDGp11 = (ButtonAwesome) findViewById(R.id.btnUSSDGp11);
        btnUSSDGp12 = (ButtonAwesome) findViewById(R.id.btnUSSDGp12);
        btnUSSDGp13 = (ButtonAwesome) findViewById(R.id.btnUSSDGp13);
        btnUSSDGp14 = (ButtonAwesome) findViewById(R.id.btnUSSDGp14);
        btnUSSDGp15 = (ButtonAwesome) findViewById(R.id.btnUSSDGp15);
        btnUSSDGp16 = (ButtonAwesome) findViewById(R.id.btnUSSDGp16);
        btnUSSDGp17 = (ButtonAwesome) findViewById(R.id.btnUSSDGp17);
        btnUSSDGp18 = (ButtonAwesome) findViewById(R.id.btnUSSDGp18);
        btnUSSDGp19 = (ButtonAwesome) findViewById(R.id.btnUSSDGp19);
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
                //phoneNumber = bNumber.substring(0, bNumber.indexOf("#")) + Uri.encode("#");
                phoneNumber = Uri.encode(bNumber);
                Log.d("Saim Check :", phoneNumber);
                runtimePermission();
                Toast.makeText(getApplicationContext(), "Your request has been processed", Toast.LENGTH_LONG).show();
            }
        });
    }
}
