package com.androidyug.mirror.dateofbirth;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.androidyug.mirror.R;
import com.androidyug.mirror.utils.FontsFactory;

public class BornOnActivity extends AppCompatActivity {

    TextView tvBornOn;
    ImageView ivBornOn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_born_on);
        initView();
    }

    void initView(){
        tvBornOn = (TextView) findViewById(R.id.tv_born_on);
        ivBornOn = (ImageView) findViewById(R.id.iv_born_on);
        tvBornOn.setTypeface(FontsFactory.fontStylish(this));
    }


}
