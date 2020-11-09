package com.mrunknown.alfattah.Database;
import android.content.Context;
import android.widget.Toast;

import com.mrunknown.alfattah.RegistrationActivity;

import java.sql.*;

public class DbConnection {



    public Connection getDbConnection(Context context) throws Exception {
        Connection con;

        String url = "";
        String username = "root";
        String password = "";

        Class.forName("com.mysql.jdbc.Driver").newInstance();
        con = DriverManager.getConnection("jdbc:mysql://192.168.43.58:3306/al_fattah", username, password);
        Toast.makeText(context, "connection successfull", Toast.LENGTH_SHORT).show();
        return con;
    }

}