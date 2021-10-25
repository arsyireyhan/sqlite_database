package com.example.sqlitedatabase;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.myViewHolder> {

    private Context context;
    private ArrayList ID_Makanan, Nama_Makanan, Harga_Makanan;

    CustomAdapter(Context context, ArrayList ID_Makanan, ArrayList Nama_Makanan, ArrayList Harga_Makanan){
        this.context = context;
        this.ID_Makanan = ID_Makanan;
        this.Nama_Makanan = Nama_Makanan;
        this.Harga_Makanan = Harga_Makanan;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row, parent, false);
        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        holder.id_makanan_txt.setText(String.valueOf(ID_Makanan.get(position)));
        holder.nama_makanan_txt.setText(String.valueOf(Nama_Makanan.get(position)));
        holder.harga_makanan_txt.setText(String.valueOf(Harga_Makanan.get(position)));
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class myViewHolder extends RecyclerView.ViewHolder {

        TextView id_makanan_txt, nama_makanan_txt, harga_makanan_txt;


        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            id_makanan_txt = itemView.findViewById(R.id.id_makanan_txt);
            nama_makanan_txt = itemView.findViewById(R.id.nama_makanan_txt);
            harga_makanan_txt = itemView.findViewById(R.id.harga_makanan_txt);
        }
    }
}
