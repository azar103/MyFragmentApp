package com.zarrouk.anis.myfragmentapp.Controllers.Fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zarrouk.anis.myfragmentapp.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment implements  View.OnClickListener {
    private OnButtonClickedListener mCallBack;

    public interface OnButtonClickedListener{
        public void onButtonClicked(View v);
    }

    @Override
    public void onAttach(Context context) {
        this.onCreateCallBackToParent();
        super.onAttach(context);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View result =  inflater.inflate(R.layout.fragment_main, container, false);
        result.findViewById(R.id.fragment_main_button_happy).setOnClickListener(this);
        result.findViewById(R.id.fragment_main_button_sad).setOnClickListener(this);
        result.findViewById(R.id.fragment_main_button_horrible).setOnClickListener(this);
        return result;
    }
    public void onCreateCallBackToParent(){
        try{
            mCallBack = (OnButtonClickedListener)getActivity();
        }catch(ClassCastException e){
            throw new ClassCastException(e.toString()+ " must implement OnButtonClickedListener");
        }

    }
    @Override
    public void onClick(View v) {
       mCallBack.onButtonClicked(v);
    }
}
