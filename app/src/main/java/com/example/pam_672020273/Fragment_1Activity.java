package com.example.pam_672020273;

import androidx.appcompat.app.AppCompatActivity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import android.os.Bundle;

public class Fragment_1Activity extends Fragment {
    View view;
    Button firstButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_fragment1, container, false);
        firstButton = (Button) view.findViewById(R.id.btn);
        firstButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Fragment Satu", Toast.LENGTH_LONG).show();
            }
        });
        return view;
    }
}