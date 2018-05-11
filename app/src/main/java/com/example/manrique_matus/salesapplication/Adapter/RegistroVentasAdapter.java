package com.example.manrique_matus.salesapplication.Adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.manrique_matus.salesapplication.Classes.Cliente;
import com.example.manrique_matus.salesapplication.R;
import com.example.manrique_matus.salesapplication.ventas.RegistroVentas;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import static java.lang.StrictMath.log;

public class RegistroVentasAdapter extends RecyclerView.Adapter<RegistroVentasAdapter.RegistroVentasViewHolder> {
    ArrayList<Cliente> clientes;
    String[] spin ={""};
    Context context;
    static final String TAG = "LoadData";
    private int layout;


    public static class RegistroVentasViewHolder extends RecyclerView.ViewHolder{
        CardView cardview;
        Spinner nomCliente;
        public RegistroVentasViewHolder(View itemView) {
            super(itemView);
            nomCliente=(Spinner)itemView.findViewById(R.id.spinner);
        }
    }

    public RegistroVentasAdapter(ArrayList<Cliente> clientes, Context context, int layout) {
        this.clientes = clientes;
        this.context = context;
        this.layout = layout;
    }

    @Override
    public RegistroVentasAdapter.RegistroVentasViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_card_rventas,parent,false);
        return (new RegistroVentasViewHolder(v));
    }

    @Override
    public void onBindViewHolder(RegistroVentasAdapter.RegistroVentasViewHolder holder, int position) {
        //holder.nomProducto.setText(ventas.get(position).);
       // holder.nomCliente.setText("Nombre de cliente: "+ventas.get(position).getNombre_cliente());
        //spinner.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, letra));
        List<String> colors = new ArrayList<String>();
        colors=getClientesText(clientes);
        Log.d(TAG,"POBO"+colors.get(1));
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_item,colors);
        holder.nomCliente.setAdapter(adapter2);
    }

    @Override
    public int getItemCount() {
        return clientes.size();
    }

    public List<String> getClientesText(ArrayList<Cliente> clientes) {
        List<String> letra= new ArrayList<String>();
        for (int i=0; i<clientes.size();i++){
            letra.add(clientes.get(i).getNomCliente());
        }
        return letra;
    }
}
