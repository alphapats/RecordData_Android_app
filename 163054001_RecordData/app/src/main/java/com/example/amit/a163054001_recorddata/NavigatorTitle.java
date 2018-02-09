package com.example.amit.a163054001_recorddata;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Amit on 23-01-2018.
 */


public class NavigatorTitle extends BaseAdapter {


        private TextView txtTitle;
        private ArrayList<SpinnerItems> spinnerItem;
        private Context context;

        public NavigatorTitle(Context context,
                                      ArrayList<SpinnerItems> spinnerItem) {
            this.spinnerItem = spinnerItem;
            this.context = context;
        }

        @Override
        public int getCount() {
            return spinnerItem.size();
        }

        @Override
        public Object getItem(int index) {
            return spinnerItem.get(index);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                LayoutInflater mInflater = (LayoutInflater)
                        context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
                convertView = mInflater.inflate(R.layout.navigation_list, null);
            }

           txtTitle = (TextView) convertView.findViewById(R.id.txtTitle);

          txtTitle.setText(spinnerItem.get(position).getTitle());
            return convertView;
        }


        @Override
        public View getDropDownView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                LayoutInflater mInflater = (LayoutInflater)
                        context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
                convertView = mInflater.inflate(R.layout.navigation_list, null);
            }

            txtTitle = (TextView) convertView.findViewById(R.id.txtTitle);

               txtTitle.setText(spinnerItem.get(position).getTitle());
            return convertView;
        }

}
