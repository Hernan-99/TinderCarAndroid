package com.example.tindercarapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.tindercarapp.R;
import com.example.tindercarapp.domain.VehiculoDomain;

import java.util.ArrayList;

public class VehiculoAdapter extends RecyclerView.Adapter<VehiculoAdapter.ViewHolder> {

    ArrayList<VehiculoDomain> vehiculoDomains;

    public VehiculoAdapter(ArrayList<VehiculoDomain> vehiculoDomains) {
        this.vehiculoDomains = vehiculoDomains;
    }


    @NonNull
    @Override
    public VehiculoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_vehiculo, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull VehiculoAdapter.ViewHolder holder, int position) {
        holder.vehiculoNombre.setText(vehiculoDomains.get(position).getTipoVehiculo());
        String imgUrl = "";
        switch (position){

            case 0:{
                imgUrl="auto";
                holder.mainLayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(), R.drawable.bg_vehiculo));
                break;
            }
            case 1:{
                imgUrl="moto";
                holder.mainLayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(), R.drawable.bg_vehiculo));
                break;
            }
            case 2:{
                imgUrl="camioneta";
                holder.mainLayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(), R.drawable.bg_vehiculo));
                break;
            }
        }

        int drawableResourceId = holder.itemView.getContext().getResources().getIdentifier(imgUrl, "drawable", holder.itemView.getContext().getPackageName());

        Glide.with(holder.itemView.getContext())
                .load(drawableResourceId)
                .into(holder.vehiculoImagen);
    }

    @Override
    public int getItemCount() {
        return vehiculoDomains.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView vehiculoNombre;
        ImageView vehiculoImagen;
        ConstraintLayout mainLayout;

      public ViewHolder(View itemView){
          super(itemView);
          vehiculoNombre = itemView.findViewById(R.id.vehiculoNombre);
          vehiculoImagen = itemView.findViewById(R.id.vehiculoImagen);
          mainLayout = itemView.findViewById(R.id.mainLayout2);
      }

    }
}
