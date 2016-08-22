package com.moodybugs.saim.bdsimservices;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class ServiceUSSD extends AppCompatActivity {
    Toolbar app_bar;
    private AdView mAdView;
    LinearLayout layoutUSSDGp, layoutUSSDBl, layoutUSSDAirtel, layoutUSSDRobi, layoutUSSDTeletalk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.service_ussd);
        Initialization();
        setTitle("Important USSD");
        setSupportActionBar(app_bar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_appbar_ussd);

        ButtonClicked(layoutUSSDGp, UssdGp.class);
        ButtonClicked(layoutUSSDBl, UssdBl.class);
        ButtonClicked(layoutUSSDAirtel, UssdAirtel.class);
        ButtonClicked(layoutUSSDRobi, UssdRobi.class);
        ButtonClicked(layoutUSSDTeletalk, UssdTeletalk.class);
    }

    public void Initialization(){
        app_bar = (Toolbar) findViewById(R.id.app_bar);

        mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        layoutUSSDGp = (LinearLayout) findViewById(R.id.layoutUSSDGp);
        layoutUSSDBl = (LinearLayout) findViewById(R.id.layoutUSSDBl);
        layoutUSSDAirtel = (LinearLayout) findViewById(R.id.layoutUSSDAirtel);
        layoutUSSDRobi = (LinearLayout) findViewById(R.id.layoutUSSDRobi);
        layoutUSSDTeletalk = (LinearLayout) findViewById(R.id.layoutUSSDTeletalk);
    }

    public void ButtonClicked(LinearLayout buttonLayout, final Class activityClass){
        buttonLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ServiceUSSD.this, activityClass);
                startActivity(intent);
            }
        });
    }
}
