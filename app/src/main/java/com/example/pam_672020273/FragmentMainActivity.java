package com.example.pam_672020273;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatActivity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import android.os.Bundle;

public class FragmentMainActivity extends AppCompatActivity {
    Button btn1, btn2;
    EditText et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_main);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        et = (EditText) findViewById(R.id.editText1);
        btn1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                loadFragment(new Fragment_1Activity());
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                Fragment_2Activity f2=  new Fragment_2Activity();
                f2.setData(et.getText().toString());
                loadFragment(f2);
            }
        });
    }
    private void loadFragment(Fragment fragment) {
        FragmentManager fm = getFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.theFrame, fragment);
        fragmentTransaction.commit();
    }
}