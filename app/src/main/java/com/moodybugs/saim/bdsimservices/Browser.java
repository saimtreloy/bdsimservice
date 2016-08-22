package com.moodybugs.saim.bdsimservices;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class Browser extends AppCompatActivity {

    public WebView webViewBrowser;
    public String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.ThemeTeletalk);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.browser);
        setTitle("Latest Offer");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_appbar_launcher);

        Intent intent = getIntent();
        url = intent.getExtras().getString("url");
        Toast.makeText(this, url, Toast.LENGTH_SHORT).show();

        BrowserSetup();
    }

    public void BrowserSetup() {
        webViewBrowser = (WebView) findViewById(R.id.webView);
        webViewBrowser.setWebViewClient(new MyBrowser());

        webViewBrowser.getSettings().setJavaScriptEnabled(true);
        webViewBrowser.getSettings().setLoadWithOverviewMode(true);
        webViewBrowser.getSettings().setUseWideViewPort(true);
        webViewBrowser.getSettings().setSupportZoom(true);
        webViewBrowser.getSettings().setBuiltInZoomControls(true);
        webViewBrowser.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
        webViewBrowser.setScrollbarFadingEnabled(true);
        webViewBrowser.getSettings().setLoadsImagesAutomatically(true);
        webViewBrowser.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        webViewBrowser.loadUrl(url);
    }

    private class MyBrowser extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.btnDeveloper) {
            Intent intent = new Intent(Browser.this, Developer.class);
            startActivity(intent);
            finish();
        } else if (item.getItemId() == android.R.id.home) {
            Intent intent = new Intent(Browser.this, MainMenu.class);
            startActivity(intent);
            finish();
        }

        return true;
    }
}
