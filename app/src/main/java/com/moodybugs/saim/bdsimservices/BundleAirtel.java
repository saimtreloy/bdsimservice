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

public class BundleAirtel extends AppCompatActivity {

    ButtonAwesome btnBundleAr0, btnBundleAr1, btnBundleAr2, btnBundleAr3, btnBundleAr4, btnBundleAr5, btnBundleAr6, btnBundleAr7, btnBundleAr8,
            btnBundleAr9, btnBundleAr10, btnBundleAr11, btnBundleAr12, btnBundleAr13, btnBundleAr14, btnBundleAr15, btnBundleAr16,
            btnBundleAr17, btnBundleAr18, btnBundleAr19, btnBundleAr20, btnBundleAr21, btnBundleAr22, btnBundleAr23, btnBundleAr24,
            btnBundleAr25, btnBundleAr26, btnBundleAr27, btnBundleAr28, btnBundleAr29, btnBundleAr30, btnBundleAr31, btnBundleAr32,
            btnBundleAr33;
    
    private final int REQUEST_CODE_CALL = 1;
    public int ButtonClickedChecked;
    String phoneNumber = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.ThemeAirtel);
        setContentView(R.layout.bundle_airtel);
        setTitle("Airtel Bundle Offer");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_appbar_airtel);

        Initialization();

        btnBundleAr0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BundleAirtel.this, Browser.class);
                intent.putExtra("url", "http://www.bd.airtel.com/personal/products-services/prepaid/packages-recharge/bundle-offers");
                startActivity(intent);
            }
        });

        CallButtonClicked(btnBundleAr1);
        CallButtonClicked(btnBundleAr2);
        CallButtonClicked(btnBundleAr3);
        CallButtonClicked(btnBundleAr4);
        CallButtonClicked(btnBundleAr5);
        CallButtonClicked(btnBundleAr6);
        CallButtonClicked(btnBundleAr7);
        CallButtonClicked(btnBundleAr8);
        CallButtonClicked(btnBundleAr9);
        CallButtonClicked(btnBundleAr10);
        CallButtonClicked(btnBundleAr11);
        CallButtonClicked(btnBundleAr12);
        CallButtonClicked(btnBundleAr13);
        CallButtonClicked(btnBundleAr14);
        CallButtonClicked(btnBundleAr15);
        CallButtonClicked(btnBundleAr16);
        CallButtonClicked(btnBundleAr17);
        CallButtonClicked(btnBundleAr18);
        CallButtonClicked(btnBundleAr19);
        CallButtonClicked(btnBundleAr20);
        CallButtonClicked(btnBundleAr21);
        CallButtonClicked(btnBundleAr22);
        CallButtonClicked(btnBundleAr23);
        CallButtonClicked(btnBundleAr24);
        CallButtonClicked(btnBundleAr25);
        CallButtonClicked(btnBundleAr26);
        CallButtonClicked(btnBundleAr27);
        CallButtonClicked(btnBundleAr28);
        CallButtonClicked(btnBundleAr29);
        CallButtonClicked(btnBundleAr30);
        CallButtonClicked(btnBundleAr31);
        CallButtonClicked(btnBundleAr32);
        CallButtonClicked(btnBundleAr33);
    }


    public void Initialization(){
        btnBundleAr0 = (ButtonAwesome) findViewById(R.id.btnBundleAr0);
        btnBundleAr1 = (ButtonAwesome) findViewById(R.id.btnBundleAr1);
        btnBundleAr2 = (ButtonAwesome) findViewById(R.id.btnBundleAr2);
        btnBundleAr3 = (ButtonAwesome) findViewById(R.id.btnBundleAr3);
        btnBundleAr4 = (ButtonAwesome) findViewById(R.id.btnBundleAr4);
        btnBundleAr5 = (ButtonAwesome) findViewById(R.id.btnBundleAr5);
        btnBundleAr6 = (ButtonAwesome) findViewById(R.id.btnBundleAr6);
        btnBundleAr7 = (ButtonAwesome) findViewById(R.id.btnBundleAr7);
        btnBundleAr8 = (ButtonAwesome) findViewById(R.id.btnBundleAr8);
        btnBundleAr9 = (ButtonAwesome) findViewById(R.id.btnBundleAr9);
        btnBundleAr10 = (ButtonAwesome) findViewById(R.id.btnBundleAr10);
        btnBundleAr11 = (ButtonAwesome) findViewById(R.id.btnBundleAr11);
        btnBundleAr12 = (ButtonAwesome) findViewById(R.id.btnBundleAr12);
        btnBundleAr13 = (ButtonAwesome) findViewById(R.id.btnBundleAr13);
        btnBundleAr14 = (ButtonAwesome) findViewById(R.id.btnBundleAr14);
        btnBundleAr15 = (ButtonAwesome) findViewById(R.id.btnBundleAr15);
        btnBundleAr16 = (ButtonAwesome) findViewById(R.id.btnBundleAr16);
        btnBundleAr17 = (ButtonAwesome) findViewById(R.id.btnBundleAr17);
        btnBundleAr18 = (ButtonAwesome) findViewById(R.id.btnBundleAr18);
        btnBundleAr19 = (ButtonAwesome) findViewById(R.id.btnBundleAr19);
        btnBundleAr20 = (ButtonAwesome) findViewById(R.id.btnBundleAr20);
        btnBundleAr21 = (ButtonAwesome) findViewById(R.id.btnBundleAr21);
        btnBundleAr22 = (ButtonAwesome) findViewById(R.id.btnBundleAr22);
        btnBundleAr23 = (ButtonAwesome) findViewById(R.id.btnBundleAr23);
        btnBundleAr24 = (ButtonAwesome) findViewById(R.id.btnBundleAr24);
        btnBundleAr25 = (ButtonAwesome) findViewById(R.id.btnBundleAr25);
        btnBundleAr26 = (ButtonAwesome) findViewById(R.id.btnBundleAr26);
        btnBundleAr27 = (ButtonAwesome) findViewById(R.id.btnBundleAr27);
        btnBundleAr28 = (ButtonAwesome) findViewById(R.id.btnBundleAr28);
        btnBundleAr29 = (ButtonAwesome) findViewById(R.id.btnBundleAr29);
        btnBundleAr30 = (ButtonAwesome) findViewById(R.id.btnBundleAr30);
        btnBundleAr31 = (ButtonAwesome) findViewById(R.id.btnBundleAr31);
        btnBundleAr32 = (ButtonAwesome) findViewById(R.id.btnBundleAr32);
        btnBundleAr33 = (ButtonAwesome) findViewById(R.id.btnBundleAr33);
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
            Intent intent = new Intent(BundleAirtel.this, Developer.class);
            startActivity(intent);
            finish();
        }else if (item.getItemId() == android.R.id.home){
            Intent intent = new Intent(BundleAirtel.this, MainMenu.class);
            startActivity(intent);
            finish();
        }

        return true;
    }
}
