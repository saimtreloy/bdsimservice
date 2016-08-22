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

public class BundleGp extends AppCompatActivity {

    ButtonAwesome btnBundleGp0, btnBundleGp1, btnBundleGp2, btnBundleGp3, btnBundleGp4, btnBundleGp5, btnBundleGp6, btnBundleGp7, btnBundleGp8,
            btnBundleGp9, btnBundleGp10, btnBundleGp11, btnBundleGp12, btnBundleGp13, btnBundleGp14, btnBundleGp15, btnBundleGp16, btnBundleGp17,
            btnBundleGp18, btnBundleGp19, btnBundleGp20, btnBundleGp21, btnBundleGp22;

    private final int REQUEST_CODE_CALL = 1;
    public int ButtonClickedChecked;
    String phoneNumber = null;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.ThemeGp);
        setContentView(R.layout.bundle_gp);
        setTitle("GP Bundle Offer");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_appbar_gp);

        Initialization();

        btnBundleGp0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BundleGp.this, Browser.class);
                intent.putExtra("url", "http://www.grameenphone.com/personal/offers");
                startActivity(intent);
            }
        });

        CallButtonClicked(btnBundleGp1);
        CallButtonClicked(btnBundleGp2);
        CallButtonClicked(btnBundleGp3);
        CallButtonClicked(btnBundleGp4);
        CallButtonClicked(btnBundleGp5);
        CallButtonClicked(btnBundleGp6);
        CallButtonClicked(btnBundleGp7);
        CallButtonClicked(btnBundleGp8);
        CallButtonClicked(btnBundleGp9);
        CallButtonClicked(btnBundleGp10);
        CallButtonClicked(btnBundleGp11);
        CallButtonClicked(btnBundleGp12);
        CallButtonClicked(btnBundleGp13);
        CallButtonClicked(btnBundleGp14);
        CallButtonClicked(btnBundleGp15);
        CallButtonClicked(btnBundleGp16);
        CallButtonClicked(btnBundleGp17);
        CallButtonClicked(btnBundleGp18);
        CallButtonClicked(btnBundleGp19);
        CallButtonClicked(btnBundleGp20);
        CallButtonClicked(btnBundleGp21);
        CallButtonClicked(btnBundleGp22);
    }

    public void Initialization(){
        btnBundleGp0 = (ButtonAwesome) findViewById(R.id.btnBundleGp0);
        btnBundleGp1 = (ButtonAwesome) findViewById(R.id.btnBundleGp1);
        btnBundleGp2 = (ButtonAwesome) findViewById(R.id.btnBundleGp2);
        btnBundleGp3 = (ButtonAwesome) findViewById(R.id.btnBundleGp3);
        btnBundleGp4 = (ButtonAwesome) findViewById(R.id.btnBundleGp4);
        btnBundleGp5 = (ButtonAwesome) findViewById(R.id.btnBundleGp5);
        btnBundleGp6 = (ButtonAwesome) findViewById(R.id.btnBundleGp6);
        btnBundleGp7 = (ButtonAwesome) findViewById(R.id.btnBundleGp7);
        btnBundleGp8 = (ButtonAwesome) findViewById(R.id.btnBundleGp8);
        btnBundleGp9 = (ButtonAwesome) findViewById(R.id.btnBundleGp9);
        btnBundleGp10 = (ButtonAwesome) findViewById(R.id.btnBundleGp10);
        btnBundleGp11 = (ButtonAwesome) findViewById(R.id.btnBundleGp11);
        btnBundleGp12 = (ButtonAwesome) findViewById(R.id.btnBundleGp12);
        btnBundleGp13 = (ButtonAwesome) findViewById(R.id.btnBundleGp13);
        btnBundleGp14 = (ButtonAwesome) findViewById(R.id.btnBundleGp14);
        btnBundleGp15 = (ButtonAwesome) findViewById(R.id.btnBundleGp15);
        btnBundleGp16 = (ButtonAwesome) findViewById(R.id.btnBundleGp16);
        btnBundleGp17 = (ButtonAwesome) findViewById(R.id.btnBundleGp17);
        btnBundleGp18 = (ButtonAwesome) findViewById(R.id.btnBundleGp18);
        btnBundleGp19 = (ButtonAwesome) findViewById(R.id.btnBundleGp19);
        btnBundleGp20 = (ButtonAwesome) findViewById(R.id.btnBundleGp20);
        btnBundleGp21 = (ButtonAwesome) findViewById(R.id.btnBundleGp21);
        btnBundleGp22 = (ButtonAwesome) findViewById(R.id.btnBundleGp22);
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
                String bNumber = buttonAwesome.getHint().toString();
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
            Intent intent = new Intent(BundleGp.this, Developer.class);
            startActivity(intent);
            finish();
        }else if (item.getItemId() == android.R.id.home){
            Intent intent = new Intent(BundleGp.this, MainMenu.class);
            startActivity(intent);
            finish();
        }

        return true;
    }
}
