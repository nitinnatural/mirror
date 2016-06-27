package com.androidyug.mirror.detail;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.androidyug.mirror.R;
import com.androidyug.mirror.utils.FontsFactory;

/**
 * Created by Nicheminds on 6/26/2016.
 */
public class DetailFragment extends Fragment {

    TextView tvTitle, tvContent;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_detail, container, false);
        initViews(v);
        return v;
    }

    void initViews(View v) {
        tvTitle = (TextView) v.findViewById(R.id.tv_title);
        tvContent = (TextView) v.findViewById(R.id.tv_content);
        tvTitle.setTypeface(FontsFactory.fontBold(getActivity()));
        tvContent.setTypeface(FontsFactory.fontRegular(getActivity()));
    }
}
