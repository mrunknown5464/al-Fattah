package com.mrunknown.alfattah;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.mrunknown.alfattah.Database.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class RegistrationActivity extends AppCompatActivity {

    Connection con;
    PreparedStatement ptmt=null;
    String fname,lname,email,password,password2;
    int contact;
    DbConnection db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        overridePendingTransition(R.anim.act_fade_in,R.anim.act_fade_out);
        fname=findViewById(R.id.txtFirstName).toString();
        lname=findViewById(R.id.txtLastName).toString();
        email=findViewById(R.id.txtEmail).toString();
        password=findViewById(R.id.password).toString();
        password2=findViewById(R.id.password2).toString();
        contact=12345;
    }

    public void newRegistration(View v)
    {
        Toast.makeText(this, "Registration starts ", Toast.LENGTH_SHORT).show();
        try{
            db=new DbConnection();
            con= db.getDbConnection(this);
            ptmt=con.prepareStatement("insert into userdetail(firstName,lastName,email,mobile) values(?,?,?,?)");
            ptmt.setString(1,fname);
            ptmt.setString(2,lname);
            ptmt.setString(3,email);
            ptmt.setInt(4,contact);
            ptmt.executeUpdate();

            ptmt=con.prepareStatement("insert into logindetail(mobile,password) values(?,?)");
            ptmt.setInt(1,contact);
            ptmt.setString(2,password);
            ptmt.executeUpdate();

            Toast.makeText(this, "Registration successfull", Toast.LENGTH_SHORT).show();
        }
        catch(Exception e)
        {
            Toast.makeText(this, "Registration : "+e.toString(), Toast.LENGTH_SHORT).show();
        }
    }
}
