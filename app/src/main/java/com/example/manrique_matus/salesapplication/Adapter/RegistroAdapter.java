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
    private int layout;

    public static class RegistroViewHolder extends RecyclerView.ViewHolder{
        CardView cardview;
        TextView nomCliente,nomVendedor,fecha,total_venta;

        public RegistroViewHolder(View itemView) {
            super(itemView);
            cardview=itemView.findViewById(R.id.cardview);
            nomCliente=itemView.findViewById(R.id.nomCliente);
            nomVendedor=itemView.findViewById(R.id.nomvendedor);
            fecha=itemView.findViewById(R.id.fecha);
            total_venta=itemView.findViewById(R.id.totalVenta);
        }
    }

    public RegistroAdapter(ArrayList<Venta> ventas, Context context, int layout) {
        this.ventas = ventas;
        this.context = context;
        this.layout = layout;
    }

    @Override
    public RegistroAdapter.RegistroViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_cardview_registro,parent,false);
        return (new RegistroViewHolder(v));
    }

    @Override
    public void onBindViewHolder(RegistroAdapter.RegistroViewHolder holder, int position) {
        //holder.nomProducto.setText(ventas.get(position).);
        holder.fecha.setText("Fecha de venta: "+ventas.get(position).getFecha());
        holder.nomCliente.setText("Nombre de cliente: "+ventas.get(position).getNombre_cliente());
        holder.nomVendedor.setText("Vendedor: "+ventas.get(position).getNombre_vendedor());
        holder.total_venta.setText("Total venta: "+String.valueOf(ventas.get(position).getTotal_venta()));
    }

    @Override
    public int getItemCount() {
        return ventas.size();
    }
}
