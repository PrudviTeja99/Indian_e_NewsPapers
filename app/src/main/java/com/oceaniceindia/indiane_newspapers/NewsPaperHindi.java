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

public class NewsPaperHindi extends AppCompatActivity {
    WebView mywebview;
    private AdView mAdView;
    String link;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newspaper);
        mywebview=(WebView) findViewById(R.id.webview);

        getSupportActionBar().hide();
        String name = getIntent().getStringExtra("name");
        Toast.makeText(this,name,Toast.LENGTH_SHORT).show();

        if(name.equals("Dainik Jagran")) {
            link = "https://www.newspaperpdf.online/download-dainik-jagran.php";
        }
        else if(name.equals("Hindustan")){
            link="https://epaper.livehindustan.com/";
        }
        else if(name.equals("Dainik Bhaskar")){
            link="https://epaper.bhaskar.com/";
        }
        else if(name.equals("Amar Ujala")){
            link="https://epaper.amarujala.com/";
        }
        else if(name.equals("Patrika")){
            link="https://epaper.patrika.com/";
        }
        else if(name.equals("Punjab Kesari")){
            link="http://epaper.punjabkesari.in/";
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
