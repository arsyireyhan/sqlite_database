package com.example.sqlitedatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class mydatabase extends SQLiteOpenHelper {
    private Context context;
    private static final String DATABASE_NAME = "Restoran.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "Menu";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_NAMA = "Nama_Makanan";
    private static final String COLUMN_HARGA = "Harga_Makanan";

    public mydatabase(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query =  "CREATE TABLE " + TABLE_NAME +
                " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_NAMA + " TEXT, " +
                COLUMN_HARGA + " INTEGER);";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    void TambahData(String Nama_Makanan, int Harga){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_NAMA, Nama_Makanan);
        cv.put(COLUMN_HARGA, Harga);
        long result = db.insert(TABLE_NAME, null, cv);
        if(result == -1){
            Toast.makeText(context, "gagal", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "berhasil", Toast.LENGTH_SHORT).show();
        }
    }

    Cursor ReadData(){
        String query = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if(db != null){
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }

}
