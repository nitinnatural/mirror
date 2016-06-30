package com.androidyug.mirror.detail;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.androidyug.mirror.R;
import com.androidyug.mirror.data.model.Story;
import com.androidyug.mirror.utils.FontsFactory;

/**
 * Created by Nicheminds on 6/26/2016.
 */
public class DetailFragment extends Fragment {

    private static final String ARGS_STORY = "ARGS_STORY";

    TextView tvTitle, tvContent;

    public static DetailFragment newInstance(Story story) {
        Bundle args = new Bundle();
        args.putSerializable(ARGS_STORY, story);
        DetailFragment fragment = new DetailFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_detail, container, false);
        initViews(v);
        Story story = (Story) getArguments().getSerializable(ARGS_STORY);
        tvTitle.setText(story.getTitle());
        tvContent.setText(story.getContent());
        return v;
    }

    void initViews(View v) {
        tvTitle = (TextView) v.findViewById(R.id.tv_title);
        tvContent = (TextView) v.findViewById(R.id.tv_content);
        tvTitle.setTypeface(FontsFactory.fontBold(getActivity()));
        tvContent.setTypeface(FontsFactory.fontRegular(getActivity()));
    }
}
