package com.androidyug.mirror.aboutyou;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.androidyug.mirror.R;
import com.androidyug.mirror.data.model.Chapter;
import com.androidyug.mirror.utils.FontsFactory;

import java.util.List;

/**
 * Created by Nicheminds on 6/25/2016.
 */
public class ChapterAdapter extends BaseAdapter {

    List<Chapter> chapterList;
    Context ctx;

    public ChapterAdapter(Context context, List<Chapter> chapterList){
        this.chapterList = chapterList;
        this.ctx = context;
    }

    @Override
    public int getCount() {
        return chapterList.size();
    }

    @Override
    public Chapter getItem(int position) {
        return chapterList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Holder h;
        if (convertView == null){
            LayoutInflater inflater = LayoutInflater.from(ctx);
            convertView = inflater.inflate(R.layout.row_chapter, parent, false);
            h = new Holder(convertView);
            convertView.setTag(h);
        } else {
            h = (Holder) convertView.getTag();
        }
        Chapter ch = getItem(position);
        h.tvChapterName.setText(ch.getName());
        return convertView;
    }

    class Holder {
        TextView tvChapterName;
        public Holder(View v){
            tvChapterName = (TextView) v.findViewById(R.id.tv_chapter_name);
            tvChapterName.setTypeface(FontsFactory.fontRegular(ctx));
        }
    }
}
