package com.pendekarcoding.realm;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;

public class ActivityUtama extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RealmHelper  helper;
    private ArrayList<ModelSiswa> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_utama);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), AddSiswa.class));
            }
        });
        data = new ArrayList<>();
        helper = new RealmHelper(ActivityUtama.this);

        recyclerView = (RecyclerView) findViewById(R.id.RVSiswa);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        setRecycleView();
    }

    private void setRecycleView() {
        try {
            data = helper.findAllSiswa();
        }catch (Exception e){
            e.printStackTrace();
        }

        AdapterSIswa sIswa =  new AdapterSIswa(data, new AdapterSIswa.OnItemClickListener() {
            @Override
            public void onClick(ModelSiswa item) {
                Intent i = new Intent(getApplicationContext(), EditSiswa.class);
                i.putExtra("id", item.getId());
                i.putExtra("nama", item.getNama());
                i.putExtra("alamat", item.getAlamat());
                startActivity(i);

            }
        });
        recyclerView.setAdapter(sIswa);
    }

    @Override
    protected void onResume() {
        super.onResume();
        try {
            data = helper.findAllSiswa();
        }catch (Exception e){
            e.printStackTrace();
        }
        setRecycleView();
    }
}
