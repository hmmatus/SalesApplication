package com.example.manrique_matus.salesapplication.ventas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.manrique_matus.salesapplication.Activities.FormCliente;
import com.example.manrique_matus.salesapplication.Adapter.CantProductoAdapter;
import com.example.manrique_matus.salesapplication.Adapter.RegistroVentasAdapter;
import com.example.manrique_matus.salesapplication.R;
import com.example.manrique_matus.salesapplication.WebService.WebService;
import com.example.manrique_matus.salesapplication.productos.Producto;

import java.util.concurrent.ExecutionException;

public class RegistroVentas extends AppCompatActivity {
    RecyclerView rv;
    RegistroVentasAdapter myadapter;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_ventas);
        LinearLayoutManager lManager;
        lManager = new LinearLayoutManager( this);
        rv = (RecyclerView) (findViewById(R.id.recyclerventa));
        rv.setLayoutManager(lManager);
        try {
            new WebService(3,this, myadapter,rv).execute().get();


        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
    public View comprar(View a){
        intent=new Intent(getApplicationContext(),cantproducto.class);
        startActivity(intent);
        finish();
        return a;
    }
}
