package com.mrunknown.alfattah;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;

public class ExitPopupActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exit_popup);
        overridePendingTransition(R.anim.act_fade_in,R.anim.act_fade_out);
        DisplayMetrics dm=new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width=dm.widthPixels;
        int height=dm.heightPixels;
        getWindow().setLayout((int)(width*0.9),(int)(height*.2));
    }
    public void onCancel(View v)
    {
    finish();
    }
    public void onExit(View b)
    {
        finishAffinity();
        System.exit(0);
    }
}