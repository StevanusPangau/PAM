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

public class Fragment_2Activity extends Fragment {
    View view;
    Button secondButton;
    String data;

    public void setData(String d) {
        this.data=d;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_fragment2, container, false);
        secondButton = (Button) view.findViewById(R.id.btn);
        secondButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Fragment dua.\n Data: "+data, Toast.LENGTH_LONG).show();
            }
        });
        return view;
    }
}