package com.example.pam_672020273;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class TTSActivity extends AppCompatActivity {
    private EditText txtKecepatan;
    private EditText txtWaktu;
    private EditText txtA;
    private TextView txtHasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ttsactivity);
        txtKecepatan = findViewById(R.id.txtKecepatan);
        txtWaktu = findViewById(R.id.txtWaktu);
        txtA = findViewById(R.id.txtA);
        txtHasil = findViewById(R.id.txtHasil);
    }

    public void onClick(View view) {
        int v = Integer.parseInt(txtKecepatan.getText().toString());
        int t = Integer.parseInt(txtWaktu.getText().toString());
        int a = Integer.parseInt(txtA.getText().toString());

        double hasil = (v * t) + (0.5 * a * t * t);

        txtHasil.setText(String.format("%3.2f",hasil));
    }
}