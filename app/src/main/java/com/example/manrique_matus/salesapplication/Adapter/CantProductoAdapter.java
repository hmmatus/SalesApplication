package com.example.manrique_matus.salesapplication.Adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.manrique_matus.salesapplication.R;
import com.example.manrique_matus.salesapplication.productos.Producto;
import com.example.manrique_matus.salesapplication.ventas.Venta;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class CantProductoAdapter extends RecyclerView.Adapter<CantProductoAdapter.CantProductViewHolder> {
    ArrayList<Producto> producto=new ArrayList<>();

    public static class CantProductViewHolder extends RecyclerView.ViewHolder{
        CardView cardview;
        TextView nomProducto,cantProducto,descripcion;

        public CantProductViewHolder(View itemView) {
            super(itemView);
            cardview=itemView.findViewById(R.id.cantproducto_card_view);
            nomProducto=itemView.findViewById(R.id.txttitvent);
            descripcion= itemView.findViewById(R.id.txtdescvent);
            cantProducto= itemView.findViewById(R.id.cantProducto);

        }
    }

    @Override
    public CantProductoAdapter.CantProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_card_producto,parent,false);
        return (new CantProductViewHolder(v));
    }

    @Override
    public void onBindViewHolder(CantProductoAdapter.CantProductViewHolder holder, int position) {
        holder.nomProducto.setText(producto.get(position).getNombre_producto());
        holder.descripcion.setText(producto.get(position).getDesc_producto());

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
