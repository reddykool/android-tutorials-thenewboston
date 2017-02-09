package com.example.reddyz.basicfragments;

/**
 * Created by Reddyz on 22-09-2016.
 */

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.app.Activity;
import android.widget.Button;
import android.widget.EditText;

public class TopFragment extends Fragment{

    private static EditText topTextInput;
    private static EditText bottomTextInput;

    TopFragmentListener activityCommander;

    private String TAG="ReddyzLog";

    public interface  TopFragmentListener {
        public void createMeme(String top, String bottom);
    }

    @Override
    public void onAttach(Context context) {
        Log.i(TAG,"TopFragment->onAttach");
        super.onAttach(context);
        try {
            activityCommander = (TopFragmentListener) context;
        } catch(ClassCastException e) {
            throw new ClassCastException(context.toString());
        }

    }

    @Nullable
    @Override

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.i(TAG,"TopFragment->onCreateView");
        View view = inflater.inflate(R.layout.top_fragment, container, false);

        topTextInput = (EditText)view.findViewById(R.id.topText);
        bottomTextInput = (EditText)view.findViewById(R.id.bottomText);
        final Button button = (Button)view.findViewById(R.id.button);

        button.setOnClickListener(
                new Button.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Log.i(TAG,"Button.OnClickListener->onClick");
                        buttonClicked(v);
                    }
                }
        );

        return view;
    }

    public void buttonClicked(View v) {
        Log.i(TAG,"TopFragment->buttonClicked");
        activityCommander.createMeme(topTextInput.getText().toString(), bottomTextInput.getText().toString());
    }
}
