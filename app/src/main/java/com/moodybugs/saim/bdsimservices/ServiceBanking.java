package com.moodybugs.saim.bdsimservices;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.beardedhen.androidbootstrap.TypefaceProvider;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class ServiceBanking extends AppCompatActivity {
    Toolbar app_bar;

    private AdView mAdView;
    private final int REQUEST_CODE = 1;
    String phoneNumber = "01711415554";

    LinearLayout layoutMobileBankingBkash, layoutMobileBankingDBBL, layoutMobileBankingMCash, layoutMobileBankingMyCash,
            layoutMobileBankingOk, layoutMobileBankingUCash,layoutMobileBankingSureCash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.service_banking);
        Initialization();
        ButtonClicked(layoutMobileBankingBkash, "*247" + Uri.encode("#"));
        ButtonClicked(layoutMobileBankingDBBL, "*322"+Uri.encode("#"));
        ButtonClicked(layoutMobileBankingMCash, "*259"+Uri.encode("#"));
        ButtonClicked(layoutMobileBankingMyCash, "*225"+Uri.encode("#"));
        ButtonClicked(layoutMobileBankingOk, "*269"+Uri.encode("#"));
        ButtonClicked(layoutMobileBankingUCash, "*268"+Uri.encode("#"));
        ButtonClicked(layoutMobileBankingSureCash, "*257"+Uri.encode("#"));
    }

    public void Initialization() {
        app_bar = (Toolbar) findViewById(R.id.app_bar);
        setTitle("Mobile Banking");
        setSupportActionBar(app_bar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_appbar_banking);
        TypefaceProvider.registerDefaultIconSets();

        mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        layoutMobileBankingBkash = (LinearLayout) findViewById(R.id.layoutMobileBankingBkash);
        layoutMobileBankingDBBL = (LinearLayout) findViewById(R.id.layoutMobileBankingDBBL);
        layoutMobileBankingMCash = (LinearLayout) findViewById(R.id.layoutMobileBankingMCash);
        layoutMobileBankingMyCash = (LinearLayout) findViewById(R.id.layoutMobileBankingMyCash);
        layoutMobileBankingOk = (LinearLayout) findViewById(R.id.layoutMobileBankingOk);
        layoutMobileBankingUCash = (LinearLayout) findViewById(R.id.layoutMobileBankingUCash);
        layoutMobileBankingSureCash = (LinearLayout) findViewById(R.id.layoutMobileBankingSureCash);
    }


    public void ButtonClicked(LinearLayout linearLayout, final String Number){
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                phoneNumber = Number;
                runtimePermission();
                Log.d("Number Checking", phoneNumber);
            }
        });
    }

    public void runtimePermission(){
        if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
            makeCall();
        }else {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                if (shouldShowRequestPermissionRationale(Manifest.permission.CALL_PHONE)){
                    Toast.makeText(getApplicationContext(), "Permission required", Toast.LENGTH_SHORT).show();
                }
                requestPermissions(new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CODE);
            }else{
                makeCall();
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if (requestCode == REQUEST_CODE){
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED){
                makeCall();
            }else {
                Toast.makeText(getApplicationContext(), "Call not processed", Toast.LENGTH_SHORT).show();
            }
        }else {
            super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }

    }

    public void makeCall(){
        Intent callIntent = new Intent(Intent.ACTION_CALL);
        callIntent.setData(Uri.parse("tel:" + phoneNumber));
        callIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(callIntent);
    }
}
