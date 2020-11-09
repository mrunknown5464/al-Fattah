package com.mrunknown.alfattah;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import android.os.Bundle;

import android.os.StrictMode;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.mrunknown.alfattah.Database.DbConnection;
import java.sql.Connection;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.act_fade_in,R.anim.act_fade_out);
        setContentView(R.layout.activity_login);
        StrictMode.ThreadPolicy policy=new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        DbConnection db=new DbConnection();
        try {
           // Connection con=db.getDbConnection(this);
        } catch (Exception e) {
            Toast.makeText(this, "exception : "+e.toString(), Toast.LENGTH_SHORT).show();
        }


    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(this,ExitPopupActivity.class));
    }
    public void loadMain(View v)
    {
        SharedPreferences sharedpreferences = getSharedPreferences("Status", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedpreferences.edit();
        editor.putBoolean("st", true);
        editor.commit();
        startActivity(new Intent(this,HomeActivity.class));
    }

    public void loadRegistration(View v)
    {
        startActivity(new Intent(this,RegistrationActivity.class));
    }

    public void onFrogot(View v)
    {
        LinearLayout lr=findViewById(R.id.layoutForgotPass);
        lr.setVisibility(LinearLayout.VISIBLE);
    }
    public void onFogotCanel(View v)
    {
        LinearLayout lr=findViewById(R.id.layoutForgotPass);

        lr.setVisibility(LinearLayout.GONE);
    }


}