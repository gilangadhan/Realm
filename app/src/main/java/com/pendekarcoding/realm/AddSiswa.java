package com.pendekarcoding.realm;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AddSiswa extends AppCompatActivity {
    private RealmHelper helper;
    private EditText inAlamat, inNama;
    private Button addButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_siswa);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        helper = new RealmHelper(AddSiswa.this);
        inNama = (EditText) findViewById(R.id.nama);
        inAlamat = (EditText) findViewById(R.id.alamat);
        addButton = (Button) findViewById(R.id.simpan);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nama, alamat;
                nama = inNama.getText().toString();
                alamat = inAlamat.getText().toString();
                helper.addSiswa(nama, alamat);

                startActivity(new Intent(getApplicationContext(), ActivityUtama.class));
                finish();
            }
        });
    }

}
