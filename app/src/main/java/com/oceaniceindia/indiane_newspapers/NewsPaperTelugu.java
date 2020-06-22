package com.oceaniceindia.indiane_newspapers;


import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class NewsPaperTelugu extends AppCompatActivity {
    WebView mywebview;
    private AdView mAdView;
    String link;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newspaper);
        mywebview=(WebView) findViewById(R.id.webview);


        String name = getIntent().getStringExtra("name");
        Toast.makeText(this,name,Toast.LENGTH_SHORT).show();

        if(name.equals("Eenadu")) {
            link = "https://epaper.eenadu.net/";
        }
        else if(name.equals("AndhraJyothi")){
            link="http://mpaper.andhrajyothy.com/";
        }
        else if(name.equals("NavaTelangana")){
            link="https://epaper.navatelangana.com/";
        }
        else if(name.equals("Sakshi")){
            link="https://epaper.sakshi.com/";
        }
        else if(name.equals("NamasteTelangana")){
            link="https://epaper.ntnews.com/";
        }
        else if(name.equals("Vaartha")){
            link="https://epaper.vaartha.com/";
        }
        else if(name.equals("AndhraPrabha")){
            link="https://epaper.prabhanews.com/";
        }
        else if(name.equals("Surya")){
            link="http://epaper.suryaa.com/";
        }




        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        mAdView = findViewById(R.id.adView1);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);




        WebSettings ws=mywebview.getSettings();
        ws.setJavaScriptEnabled(true);
        mywebview.loadUrl(link);
        mywebview.setWebViewClient(new WebViewClient());




    }
    public void onBackPressed(){
        if(mywebview.canGoBack()){
            mywebview.goBack();
        }
        else{
            super.onBackPressed();
        }
    }
}

