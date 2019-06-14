package com.zarrouk.anis.myfragmentapp.Controllers.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.zarrouk.anis.myfragmentapp.Controllers.Fragments.DetailFragment;
import com.zarrouk.anis.myfragmentapp.R;

public class DetailActivity extends AppCompatActivity {
    private DetailFragment detailFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        this.configureAndShowDetailFragment();
    }

    private void configureAndShowDetailFragment(){
        detailFragment = (DetailFragment) getSupportFragmentManager().findFragmentById(R.id.frame_layout_detail);
        if(detailFragment == null){
            detailFragment = new DetailFragment();
            getSupportFragmentManager().beginTransaction().add(R.id.frame_layout_detail, detailFragment).commit();
        }
    }
}
