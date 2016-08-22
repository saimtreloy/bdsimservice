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

public class InternetGp extends AppCompatActivity {

    ButtonAwesome btnInternetGp0, btnInternetGp1, btnInternetGp2, btnInternetGp3, btnInternetGp4, btnInternetGp5, btnInternetGp6, btnInternetGp7, btnInternetGp8,
            btnInternetGp9, btnInternetGp10, btnInternetGp11, btnInternetGp12, btnInternetGp13, btnInternetGp14, btnInternetGp15, btnInternetGp16,
            btnInternetGp17, btnInternetGp18;
    ButtonAwesome btnInternetAutoTurnOnGp, btnInternetAutoTurnOffGp, btnInternetPackageStopGp, btnInternetGetSettingGp;

    private final int REQUEST_CODE_CALL = 1;
    public int ButtonClickedChecked;
    String phoneNumber = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.ThemeGp);
        setContentView(R.layout.internet_gp);
        setTitle("GP Internet Packages");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_appbar_gp);

        Initialization();

        btnInternetGp0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InternetGp.this, Browser.class);
                intent.putExtra("url", "http://www.grameenphone.com/personal/internet/packages");
                startActivity(intent);
            }
        });

        CallButtonClicked(btnInternetGp1);
        CallButtonClicked(btnInternetGp2);
        CallButtonClicked(btnInternetGp3);
        CallButtonClicked(btnInternetGp4);
        CallButtonClicked(btnInternetGp5);
        CallButtonClicked(btnInternetGp6);
        CallButtonClicked(btnInternetGp7);
        CallButtonClicked(btnInternetGp8);
        CallButtonClicked(btnInternetGp9);
        CallButtonClicked(btnInternetGp10);
        CallButtonClicked(btnInternetGp11);
        CallButtonClicked(btnInternetGp12);
        CallButtonClicked(btnInternetGp13);
        CallButtonClicked(btnInternetGp14);
        CallButtonClicked(btnInternetGp15);
        CallButtonClicked(btnInternetGp16);
        CallButtonClicked(btnInternetGp17);
        CallButtonClicked(btnInternetGp18);

        CallButtonClicked(btnInternetAutoTurnOnGp);
        CallButtonClicked(btnInternetAutoTurnOffGp);
        CallButtonClicked(btnInternetPackageStopGp);
        CallButtonClicked(btnInternetGetSettingGp);
    }


    public void Initialization() {
        btnInternetGp0 = (ButtonAwesome) findViewById(R.id.btnInternetGp0);
        btnInternetGp1 = (ButtonAwesome) findViewById(R.id.btnInternetGp1);
        btnInternetGp2 = (ButtonAwesome) findViewById(R.id.btnInternetGp2);
        btnInternetGp3 = (ButtonAwesome) findViewById(R.id.btnInternetGp3);
        btnInternetGp4 = (ButtonAwesome) findViewById(R.id.btnInternetGp4);
        btnInternetGp5 = (ButtonAwesome) findViewById(R.id.btnInternetGp5);
        btnInternetGp6 = (ButtonAwesome) findViewById(R.id.btnInternetGp6);
        btnInternetGp7 = (ButtonAwesome) findViewById(R.id.btnInternetGp7);
        btnInternetGp8 = (ButtonAwesome) findViewById(R.id.btnInternetGp8);
        btnInternetGp9 = (ButtonAwesome) findViewById(R.id.btnInternetGp9);
        btnInternetGp10 = (ButtonAwesome) findViewById(R.id.btnInternetGp10);
        btnInternetGp11 = (ButtonAwesome) findViewById(R.id.btnInternetGp11);
        btnInternetGp12 = (ButtonAwesome) findViewById(R.id.btnInternetGp12);
        btnInternetGp13 = (ButtonAwesome) findViewById(R.id.btnInternetGp13);
        btnInternetGp14 = (ButtonAwesome) findViewById(R.id.btnInternetGp14);
        btnInternetGp15 = (ButtonAwesome) findViewById(R.id.btnInternetGp15);
        btnInternetGp16 = (ButtonAwesome) findViewById(R.id.btnInternetGp16);
        btnInternetGp17 = (ButtonAwesome) findViewById(R.id.btnInternetGp17);
        btnInternetGp18 = (ButtonAwesome) findViewById(R.id.btnInternetGp18);

        btnInternetAutoTurnOnGp = (ButtonAwesome) findViewById(R.id.btnInternetAutoTurnOnGp);
        btnInternetAutoTurnOffGp = (ButtonAwesome) findViewById(R.id.btnInternetAutoTurnOffGp);
        btnInternetPackageStopGp = (ButtonAwesome) findViewById(R.id.btnInternetPackageStopGp);
        btnInternetGetSettingGp = (ButtonAwesome) findViewById(R.id.btnInternetGetSettingGp);
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
                phoneNumber = bNumber.substring(0, bNumber.indexOf("#"))+ Uri.encode("#");
                Log.d("Saim Check :", phoneNumber);
                runtimePermission();
                Toast.makeText(getApplicationContext(), "Your request has been processed", Toast.LENGTH_LONG).show();
            }
        });
    }
}
