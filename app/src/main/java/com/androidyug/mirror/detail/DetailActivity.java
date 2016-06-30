package com.androidyug.mirror.detail;

import android.graphics.drawable.ColorDrawable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.androidyug.mirror.R;
import com.androidyug.mirror.data.model.Chapter;

import fr.castorflex.android.verticalviewpager.VerticalViewPager;

public class DetailActivity extends AppCompatActivity {

    public static final String INTENT_DETAIL = "INTENT_DETAIL";
    private static final float MIN_SCALE = 0.75f;
    private static final float MIN_ALPHA = 0.75f;

    VerticalViewPager vvpContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        initViews();
        Chapter ch = (Chapter) getIntent().getSerializableExtra(INTENT_DETAIL);
        CustomPagerAdapter customPagerAdapter = new CustomPagerAdapter(getSupportFragmentManager(), ch.getStory());


        vvpContent.setPageMargin(getResources().getDimensionPixelSize(R.dimen.pagemargin));
        vvpContent.setPageMarginDrawable(new ColorDrawable(getResources().getColor(R.color.sky_light_blue)));

        vvpContent.setPageTransformer(true, new ViewPager.PageTransformer() {
            @Override
            public void transformPage(View view, float position) {
                int pageWidth = view.getWidth();
                int pageHeight = view.getHeight();

                if (position < -1) { // [-Infinity,-1)
                    // This page is way off-screen to the left.
                    view.setAlpha(0);

                } else if (position <= 1) { // [-1,1]
                    // Modify the default slide transition to shrink the page as well
                    float scaleFactor = Math.max(MIN_SCALE, 1 - Math.abs(position));
                    float vertMargin = pageHeight * (1 - scaleFactor) / 2;
                    float horzMargin = pageWidth * (1 - scaleFactor) / 2;
                    if (position < 0) {
                        view.setTranslationY(vertMargin - horzMargin / 2);
                    } else {
                        view.setTranslationY(-vertMargin + horzMargin / 2);
                    }

                    // Scale the page down (between MIN_SCALE and 1)
                    view.setScaleX(scaleFactor);
                    view.setScaleY(scaleFactor);

                    // Fade the page relative to its size.
                    view.setAlpha(MIN_ALPHA +
                            (scaleFactor - MIN_SCALE) /
                                    (1 - MIN_SCALE) * (1 - MIN_ALPHA));

                } else { // (1,+Infinity]
                    // This page is way off-screen to the right.
                    view.setAlpha(0);
                }
            }
        });


        vvpContent.setAdapter(customPagerAdapter);

    }

    void initViews(){
        vvpContent = (VerticalViewPager) findViewById(R.id.vp_card);
    }
}
