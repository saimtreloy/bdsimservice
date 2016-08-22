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
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class BundleRobi extends AppCompatActivity {

    ButtonAwesome btnBundleRb0, btnBundleRb1, btnBundleRb2, btnBundleRb3, btnBundleRb4, btnBundleRb5, btnBundleRb6, btnBundleRb7, btnBundleRb8,
            btnBundleRb9, btnBundleRb10, btnBundleRb11, btnBundleRb12, btnBundleRb13, btnBundleRb14, btnBundleRb15, btnBundleRb16,
            btnBundleRb17, btnBundleRb18, btnBundleRb19;

    private final int REQUEST_CODE_CALL = 1;
    public int ButtonClickedChecked;
    String phoneNumber = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.ThemeAirtel);
        setContentView(R.layout.bundle_robi);
        setTitle("Robi Bundle Offer");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_appbar_robi);

        Initialization();
        btnBundleRb0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BundleRobi.this, Browser.class);
                intent.putExtra("url", "http://www.robi.com.bd/current-offers");
                startActivity(intent);
            }
        });

        CallButtonClicked(btnBundleRb1);
        CallButtonClicked(btnBundleRb2);
        CallButtonClicked(btnBundleRb3);
        CallButtonClicked(btnBundleRb4);
        CallButtonClicked(btnBundleRb5);
        CallButtonClicked(btnBundleRb6);
        CallButtonClicked(btnBundleRb7);
        CallButtonClicked(btnBundleRb8);
        CallButtonClicked(btnBundleRb9);
        CallButtonClicked(btnBundleRb10);
        CallButtonClicked(btnBundleRb11);
        CallButtonClicked(btnBundleRb12);
        CallButtonClicked(btnBundleRb13);
        CallButtonClicked(btnBundleRb14);
        CallButtonClicked(btnBundleRb15);
        CallButtonClicked(btnBundleRb16);
        CallButtonClicked(btnBundleRb17);
        CallButtonClicked(btnBundleRb18);
        CallButtonClicked(btnBundleRb19);
    }

    public void Initialization() {
        btnBundleRb0 = (ButtonAwesome) findViewById(R.id.btnBundleRb0);
        btnBundleRb1 = (ButtonAwesome) findViewById(R.id.btnBundleRb1);
        btnBundleRb2 = (ButtonAwesome) findViewById(R.id.btnBundleRb2);
        btnBundleRb3 = (ButtonAwesome) findViewById(R.id.btnBundleRb3);
        btnBundleRb4 = (ButtonAwesome) findViewById(R.id.btnBundleRb4);
        btnBundleRb5 = (ButtonAwesome) findViewById(R.id.btnBundleRb5);
        btnBundleRb6 = (ButtonAwesome) findViewById(R.id.btnBundleRb6);
        btnBundleRb7 = (ButtonAwesome) findViewById(R.id.btnBundleRb7);
        btnBundleRb8 = (ButtonAwesome) findViewById(R.id.btnBundleRb8);
        btnBundleRb9 = (ButtonAwesome) findViewById(R.id.btnBundleRb9);
        btnBundleRb10 = (ButtonAwesome) findViewById(R.id.btnBundleRb10);
        btnBundleRb11 = (ButtonAwesome) findViewById(R.id.btnBundleRb11);
        btnBundleRb12 = (ButtonAwesome) findViewById(R.id.btnBundleRb12);
        btnBundleRb13 = (ButtonAwesome) findViewById(R.id.btnBundleRb13);
        btnBundleRb14 = (ButtonAwesome) findViewById(R.id.btnBundleRb14);
        btnBundleRb15 = (ButtonAwesome) findViewById(R.id.btnBundleRb15);
        btnBundleRb16 = (ButtonAwesome) findViewById(R.id.btnBundleRb16);
        btnBundleRb17 = (ButtonAwesome) findViewById(R.id.btnBundleRb17);
        btnBundleRb18 = (ButtonAwesome) findViewById(R.id.btnBundleRb18);
        btnBundleRb19 = (ButtonAwesome) findViewById(R.id.btnBundleRb19);
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


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.btnDeveloper){
            Intent intent = new Intent(BundleRobi.this, Developer.class);
            startActivity(intent);
            finish();
        }else if (item.getItemId() == android.R.id.home){
            Intent intent = new Intent(BundleRobi.this, MainMenu.class);
            startActivity(intent);
            finish();
        }

        return true;
    }

}
