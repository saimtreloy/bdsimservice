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

public class UssdAirtel extends AppCompatActivity {

    ButtonAwesome btnUSSDAr1, btnUSSDAr2, btnUSSDAr3, btnUSSDAr4, btnUSSDAr5, btnUSSDAr6, btnUSSDAr7, btnUSSDAr8,
            btnUSSDAr9, btnUSSDAr10, btnUSSDAr11, btnUSSDAr12, btnUSSDAr13, btnUSSDAr14, btnUSSDAr15, btnUSSDAr16, btnUSSDAr17;

    private final int REQUEST_CODE_CALL = 1;
    public int ButtonClickedChecked;
    String phoneNumber = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.ThemeAirtel);
        setContentView(R.layout.ussd_airtel);
        setTitle("GP Important USSD");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_appbar_airtel);

        Initialization();

        CallButtonClicked(btnUSSDAr1);
        CallButtonClicked(btnUSSDAr2);
        CallButtonClicked(btnUSSDAr3);
        CallButtonClicked(btnUSSDAr4);
        CallButtonClicked(btnUSSDAr5);
        CallButtonClicked(btnUSSDAr6);
        CallButtonClicked(btnUSSDAr7);
        CallButtonClicked(btnUSSDAr8);
        CallButtonClicked(btnUSSDAr9);
        CallButtonClicked(btnUSSDAr10);
        CallButtonClicked(btnUSSDAr11);
        CallButtonClicked(btnUSSDAr12);
        CallButtonClicked(btnUSSDAr13);
        CallButtonClicked(btnUSSDAr14);
        CallButtonClicked(btnUSSDAr15);
        CallButtonClicked(btnUSSDAr16);
        CallButtonClicked(btnUSSDAr17);
    }


    public void Initialization(){
        btnUSSDAr1 = (ButtonAwesome) findViewById(R.id.btnUSSDAr1);
        btnUSSDAr2 = (ButtonAwesome) findViewById(R.id.btnUSSDAr2);
        btnUSSDAr3 = (ButtonAwesome) findViewById(R.id.btnUSSDAr3);
        btnUSSDAr4 = (ButtonAwesome) findViewById(R.id.btnUSSDAr4);
        btnUSSDAr5 = (ButtonAwesome) findViewById(R.id.btnUSSDAr5);
        btnUSSDAr6 = (ButtonAwesome) findViewById(R.id.btnUSSDAr6);
        btnUSSDAr7 = (ButtonAwesome) findViewById(R.id.btnUSSDAr7);
        btnUSSDAr8 = (ButtonAwesome) findViewById(R.id.btnUSSDAr8);
        btnUSSDAr9 = (ButtonAwesome) findViewById(R.id.btnUSSDAr9);
        btnUSSDAr10 = (ButtonAwesome) findViewById(R.id.btnUSSDAr10);
        btnUSSDAr11 = (ButtonAwesome) findViewById(R.id.btnUSSDAr11);
        btnUSSDAr12 = (ButtonAwesome) findViewById(R.id.btnUSSDAr12);
        btnUSSDAr13 = (ButtonAwesome) findViewById(R.id.btnUSSDAr13);
        btnUSSDAr14 = (ButtonAwesome) findViewById(R.id.btnUSSDAr14);
        btnUSSDAr15 = (ButtonAwesome) findViewById(R.id.btnUSSDAr15);
        btnUSSDAr16 = (ButtonAwesome) findViewById(R.id.btnUSSDAr16);
        btnUSSDAr17 = (ButtonAwesome) findViewById(R.id.btnUSSDAr17);
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
