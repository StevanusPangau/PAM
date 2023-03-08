package com.example.pam_672020273;

import android.content.Intent;
import android.os.Bundle;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;

public class MemoliteMainActivity extends AppCompatActivity {
    DBHelperMemo mydb;
    private ListView obj;

    ActivityResultLauncher<Intent> activityLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
//                    override di bawah
                }
            }
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memolite_main);
        FloatingActionButton fab = findViewById(R.id.btnTambahMemo);
        mydb = new DBHelperMemo(this);
        ArrayList array_list = new ArrayList();
        array_list = mydb.getAllData();
        ArrayAdapter arrayAdapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1, array_list);
        obj = (ListView)findViewById(R.id.listView);
        obj.setAdapter(arrayAdapter);
        obj.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,long arg3) {
                int id_To_Search = arg2 + 1;
                Bundle dataBundle = new Bundle();
                dataBundle.putInt("id", id_To_Search);
                Intent intent = new Intent(getApplicationContext(),MemoActivity.class);
                intent.putExtras(dataBundle);
                activityLauncher.launch((intent));
//                startActivity(intent); //cara lama
            }
        });
    }
    public void addMemo(View v){
        Intent i = new Intent(this,MemoActivity.class);
        Bundle bundle = new Bundle();
        bundle.putInt("id",0);
        i.putExtras(bundle);
        activityLauncher.launch(i);
//        this.startActivityForResult(i,1);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode>=0){
            Intent memoliteMainActivity = new Intent(this, MemoliteMainActivity.class);
            startActivity(memoliteMainActivity);
            this.finish();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.menu_selesai) {
            this.finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}