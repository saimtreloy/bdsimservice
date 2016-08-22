package com.moodybugs.saim.bdsimservices;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class ServiceFnf extends AppCompatActivity {
    Toolbar app_bar;
    private AdView mAdView;
    LinearLayout layoutFnfGp, layoutFnfBl, layoutFnfAirtel, layoutFnfRobi, layoutFnfTeletalk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.service_fnf);

        Initialization();
        setTitle("FnF Service");
        setSupportActionBar(app_bar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_appbar_fnf);

        ButtonClicked(layoutFnfGp, FnfGp.class);
        ButtonClicked(layoutFnfBl, FnfBl.class);
        ButtonClicked(layoutFnfAirtel, FnfAirtel.class);
        ButtonClicked(layoutFnfRobi, FnfRobi.class);
        ButtonClicked(layoutFnfTeletalk, FnfTeletalk.class);
    }

    public void Initialization(){
        app_bar = (Toolbar) findViewById(R.id.app_bar);

        mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        layoutFnfGp = (LinearLayout) findViewById(R.id.layoutFnfGp);
        layoutFnfBl = (LinearLayout) findViewById(R.id.layoutFnfBl);
        layoutFnfAirtel = (LinearLayout) findViewById(R.id.layoutFnfAirtel);
        layoutFnfRobi = (LinearLayout) findViewById(R.id.layoutFnfRobi);
        layoutFnfTeletalk = (LinearLayout) findViewById(R.id.layoutFnfTeletalk);
    }

    public void ButtonClicked(LinearLayout buttonLayout, final Class activityClass){
        buttonLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ServiceFnf.this, activityClass);
                startActivity(intent);
            }
        });
    }
}
