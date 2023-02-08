package com.example.pam_672020273;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import kotlin.reflect.KFunction;

public class MainActivity extends AppCompatActivity {
    private TextView txtHasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtHasil = (TextView) findViewById(R.id.txtHasil);
    }

    public void gantiActivity(View v){
        switch (v.getId()){
            case R.id.btnMerah:
                Intent iRed = new Intent(this, RedActivity.class);
                this.startActivity(iRed);
                break;
            case R.id.btnHijau:
                Intent iGreen = new Intent(this, HijauActivity.class);
                this.startActivity(iGreen);
                break;
            case R.id.btnBiru:
                Intent iBlue = new Intent(this, BiruActivity.class);
                this.startActivity(iBlue);
                break;
            case R.id.btnRestful:
                Intent iRestful = new Intent(this, RestfulActivity.class);
                this.startActivity(iRestful);
                break;
        }
    }
}