package com.moodybugs.saim.bdsimservices;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class ServicePrepaidPackage extends AppCompatActivity {
    Toolbar app_bar;
    private AdView mAdView;
    LinearLayout layoutPackageGp, layoutPackageBl, layoutPackageAirtel, layoutPackageRobi, layoutPackageTeletalk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.service_prepaid_package);
        Initialization();
        setTitle("Packages");
        setSupportActionBar(app_bar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_appbar_prepaid_package);

        ButtonClicked(layoutPackageGp, PackageGp.class);
        ButtonClicked(layoutPackageBl, PackageBl.class);
        ButtonClicked(layoutPackageAirtel, PackageAirtel.class);
        ButtonClicked(layoutPackageRobi, PackageRobi.class);
        ButtonClicked(layoutPackageTeletalk, PackageTeletalk.class);

    }

    public void Initialization(){
        
        app_bar = (Toolbar) findViewById(R.id.app_bar);

        mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        layoutPackageGp = (LinearLayout) findViewById(R.id.layoutPackageGp);
        layoutPackageBl = (LinearLayout) findViewById(R.id.layoutPackageBl);
        layoutPackageAirtel = (LinearLayout) findViewById(R.id.layoutPackageAirtel);
        layoutPackageRobi = (LinearLayout) findViewById(R.id.layoutPackageRobi);
        layoutPackageTeletalk = (LinearLayout) findViewById(R.id.layoutPackageTeletalk);
    }

    public void ButtonClicked(LinearLayout buttonLayout, final Class activityClass){
        buttonLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ServicePrepaidPackage.this, activityClass);
                startActivity(intent);
            }
        });
    }
}
