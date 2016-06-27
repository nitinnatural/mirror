package com.androidyug.mirror.aboutyou;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.androidyug.mirror.R;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import com.androidyug.mirror.data.ServiceApi;
import com.androidyug.mirror.data.model.Chapter;
import com.androidyug.mirror.detail.DetailActivity;
import com.androidyug.mirror.data.model.Response;

public class AboutYouActivity extends AppCompatActivity {
    public static final String INTENT_ZODIAC = "INTENT_ZODIAC";

    ListView lvContent;
    ChapterAdapter chapterAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_you);
        initViews();

        int zodiac = getIntent().getIntExtra(INTENT_ZODIAC, -1);
        if (zodiac != -1){
            Response response = ServiceApi.getInstance().fetchZodiacData(this,zodiac);
            chapterAdapter = new ChapterAdapter(this, response.getData().getChapter());
            lvContent.setAdapter(chapterAdapter);
        }



        LayoutInflater inflater = getLayoutInflater();
        ViewGroup header = (ViewGroup)inflater.inflate(R.layout.lv_header, lvContent, false);
        lvContent.addHeaderView(header, null, false);



        lvContent.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Chapter ch = (Chapter) parent.getSelectedItem();
                Intent i = new Intent(AboutYouActivity.this, DetailActivity.class);
                i.putExtra(DetailActivity.INTENT_DETAIL, ch);
                startActivity(i);
            }
        });
    }

    void initViews(){
        lvContent = (ListView) findViewById(R.id.lv_content);
    }






}
