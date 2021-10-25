package com.example.sqlitedatabase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    FloatingActionButton add_button;

    mydatabase myDB;
    ArrayList<String> ID_Makanan, Nama_Makanan, Harga_Makanan;
    CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerview);
        add_button = findViewById(R.id.add_button);
        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Tambah_Item.class);
                startActivity(intent);
            }
        });

        myDB = new mydatabase(MainActivity.this);
        ID_Makanan = new ArrayList<>();
        Nama_Makanan = new ArrayList<>();
        Harga_Makanan = new ArrayList<>();

        displayData();
        recyclerView.setAdapter(customAdapter);
        customAdapter = new CustomAdapter(MainActivity.this, ID_Makanan, Nama_Makanan, Harga_Makanan);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
    }

    void displayData(){
        Cursor cursor = myDB.ReadData();
        if(cursor.getCount() == 0){
            Toast.makeText(this, "Tidak Ada Data", Toast.LENGTH_SHORT).show();
        }else
            while (cursor.moveToNext()){
                ID_Makanan.add(cursor.getString(0));
                Nama_Makanan.add(cursor.getString(1));
                Harga_Makanan.add(cursor.getString(2));
            }
    }

}