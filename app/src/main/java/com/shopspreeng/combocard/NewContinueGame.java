package com.shopspreeng.combocard;

import android.annotation.SuppressLint;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.MenuItem;
import android.support.v4.app.NavUtils;
import android.view.WindowManager;

import com.shopspreeng.Utils.StaticUtils;

public class NewContinueGame extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_new_continue_game);


        if (savedInstanceState != null) {
            //TODO get current data and pass into perspective
        } else {
            if (getIntent().getExtras() != null) {
                if (getIntent().getExtras().get(StaticUtils.OLD_NEW_GAME).equals(getString(R.string.new_game))) {
                    //TODO make new game views appear
                } else if (getIntent().getExtras().get(StaticUtils.OLD_NEW_GAME).equals(getString(R.string.continue_game))) {
                    //TODO make continue game views appear
                } else {
                    finish();
                }
            }
        }
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            // This ID represents the Home or Up button.
            NavUtils.navigateUpFromSameTask(this);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


}
