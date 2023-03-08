package com.example.pam_672020273;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.nio.file.Files;

public class IODuaActivity extends AppCompatActivity {

    private EditText editTinggi;
    private EditText editJari;
    private TextView viewVolume;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iodua);
        editTinggi = (EditText) findViewById(R.id.txtTinggi);
        editJari = (EditText) findViewById(R.id.txtJari);
        viewVolume = (TextView) findViewById(R.id.txtVolume);
    }
    public void hitungVolume(View view){
        int r = Integer.parseInt(editJari.getText().toString());
        int t = Integer.parseInt(editTinggi.getText().toString());
        Tabung tbg = new Tabung(r,t);
        viewVolume.setText(String.format("%5.3f", tbg.getVolume()   ));
        //viewVolume.setText(String.format("%3.2f",v));
    }

    public void exitClick(View v){
        this.finish();
    }
}