package com.pendekarcoding.realm;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class EditSiswa extends AppCompatActivity {

    private int posisi;
    private Button hapus, edit;
    private EditText inama, ialamat;
    private RealmHelper realmHelper;
    private String nama, alamat, intentNama, intentAlamat;;
    private ArrayList<ModelSiswa> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_siswa);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        realmHelper = new RealmHelper(EditSiswa.this);
        data = new ArrayList<>();
        posisi = getIntent().getIntExtra("id", 0);
        intentNama = getIntent().getStringExtra("nama");
        intentAlamat = getIntent().getStringExtra("alamat");

        hapus = (Button) findViewById(R.id.hapuse);
        edit = (Button) findViewById(R.id.simpane);

        inama = (EditText) findViewById(R.id.namae);
        ialamat = (EditText) findViewById(R.id.alamate);
        inama.setText(intentNama);
        ialamat.setText(intentAlamat);
        hapus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                realmHelper.deleteSiswa(posisi);
                startActivity(new Intent(getApplicationContext(), ActivityUtama.class));
                finish();
            }
        });
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nama = inama.getText().toString();
                alamat = ialamat.getText().toString();

                //melakukan update artikel
                realmHelper.updateSiswa(posisi, nama, alamat);
                startActivity(new Intent(getApplicationContext(), ActivityUtama.class));
                finish();

            }
        });

    }

}
