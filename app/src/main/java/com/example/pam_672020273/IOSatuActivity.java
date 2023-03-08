package com.example.pam_672020273;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class IOSatuActivity extends AppCompatActivity {
    private EditText txtJari;
    private EditText txtTinggi;
    private TextView txtVolume;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iosatu);
        txtJari = (EditText) findViewById(R.id.editText1);
        txtTinggi = (EditText) findViewById(R.id.editText2);
        txtVolume = (TextView) findViewById(R.id.txtHasil);
    }

    public void onClick(View view) {
        int r = Integer.parseInt(txtJari.getText().toString());
        int t = Integer.parseInt(txtJari.getText().toString());
        double l = Math.PI * r * r * t;
        txtVolume.setText(String.format("%3.2f",l));
    }

    public void exitClick(View v){
        this.finish();
    }
}