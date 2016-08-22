package com.moodybugs.saim.bdsimservices;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class MainMenu extends AppCompatActivity {
    Toolbar app_bar;
    private AdView mAdView;
    LinearLayout layoutMobileBanking, layoutMobileFnf, layoutInternetPackage, layoutPrepaidPackage, layoutBundleOffer, layoutImportantUssd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu);
        Initialization();
        setSupportActionBar(app_bar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_appbar_launcher);

        ButtonClicked(layoutMobileBanking, ServiceBanking.class);
        ButtonClicked(layoutMobileFnf, ServiceFnf.class);
        ButtonClicked(layoutInternetPackage, ServiceInternet.class);
        ButtonClicked(layoutPrepaidPackage, ServicePrepaidPackage.class);
        ButtonClicked(layoutBundleOffer, ServiceBundle.class);
        ButtonClicked(layoutImportantUssd, ServiceUSSD.class);
    }

    public void Initialization(){
        app_bar = (Toolbar) findViewById(R.id.app_bar);

        mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        layoutMobileBanking = (LinearLayout) findViewById(R.id.layoutMobileBanking);
        layoutMobileFnf = (LinearLayout) findViewById(R.id.layoutMobileFnf);
        layoutInternetPackage = (LinearLayout) findViewById(R.id.layoutInternetPackage);
        layoutPrepaidPackage = (LinearLayout) findViewById(R.id.layoutPrepaidPackage);
        layoutBundleOffer = (LinearLayout) findViewById(R.id.layoutBundleOffer);
        layoutImportantUssd = (LinearLayout) findViewById(R.id.layoutImportantUssd);
    }

    public void ButtonClicked(LinearLayout buttonLayout, final Class activityClass){
        buttonLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMenu.this, activityClass);
                startActivity(intent);
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
            Intent intent = new Intent(MainMenu.this, Developer.class);
            startActivity(intent);
            finish();
        }

        return true;
    }
}
