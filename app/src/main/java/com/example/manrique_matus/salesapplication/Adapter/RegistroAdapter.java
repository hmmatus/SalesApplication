package com.example.manrique_matus.salesapplication.Adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.manrique_matus.salesapplication.R;
import com.example.manrique_matus.salesapplication.ventas.Venta;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class RegistroAdapter extends RecyclerView.Adapter<RegistroAdapter.RegistroViewHolder> {
    ArrayList<Venta> ventas;
    Context context;
    String totalVenta;

    public static class RegistroViewHolder extends RecyclerView.ViewHolder{
        CardView cardview;
        TextView nomCliente,cantProducto,fecha,total_venta;

        public RegistroViewHolder(View itemView) {
            super(itemView);
            cardview=itemView.findViewById(R.id.cardview);
            nomCliente=itemView.findViewById(R.id.nomCliente);
            cantProducto=itemView.findViewById(R.id.cantProducto);
            fecha=itemView.findViewById(R.id.fecha);
            total_venta=itemView.findViewById(R.id.totalVenta);
        }
    }
    public  RegistroAdapter(Context context,ArrayList<Venta> ventas){
        this.context=context;
        this.ventas=ventas;
    }

    @Override
    public RegistroAdapter.RegistroViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_cardview_registro,parent,false);
        return (new RegistroViewHolder(v));
    }

    @Override
    public void onBindViewHolder(RegistroAdapter.RegistroViewHolder holder, int position) {
        //holder.nomProducto.setText(ventas.get(position).);
        holder.cantProducto.setText(String.valueOf(ventas.get(position).getCantidad_producto()));
        holder.fecha.setText(ventas.get(position).getFecha());
        totalVenta=ventas.get(position).getTotal_venta()+"";
        holder.total_venta.setText(totalVenta);
    }

    @Override
    public int getItemCount() {
        return ventas.size();
    }
}
