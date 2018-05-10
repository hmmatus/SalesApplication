package com.example.manrique_matus.salesapplication.Adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
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
    private Context context;
    private int layout;
    static final String TAG = "LoadData";

    public CantProductoAdapter(ArrayList<Producto> producto, Context context, int layout) {
        this.producto = producto;
        this.context = context;
        this.layout = layout;
    }

    public static class CantProductViewHolder extends RecyclerView.ViewHolder{
        CardView cardview;
        TextView nomProducto,descripcion;
        TextView largo, ancho, area, precio_unidad;

        public CantProductViewHolder(View itemView) {
            super(itemView);
            cardview=itemView.findViewById(R.id.cantproducto_card_view);
            nomProducto=itemView.findViewById(R.id.txttitvent);
            descripcion= itemView.findViewById(R.id.txtdescvent);
            largo = itemView.findViewById(R.id.txtlargo);
            ancho = itemView.findViewById(R.id.txtancho);
            area = itemView.findViewById(R.id.txtarea);
            precio_unidad = itemView.findViewById(R.id.txtprecioU);

        }
    }

    @Override
    public CantProductoAdapter.CantProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_card_producto,parent,false);
        return (new CantProductViewHolder(v));
    }

    @Override
    public void onBindViewHolder(CantProductoAdapter.CantProductViewHolder holder, int position) {
        holder.nomProducto.setText("Nombre :"+producto.get(position).getNombre_producto());
        holder.descripcion.setText("Descripción: "+producto.get(position).getDesc_producto());
        holder.largo.setText("Largo: "+String.valueOf(producto.get(position).getLargo()));
        holder.ancho.setText("Ancho: "+String.valueOf(producto.get(position).getAncho()));
        holder.area.setText("Área: "+String.valueOf(producto.get(position).getArea()));
        holder.precio_unidad.setText("Precio: "+String.valueOf(producto.get(position).getPrecioUnit()));
    }

    @Override
    public int getItemCount() {
        return producto.size();
    }
}
