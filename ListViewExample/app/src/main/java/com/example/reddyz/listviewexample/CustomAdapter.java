package com.example.reddyz.listviewexample;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by Reddyz on 28-09-2016.
 */
class CustomAdapter extends ArrayAdapter<String> {

    //static final String TAG="Reddyz-Log";
    private final Integer [] foodResIdList;

    public CustomAdapter(Context context, String[] foods, Integer[] foodResIds) {
        super(context,R.layout.custom_row, foods);
        foodResIdList = foodResIds; //Arrays.copyOf(foodResIds, foodResIds.length);
        //Log.i(TAG, "CustomAdapter constructed");
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater myInflater = LayoutInflater.from(getContext());
        View customView = myInflater.inflate(R.layout.custom_row, parent, false);

        String foodItem = getItem(position);
        TextView myText = (TextView)customView.findViewById(R.id.myText);
        ImageView myImage = (ImageView) customView.findViewById(R.id.myImage);

        myText.setText(foodItem);
        //int resId = foodResIdList[position];
        //Log.i(TAG,"Position: "+position+" foodItem: "+foodItem+" Res id: "+resId);
        myImage.setImageResource(foodResIdList[position]);
        return  customView;
    }
}
