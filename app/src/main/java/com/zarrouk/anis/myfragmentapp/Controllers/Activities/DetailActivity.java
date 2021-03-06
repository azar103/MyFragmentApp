package com.zarrouk.anis.myfragmentapp.Controllers.Activities;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import com.zarrouk.anis.myfragmentapp.Controllers.Fragments.DetailFragment;
import com.zarrouk.anis.myfragmentapp.R;
import android.support.v7.widget.Toolbar;
public class DetailActivity extends AppCompatActivity {
    public static final String BUTTON_TAG_EXTRA = "com.zarrouk.anis.myfragmentapp.Controllers.Activities.DetailActivity.BUTTON_TAG_EXTRA";
    private DetailFragment detailFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        this.configureAndShowDetailFragment();
        this.configureAndShowToolBar();

    }

    @Override
    protected void onResume() {
        super.onResume();
        updateDetailFragmentTextViewWithIntentTag();
    }

    private void configureAndShowDetailFragment(){
        detailFragment = (DetailFragment) getSupportFragmentManager().findFragmentById(R.id.frame_layout_detail);
        if(detailFragment == null){
            detailFragment = new DetailFragment();
            getSupportFragmentManager().beginTransaction().add(R.id.frame_layout_detail, detailFragment).commit();
        }
    }
    private void updateDetailFragmentTextViewWithIntentTag() {
        int tag = getIntent().getIntExtra(BUTTON_TAG_EXTRA, 0);
        detailFragment.updateTextView(tag);
    }
    private void configureAndShowToolBar(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar ab = getSupportActionBar();
        ab.setTitle("Detail Activity");
        ab.setDisplayHomeAsUpEnabled(true);

    }

}
