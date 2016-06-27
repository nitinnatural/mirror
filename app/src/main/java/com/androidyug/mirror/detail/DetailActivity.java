package com.androidyug.mirror.detail;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.androidyug.mirror.R;

import fr.castorflex.android.verticalviewpager.VerticalViewPager;

public class DetailActivity extends AppCompatActivity {

    public static final String INTENT_DETAIL = "INTENT_DETAIL";
    VerticalViewPager vvpContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        initViews();

        CustomPagerAdapter customPagerAdapter = new CustomPagerAdapter(getSupportFragmentManager());
        vvpContent.setAdapter(customPagerAdapter);

    }

    void initViews(){
        vvpContent = (VerticalViewPager) findViewById(R.id.vp_card);
    }
}
