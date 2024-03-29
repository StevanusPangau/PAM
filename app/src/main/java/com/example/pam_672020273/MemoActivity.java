package com.example.pam_672020273;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MemoActivity extends AppCompatActivity {
    private DBHelperMemo mydb;
    TextView txtJudul;
    TextView txtPembuat;
    TextView txtPenerbit;
    TextView txtAbstrak;
    int id_To_Update = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memo);
        txtJudul =(TextView) findViewById(R.id.txtJudul);
        txtPembuat =(TextView) findViewById(R.id.txtPembuat);
        txtPenerbit =(TextView) findViewById(R.id.txtPenerbit);
        txtAbstrak =(TextView) findViewById(R.id.txtAbstrak);
        mydb = new DBHelperMemo(this);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            int paramId = extras.getInt("id");
            if (paramId > 0) {
                Cursor rs = mydb.getData(paramId);
                id_To_Update = paramId;
                rs.moveToFirst();
                @SuppressLint("Range") String judul = rs.getString(rs.getColumnIndex(DBHelperMemo.COLUMN_JUDUL));
                @SuppressLint("Range") String pembuat = rs.getString(rs.getColumnIndex(DBHelperMemo.COLUMN_PEMBUAT));
                @SuppressLint("Range") String penerbit = rs.getString(rs.getColumnIndex(DBHelperMemo.COLUMN_PENERBIT));
                @SuppressLint("Range") String abstrak = rs.getString(rs.getColumnIndex(DBHelperMemo.COLUMN_ABSTRAK));
                if (!rs.isClosed()) rs.close();
                txtJudul.setText((CharSequence) judul);
                txtPembuat.setText((CharSequence) pembuat);
                txtPenerbit.setText((CharSequence) penerbit);
                txtAbstrak.setText((CharSequence) abstrak);
                Toast.makeText(this,"proses ubah data " + String.valueOf(paramId),Toast.LENGTH_LONG).show();
            } else
                Toast.makeText(this,"proses tambah data",Toast.LENGTH_LONG).show();
        }
    }

    public void btnClicked(View v){
        switch (v.getId()) {
            case R.id.btnSimpan:
                Snackbar.make(v, "simpan", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                int s=simpan(v);
                setResult(s, null);
                this.finish();
                break;
            case R.id.btnHapus:
                Snackbar.make(v, "hapus", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                hapus(v);
                setResult(2, null);
                break;
            case R.id.btnKembali: setResult(-1, null);this.finish();
                break;
        }
    }

    private int simpan(View v){
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            int id = extras.getInt("id");
            if (id==0){
                try {
                    if (mydb.insertData(txtJudul.getText().toString(), txtPembuat.getText().toString(), txtPenerbit.getText().toString(), txtAbstrak.getText().toString())) {
                        Toast.makeText(getApplicationContext(), "data tercatat",
                                Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "ada kesalahan",
                                Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception e) {
                    Log.d("________________bepung",e.getMessage());
                    return 0;
                }
            } else { //update data
                try {
                    if (mydb.updateData(id,txtJudul.getText().toString(), txtPembuat.getText().toString(), txtPenerbit.getText().toString(), txtAbstrak.getText().toString())) {
                        Toast.makeText(getApplicationContext(), "data "+String.valueOf(id)+" tersimpan",
                                Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "ada kesalahan",
                                Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception e) {
                    Log.d("________________bepung",e.getMessage());
                    return 0;
                }
            }
            return 1;
        }
        return 0;
    }

    private void hapus(View v){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(R.string.deleteContact)
                .setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        mydb.deleteData(id_To_Update);
                        Toast.makeText(getApplicationContext(), "data terhapus",
                                Toast.LENGTH_SHORT).show();
                        finish();
                    }
                })
                .setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Toast.makeText(getApplicationContext(), "batal hapus",
                                Toast.LENGTH_SHORT).show();
                        dialog.cancel();
                        finish();
                    }
                });
        AlertDialog d = builder.create();
        d.setTitle("Konfirmasi");
        d.show();
    }
}