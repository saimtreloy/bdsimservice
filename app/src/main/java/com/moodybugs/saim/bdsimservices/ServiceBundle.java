package com.moodybugs.saim.bdsimservices;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class ServiceBundle extends AppCompatActivity {

    Toolbar app_bar;
    private AdView mAdView;
    LinearLayout layoutBundleGp, layoutBundleBl, layoutBundleAirtel, layoutBundleRobi, layoutBundleTeletalk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.service_bundle);
        setTitle("Bundle Offer");
        Initialization();
        setSupportActionBar(app_bar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_appbar_bandle);
        ButtonClicked(layoutBundleGp, BundleGp.class);
        ButtonClicked(layoutBundleBl, BundleBl.class);
        ButtonClicked(layoutBundleAirtel, BundleAirtel.class);
        ButtonClicked(layoutBundleRobi, BundleRobi.class);
        ButtonClicked(layoutBundleTeletalk, BundleTeletalk.class);
    }

    public void Initialization(){
        app_bar = (Toolbar) findViewById(R.id.app_bar);

        mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        layoutBundleGp = (LinearLayout) findViewById(R.id.layoutBundleGp);
        layoutBundleBl = (LinearLayout) findViewById(R.id.layoutBundleBl);
        layoutBundleAirtel = (LinearLayout) findViewById(R.id.layoutBundleAirtel);
        layoutBundleRobi = (LinearLayout) findViewById(R.id.layoutBundleRobi);
        layoutBundleTeletalk = (LinearLayout) findViewById(R.id.layoutBundleTeletalk);
    }

    public void ButtonClicked(LinearLayout linearLayout, final Class activityClass){
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ServiceBundle.this, activityClass);
                startActivity(intent);
            }
        });
    }
}
