package com.example.reddyz.basicfragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Reddyz on 22-09-2016.
 */
public class BottomFragment extends Fragment {

    private static TextView topTxt;
    private static TextView bottomTxt;

    private String TAG="ReddyzLog";

    @Override
    public void onAttach(Context context) {
        Log.i(TAG,"BottomFragment->onAttach");
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.i(TAG,"BottomFragment->onCreateView");
        View view = inflater.inflate(R.layout.bottom_fragment, container,false);

        topTxt = (TextView)view.findViewById(R.id.topTextView);
        bottomTxt = (TextView)view.findViewById(R.id.bottomTextView);

        return view;
    }

    public void setBottomFragmentTexts(String top, String bottom) {
        Log.i(TAG,"BottomFragment->setBottomFragmentTexts");
        topTxt.setText(top);
        bottomTxt.setText(bottom);
    }
}
