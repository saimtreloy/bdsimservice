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

public class BundleBl extends AppCompatActivity {

    ButtonAwesome btnBundleBl0, btnBundleBl1, btnBundleBl2, btnBundleBl3, btnBundleBl4, btnBundleBl5, btnBundleBl6, btnBundleBl7, btnBundleBl8;

    private final int REQUEST_CODE_CALL = 1;
    public int ButtonClickedChecked;
    String phoneNumber = null;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.ThemeBl);
        setContentView(R.layout.bundle_bl);
        setTitle("Bl Bundle Offer");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_appbar_banglalink);

        Initialization();

        btnBundleBl0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BundleBl.this, Browser.class);
                intent.putExtra("url", "http://www.banglalink.com.bd/en/services/services/my-banglalink-plan/");
                startActivity(intent);
            }
        });

        CallButtonClicked(btnBundleBl1);
        CallButtonClicked(btnBundleBl2);
        CallButtonClicked(btnBundleBl3);
        CallButtonClicked(btnBundleBl4);
        CallButtonClicked(btnBundleBl5);
        CallButtonClicked(btnBundleBl6);
        CallButtonClicked(btnBundleBl7);
        CallButtonClicked(btnBundleBl8);
        
    }


    public void Initialization(){
        btnBundleBl0 = (ButtonAwesome) findViewById(R.id.btnBundleBl0);
        btnBundleBl1 = (ButtonAwesome) findViewById(R.id.btnBundleBl1);
        btnBundleBl2 = (ButtonAwesome) findViewById(R.id.btnBundleBl2);
        btnBundleBl3 = (ButtonAwesome) findViewById(R.id.btnBundleBl3);
        btnBundleBl4 = (ButtonAwesome) findViewById(R.id.btnBundleBl4);
        btnBundleBl5 = (ButtonAwesome) findViewById(R.id.btnBundleBl5);
        btnBundleBl6 = (ButtonAwesome) findViewById(R.id.btnBundleBl6);
        btnBundleBl7 = (ButtonAwesome) findViewById(R.id.btnBundleBl7);
        btnBundleBl8 = (ButtonAwesome) findViewById(R.id.btnBundleBl8);
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
            Intent intent = new Intent(BundleBl.this, Developer.class);
            startActivity(intent);
            finish();
        }else if (item.getItemId() == android.R.id.home){
            Intent intent = new Intent(BundleBl.this, MainMenu.class);
            startActivity(intent);
            finish();
        }

        return true;
    }

}
