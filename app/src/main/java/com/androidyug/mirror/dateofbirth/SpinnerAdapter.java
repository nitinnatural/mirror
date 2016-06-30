package com.androidyug.mirror.dateofbirth;

import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.androidyug.mirror.R;
import com.androidyug.mirror.utils.FontsFactory;

/**
 * Created by Nicheminds on 6/30/2016.
 */
public class SpinnerAdapter extends ArrayAdapter<String>{
    Context ctx;


        // (In reality I used a manager which caches the Typeface objects)
        // Typeface font = FontManager.getInstance().getFont(getContext(), BLAMBOT);

        public SpinnerAdapter(Context context, int resource, String[] items) {
            super(context, resource, items);
            this.ctx = context;
        }



        // Affects default (closed) state of the spinner
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            TextView view = (TextView) super.getView(position, convertView, parent);
            view.setTypeface(FontsFactory.fontBold(ctx));
            return view;
        }

        // Affects opened state of the spinner
        @Override
        public View getDropDownView(int position, View convertView, ViewGroup parent) {
            TextView view = (TextView) super.getDropDownView(position, convertView, parent);
            view.setTypeface(FontsFactory.fontBold(ctx));
            view.setBackgroundColor(getContext().getResources().getColor(R.color.pink));
            view.setTextColor(getContext().getResources().getColor(R.color.white));
            return view;
        }


}

