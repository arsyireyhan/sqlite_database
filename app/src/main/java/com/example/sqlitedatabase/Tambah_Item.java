package com.example.sqlitedatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Tambah_Item extends AppCompatActivity {

    EditText NamaMakanan, HargaMakanan;
    Button AddButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah__item);

        NamaMakanan = findViewById(R.id.NamaMakanan);
        HargaMakanan = findViewById(R.id.HargaMakanan);
        AddButton = findViewById(R.id.AddButton);
        AddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mydatabase myDB = new mydatabase(Tambah_Item.this);
                myDB.TambahData(NamaMakanan.getText().toString().trim(),
                        Integer.valueOf(HargaMakanan.getText().toString().trim()));

            }
        });
    }
}