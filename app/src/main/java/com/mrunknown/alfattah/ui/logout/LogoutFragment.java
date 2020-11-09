package com.mrunknown.alfattah.ui.logout;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.mrunknown.alfattah.LoginActivity;
import com.mrunknown.alfattah.R;

public class LogoutFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_logout, container, false);
      changeStatus(root.getContext());
        startActivity(new Intent(root.getContext(), LoginActivity.class));

        return root;
    }
    public void changeStatus(Context context)
    {
        SharedPreferences sharedpreferences = context.getSharedPreferences("Status", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedpreferences.edit();
        editor.putBoolean("st", false);
        editor.commit();
    }
}