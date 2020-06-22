package com.oceaniceindia.indiane_newspapers;



import android.content.Context;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;


public class NewsPaperEnglish extends AppCompatActivity {
    String link;
    WebView mywebview;
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.newspaper);

        mywebview=(WebView) findViewById(R.id.webview);

        String name = getIntent().getStringExtra("name");
        Toast.makeText(this,name,Toast.LENGTH_SHORT).show();


        if(name.equals("The Indian Express")) {
            link ="https://www.newspaperpdf.online/download-indian-express.php";
        }
        else if(name.equals("Deccan Chronical")){
            link="https://www.newspaperpdf.online/download-deccan-chronicle.php";
        }
        else if(name.equals("The Hindu")){
            link="https://www.newspaperpdf.online/download_the_hindu.php";

        }
        else if(name.equals("Times of India")){
            link="https://www.newspaperpdf.online/download-times-of-india.php";
        }
        else if(name.equals("Hindustan Times")){
            link="https://www.newspaperpdf.online/download-hindustan-times.php";
        }
        else if(name.equals("Economic Times")){
            link="https://www.newspaperpdf.online/download-economic-times.php";
        }
        else if(name.equals("The Financial Express")){
            link="https://www.newspaperpdf.online/download-financial-express.php";
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
