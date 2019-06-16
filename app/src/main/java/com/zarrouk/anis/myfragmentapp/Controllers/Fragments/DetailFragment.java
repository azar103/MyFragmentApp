package com.zarrouk.anis.myfragmentapp.Controllers.Fragments;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zarrouk.anis.myfragmentapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailFragment extends Fragment {
    private TextView mDetailText;
    private int buttonTag;
    //declare a static varaible to identifiy key in bundle
    public static final String  KEY_BUTTON_TAG = "com.zarrouk.anis.myfragmentapp.Controllers.Fragments.DetailFragmen.KEY_BUTTONTAG";


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View result = inflater.inflate(R.layout.fragment_detail, container, false);
        mDetailText = result.findViewById(R.id.activity_detail_text);
        return result;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if(savedInstanceState != null){
            int buttonTag = savedInstanceState.getInt(KEY_BUTTON_TAG, 0);
            this.updateText(buttonTag);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {

        super.onSaveInstanceState(outState);
        outState.putInt(KEY_BUTTON_TAG, buttonTag);
    }

    public void updateText(int tag){
        this.buttonTag = tag;
        switch (tag){
            case 10:
                mDetailText.setText("You are a very good programmer!");
                break;
            case 20:
                mDetailText.setText("I do believe that Jon Snow is going to die in next season...");
                break;
            case 30:
                mDetailText.setText("Maybe Game of Thrones next season will get back in 2040 ?");
                break;
            default:
                break;

        }

    }

}
