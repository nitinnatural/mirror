package com.androidyug.mirror.detail;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.androidyug.mirror.data.model.Story;

import java.util.List;

/**
 * Created by Nicheminds on 6/26/2016.
 */
public class CustomPagerAdapter extends FragmentStatePagerAdapter {
    List<Story> mStoryList;

    public CustomPagerAdapter(FragmentManager fm, List<Story> storyList) {
        super(fm);
        this.mStoryList = storyList;
    }

    @Override
    public Fragment getItem(int position) {
        return DetailFragment.newInstance(mStoryList.get(position));
    }

    @Override
    public int getCount() {
        return mStoryList.size();
    }
}
