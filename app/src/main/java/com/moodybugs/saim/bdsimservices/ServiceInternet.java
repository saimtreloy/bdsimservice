package com.moodybugs.saim.bdsimservices;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class ServiceInternet extends AppCompatActivity {
    Toolbar app_bar;
    private AdView mAdView;
    LinearLayout layoutInternetGp, layoutInternetBl, layoutInternetAirtel, layoutInternetRobi, layoutInternetTeletalk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.service_internet);

        Initialization();
        setTitle("Internet Packages");
        setSupportActionBar(app_bar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_appbar_internet);

        ButtonClicked(layoutInternetGp, InternetGp.class);
        ButtonClicked(layoutInternetBl, InternetBl.class);
        ButtonClicked(layoutInternetAirtel, InternetAirtel.class);
        ButtonClicked(layoutInternetRobi, InternetRobi.class);
        ButtonClicked(layoutInternetTeletalk, InternetTeletalk.class);

    }

    public void Initialization(){
        app_bar = (Toolbar) findViewById(R.id.app_bar);

        mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        layoutInternetGp = (LinearLayout) findViewById(R.id.layoutInternetGp);
        layoutInternetBl = (LinearLayout) findViewById(R.id.layoutInternetBl);
        layoutInternetAirtel = (LinearLayout) findViewById(R.id.layoutInternetAirtel);
        layoutInternetRobi = (LinearLayout) findViewById(R.id.layoutInternetRobi);
        layoutInternetTeletalk = (LinearLayout) findViewById(R.id.layoutInternetTeletalk);
    }

    public void ButtonClicked(LinearLayout buttonLayout, final Class activityClass){
        buttonLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ServiceInternet.this, activityClass);
                startActivity(intent);
            }
        });
    }


}
