package com.mrunknown.alfattah.ui.leadership;

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

import com.mrunknown.alfattah.R;

public class LeadershipFragment extends Fragment {

    private LeadershipViewModel leadershipViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        leadershipViewModel =
                ViewModelProviders.of(this).get(LeadershipViewModel.class);
        View root = inflater.inflate(R.layout.fragment_leadership, container, false);
        final TextView textView = root.findViewById(R.id.text_leadership);
        leadershipViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}