package com.sujan.break_o_last.ui.dashboard;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.sujan.break_o_last.LoginActivity;
import com.sujan.break_o_last.R;
import com.sujan.break_o_last.SplashActivity;

public class DashboardFragment extends Fragment {



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
             View root = inflater.inflate(R.layout.fragment_dashboard, container, false);
        Intent intent = new Intent(getActivity(), LoginActivity.class);
        startActivity(intent);

        return root;

    }
}