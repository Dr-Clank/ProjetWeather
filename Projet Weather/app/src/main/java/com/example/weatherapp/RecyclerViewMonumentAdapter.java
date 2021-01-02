package com.example.weatherapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewMonumentAdapter  extends RecyclerView.Adapter<RecyclerViewMonumentAdapter.RecyclerViewHolder>  {
    private List<Monuments> dataModelMonuments;
    public RecyclerViewMonumentAdapter(List<Monuments> dataModelPatients) {this.dataModelMonuments = dataModelPatients; }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerViewHolder viewHolder;
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_recycler_view_list_monument_item, parent, false);
        viewHolder = new RecyclerViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewMonumentAdapter.RecyclerViewHolder holder, int position) {
        holder.tvNom.setText(String.valueOf(dataModelMonuments.get(position).getNom()));
    }

    @Override
    public int getItemCount() {
        return dataModelMonuments.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {
        TextView tvNom;

        public RecyclerViewHolder(@NonNull View itemView){
            super(itemView);
            tvNom = itemView.findViewById(R.id.textViewMonumentName);
        }
    }
}
