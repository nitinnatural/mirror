package com.androidyug.mirror.dateofbirth;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.androidyug.mirror.R;
import com.androidyug.mirror.aboutyou.AboutYouActivity;
import com.androidyug.mirror.utils.FontsFactory;
import com.androidyug.mirror.utils.ZodiacFactory;
import com.romainpiel.shimmer.Shimmer;
import com.romainpiel.shimmer.ShimmerButton;

import java.util.ArrayList;
import java.util.List;

public class BornOnActivity extends AppCompatActivity implements View.OnClickListener {

    TextView tvBornOn, btnBornOn;
    ImageView ivBornOn;
    Toolbar toolbar;
    Spinner spinnerDay, spinnerMonth;

    ShimmerButton btnShimmerProceed;
    Shimmer shimmer;

    String[] month = {"MONTH", "JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG", "SEP", "OCT", "NOV", "DEC"};
    String[] day = {"DAY", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17",
                    "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "29", "30", "31" };

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_born_on);
        initView();
        initToolbar();
        toggleAnimation(btnShimmerProceed);
    }

    void initSpinner(){
        SpinnerAdapter adapterDays = new SpinnerAdapter(this,R.layout.spinner_texview, day);
        spinnerDay.setAdapter(adapterDays);
        spinnerDay.setPrompt("Day");

        SpinnerAdapter adapterMonths = new SpinnerAdapter(this,R.layout.spinner_texview, month);
        spinnerMonth.setAdapter(adapterMonths);
        spinnerMonth.setPrompt("Month");

        spinnerMonth.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int mm = spinnerMonth.getSelectedItemPosition();
                int dd = spinnerDay.getSelectedItemPosition();
                if (mm!=0 && dd!=0){
                    btnShimmerProceed.setVisibility(View.VISIBLE);
                } else {
                    btnShimmerProceed.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinnerDay.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int mm = spinnerMonth.getSelectedItemPosition();
                int dd = spinnerDay.getSelectedItemPosition();

                if (mm!=0 && dd!=0){
                    btnShimmerProceed.setVisibility(View.VISIBLE);
                } else {
                    btnShimmerProceed.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }


    void initView(){
        tvBornOn = (TextView) findViewById(R.id.tv_born_on);
        ivBornOn = (ImageView) findViewById(R.id.iv_born_on);
        btnBornOn = (TextView) findViewById(R.id.tv_btn_born_on);
        spinnerDay = (Spinner) findViewById(R.id.spinner_day);
        spinnerMonth = (Spinner) findViewById(R.id.spinner_month);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        btnShimmerProceed = (ShimmerButton) findViewById(R.id.btn_shimmer_proceed);
        btnShimmerProceed.setTypeface(FontsFactory.fontBold(this));
        tvBornOn.setTypeface(FontsFactory.fontBold(this));
        btnShimmerProceed.setOnClickListener(this);
        btnBornOn.setOnClickListener(this);
        initSpinner();
    }


    public void toggleAnimation(View target) {
        if (shimmer != null && shimmer.isAnimating()) {
            shimmer.cancel();
        } else {
            shimmer = new Shimmer();
            shimmer.start(btnShimmerProceed);
            shimmer.setDuration(1200)
                    .setStartDelay(0)
                    .setDirection(Shimmer.ANIMATION_DIRECTION_LTR);

        }
    }


    @Override
    protected void onStart() {
        super.onStart();

        spinnerDay.setSelection(0, true);
        spinnerMonth.setSelection(0, true);
        btnShimmerProceed.setVisibility(View.GONE);
    }

    void initToolbar(){
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setElevation(0);
        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        actionBar.setTitle("Mirror");
        if (Build.VERSION.SDK_INT >= 21) {
            // Call some material design APIs here
            actionBar.setIcon(new ColorDrawable(getResources().getColor(android.R.color.transparent)));
//            actionBar.setHomeAsUpIndicator(R.drawable.back);
//            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        else {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR2) {
//                actionBar.setHomeAsUpIndicator(R.drawable.back);
            }
//            actionBar.setDisplayHomeAsUpEnabled(true);
        }

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.btn_shimmer_proceed:
                int day = (int) spinnerDay.getSelectedItemPosition();
                int month = (int) spinnerMonth.getSelectedItemPosition();
                int zodiac = ZodiacFactory.whichZodiac(day, month);
                Intent i = new Intent(BornOnActivity.this, AboutYouActivity.class);
                i.putExtra(AboutYouActivity.INTENT_ZODIAC, zodiac);
                startActivity(i);
                break;
        }
    }
}
