package com.androidyug.mirror.dateofbirth;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
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
    Button btnProceed;
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
        toggleAnimation(btnShimmerProceed);
    }

    void initSpinner(){
        SpinnerAdapter adapterDays = new SpinnerAdapter(this,R.layout.spinner_texview, day);
        //adapterDays.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerDay.setAdapter(adapterDays);
        spinnerDay.setPrompt("Day");

        SpinnerAdapter adapterMonths = new SpinnerAdapter(this,R.layout.spinner_texview, month);
        //adapterDays.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerMonth.setAdapter(adapterMonths);
        spinnerMonth.setPrompt("Month");
    }

    List<Integer> getDays(){
        List<Integer> dayList = new ArrayList<>();
        for (int i=1; i<=31; i++){
            dayList.add(i);
        }
        return dayList;
    }


    List<Integer> getMonths(){
        List<Integer> monthList = new ArrayList<>();
        for (int i=1; i<=12; i++){
            monthList.add(i);
        }
        return monthList;
    }


    void initView(){
        tvBornOn = (TextView) findViewById(R.id.tv_born_on);
        ivBornOn = (ImageView) findViewById(R.id.iv_born_on);
        btnBornOn = (TextView) findViewById(R.id.tv_btn_born_on);
        spinnerDay = (Spinner) findViewById(R.id.spinner_day);
        spinnerMonth = (Spinner) findViewById(R.id.spinner_month);
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
            shimmer.setDuration(1500)
                    .setStartDelay(100)
                    .setDirection(Shimmer.ANIMATION_DIRECTION_LTR);

        }
    }



    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.btn_shimmer_proceed:
                int day = (int) spinnerDay.getSelectedItem();
                int month = (int) spinnerMonth.getSelectedItem();
                int zodiac = ZodiacFactory.whichZodiac(day, month);
                Intent i = new Intent(BornOnActivity.this, AboutYouActivity.class);
                i.putExtra(AboutYouActivity.INTENT_ZODIAC, zodiac);
                startActivity(i);
                break;
            case R.id.tv_btn_born_on:
                // open the spinner dialog
        }
    }
}
