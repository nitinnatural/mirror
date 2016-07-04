package com.androidyug.mirror.aboutyou;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import  com.androidyug.mirror.utils.ZodiacFactory;

import com.androidyug.mirror.R;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import com.androidyug.mirror.data.ServiceApi;
import com.androidyug.mirror.data.model.Chapter;
import com.androidyug.mirror.detail.DetailActivity;
import com.androidyug.mirror.data.model.Response;
import com.androidyug.mirror.utils.FontsFactory;

public class AboutYouActivity extends AppCompatActivity {
    public static final String INTENT_ZODIAC = "INTENT_ZODIAC";

    ListView lvContent;
    Toolbar toolbar;
    ChapterAdapter chapterAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_you);
        initViews();
//        initToolbar();

        LayoutInflater inflater = getLayoutInflater();
        ViewGroup header = (ViewGroup)inflater.inflate(R.layout.lv_header, lvContent, false);
        TextView tvZodiac = (TextView) header.findViewById(R.id.tv_zodiac);
        ImageView ivZodiac = (ImageView) header.findViewById(R.id.iv_zodiac_image);
        TextView tvTimePeriod = (TextView) header.findViewById(R.id.tv_time_period);

        int zodiac = getIntent().getIntExtra(INTENT_ZODIAC, -1);
        if (zodiac != -1){
            Response response = ServiceApi.getInstance().fetchZodiacData(this,zodiac);
            tvZodiac.setText(response.getData().getSign());
            ivZodiac.setImageResource(ZodiacFactory.getZodiacPersonality(zodiac));
            tvTimePeriod.setText(response.getData().getFromDate() + " - " + response.getData().getToDate());
            chapterAdapter = new ChapterAdapter(this, response.getData().getChapter());
            lvContent.setAdapter(chapterAdapter);
        }



        lvContent.addHeaderView(header, null, false);



        lvContent.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Chapter ch = (Chapter) parent.getAdapter().getItem(position);
                Intent i = new Intent(AboutYouActivity.this, DetailActivity.class);
                i.putExtra(DetailActivity.INTENT_DETAIL, ch);
                startActivity(i);
            }
        });
    }

    void initViews(){
        lvContent = (ListView) findViewById(R.id.lv_content);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
    }

    void initToolbar(){

        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setElevation(0);
        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        if (Build.VERSION.SDK_INT >= 21) {
            // Call some material design APIs here
            actionBar.setIcon(new ColorDrawable(getResources().getColor(android.R.color.transparent)));
            actionBar.setHomeAsUpIndicator(R.drawable.back);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        else {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR2) {
                actionBar.setHomeAsUpIndicator(R.drawable.back);
            }
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

    }



}
