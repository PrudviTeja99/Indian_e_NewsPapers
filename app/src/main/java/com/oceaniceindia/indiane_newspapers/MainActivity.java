package com.oceaniceindia.indiane_newspapers;



import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.material.tabs.TabLayout;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tabLayout=findViewById(R.id.tablayout);
        viewPager=findViewById(R.id.viewpager);

        AdView mAdView;

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        ViewPagerAdapter adapter=new ViewPagerAdapter(getSupportFragmentManager());
        adapter.AddFragment(new TeluguPapers(),"Telugu");
        adapter.AddFragment(new HindiPapers(),"Hindi");
        adapter.AddFragment(new EnglishPapers(),"English");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.about :
                startActivity(new Intent(MainActivity.this,About.class));
                return true;
            case R.id.share:
                Toast.makeText(MainActivity.this,"Thanks For Sharing...",Toast.LENGTH_SHORT).show();
                Intent intent=new Intent();
                intent.setAction(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_TEXT,"Indian e-NewsPapers App has all Telugu,Hindi and English ePapers with best UserInterface,Install the app Now!.Download App by clicking on this link"+"\n"+" https://drive.google.com/folderview?id=1-c0ZEZDiwc2YVEdSaqWAuBfuB0WfX58t");
                intent.setType("text/plane");
                startActivity(intent);
                return true;
            case R.id.feedback :
                Toast.makeText(MainActivity.this, "Please Wait....", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this,Feedback.class));
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
