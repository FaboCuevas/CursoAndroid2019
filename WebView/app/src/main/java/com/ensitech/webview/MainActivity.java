package com.ensitech.webview;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    Button localizar;
    LocationHelper locator;
    WebView browser;
    String url = "https://www.google.com";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        localizar = findViewById(R.id.localizar);
        textView = findViewById(R.id.textView);
        locator = new LocationHelper(this);

        if(checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                || checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{
                    Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.ACCESS_COARSE_LOCATION}, 1);

        }

        localizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Location location = locator.getCurrentLocation();
                textView.setText("("+ location.getLatitude() +","+ location.getLongitude() +","+ location.getAltitude()+")");
            }
        });
        /*browser = findViewById(R.id.webView);

        browser.getSettings().setJavaScriptEnabled(true);
        browser.setWebViewClient(new WebViewClient());
        browser.loadUrl(url);

        browser.setWebChromeClient(new WebChromeClient(){
        public void onProgressChanged(WebView view, int progress) {
                progressBar.setProgress(0);
                progressBar.setVisibility(View.VISIBLE);
                MainActivity.this.setProgress(progress * 1000);

                progressBar.incrementProgressBy(progress);

                if (progress == 100) {
                    progressBar.setVisibility(View.GONE);
                }
            }
        });*/

    }

    /*
    @Override
    public void onBackPressed() {
        if (browser.canGoBack()){
            browser.goBack();
        }else {
            super.onBackPressed();
        }
    }*/
}
