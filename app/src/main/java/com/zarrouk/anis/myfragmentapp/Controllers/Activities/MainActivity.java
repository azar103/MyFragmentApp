package com.zarrouk.anis.myfragmentapp.Controllers.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.zarrouk.anis.myfragmentapp.Controllers.Fragments.DetailFragment;
import com.zarrouk.anis.myfragmentapp.Controllers.Fragments.MainFragment;
import com.zarrouk.anis.myfragmentapp.R;

public class MainActivity extends AppCompatActivity  implements MainFragment.OnButtonClickedListener{
    private MainFragment mainFragment;
    private DetailFragment detailFragment;
    //declare a buttonTag tracking

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.configureAndShowMainFragment();
        this.configureAndShowDetailFragment();
    }


    @Override
    public void onButtonClicked(View v) {
        int buttonTag = Integer.parseInt(v.getTag().toString());
        if(detailFragment != null  && detailFragment.isVisible()) {
            detailFragment.updateText(buttonTag);
        }else{
            Intent i = new Intent(this, DetailActivity.class);
            i.putExtra(DetailActivity.BUTTON_TAG_EXTRA,buttonTag);
            startActivity(i);
        }
    }
    private void configureAndShowMainFragment() {
        mainFragment = (MainFragment)getSupportFragmentManager().findFragmentById(R.id.frame_layout_main);
        if(mainFragment == null)
        {
            mainFragment = new MainFragment();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.frame_layout_main, mainFragment)
                    .commit();
        }
    }

    private void configureAndShowDetailFragment() {
        detailFragment = (DetailFragment)getSupportFragmentManager().findFragmentById(R.id.frame_layout_detail);
        if(detailFragment == null && findViewById(R.id.frame_layout_detail)!=null){
            detailFragment = new DetailFragment();
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.frame_layout_detail, detailFragment)
                    .commit();
        }
    }


}
