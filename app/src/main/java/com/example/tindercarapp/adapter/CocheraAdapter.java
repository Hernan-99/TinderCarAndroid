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
import com.example.tindercarapp.domain.CocheraDomain;

import java.util.ArrayList;

public class CocheraAdapter extends RecyclerView.Adapter<CocheraAdapter.ViewHolder> {
    ArrayList<CocheraDomain> cocheraDomains;

    public CocheraAdapter(ArrayList<CocheraDomain> cocheraDomains) {
        this.cocheraDomains = cocheraDomains;
    }

    @NonNull
    @Override
    public CocheraAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_cochera, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull CocheraAdapter.ViewHolder holder, int position) {
        holder.cocheraTitulo.setText(cocheraDomains.get(position).getTituloCochera());
        holder.cocheraDescripcion.setText(cocheraDomains.get(position).getDescripcionCochera());
        String urlImgCochera = "";
        switch (position){

            case 0:{
                urlImgCochera="cochera_uno";
                holder.mainLayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(), R.drawable.bg_cochera));
                break;
            }
            case 1:{
                urlImgCochera="cochera_dos";
                holder.mainLayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(), R.drawable.bg_cochera));
                break;
            }
            case 2:{
                urlImgCochera="cochera_tres";
                holder.mainLayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(), R.drawable.bg_cochera));
                break;
            }

            case 3:{
                urlImgCochera="cochera_uno";
                holder.mainLayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(), R.drawable.bg_cochera));
                break;
            }
        }

        int drawableResourceId = holder.itemView.getContext().getResources().getIdentifier(urlImgCochera, "drawable", holder.itemView.getContext().getPackageName());

        Glide.with(holder.itemView.getContext())
                .load(drawableResourceId)
                .into(holder.cocheraImg);
    }

    @Override
    public int getItemCount() {
        return cocheraDomains.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView cocheraImg;
        TextView cocheraTitulo;
        TextView cocheraDescripcion;
        ConstraintLayout mainLayout;

        public ViewHolder(View itemView){
            super(itemView);
            cocheraImg = itemView.findViewById(R.id.cocheraImg);
            cocheraTitulo = itemView.findViewById(R.id.tituloCochera);
            cocheraDescripcion = itemView.findViewById(R.id.descripcionCochera);
            mainLayout = itemView.findViewById(R.id.mainLayout2);
        }
    }
}
