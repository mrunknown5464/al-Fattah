package com.mrunknown.alfattah;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.mrunknown.alfattah.Database.PermissionActivity;

public class SplashScreen extends AppCompatActivity {
    ImageView image;
    Animation animation;
    TextView dev;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        overridePendingTransition(R.anim.act_fade_in,R.anim.act_fade_out);
        PermissionActivity p=new PermissionActivity(SplashScreen.this);
        image=findViewById(R.id.imgSplash);
        dev=findViewById(R.id.txtDeveloper);
        animation= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_out);
        image.startAnimation(animation);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                image.getLayoutParams().width=1000;
                image.getLayoutParams().height=1000;
                image.setImageResource(R.drawable.icon);
                dev.setVisibility(View.VISIBLE);
                animation= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in);
                image.startAnimation(animation);

            }
        },1500);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                SharedPreferences sharedpreferences = getSharedPreferences("Status", Context.MODE_PRIVATE);

                Boolean st=sharedpreferences.getBoolean("st",false);

                if(st)
                {
                    startActivity(new Intent(SplashScreen.this,HomeActivity.class));
                }
                else {
                    startActivity(new Intent(SplashScreen.this, LoginActivity.class));
                }
            }
        },4000);
    }
    @Override
    public void onDestroy()
    {
        super.onDestroy();
        Runtime.getRuntime().gc();
    }

}