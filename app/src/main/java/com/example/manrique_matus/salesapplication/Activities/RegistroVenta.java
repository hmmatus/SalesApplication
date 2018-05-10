package com.example.manrique_matus.salesapplication.Activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.example.manrique_matus.salesapplication.Adapter.RegistroAdapter;
import com.example.manrique_matus.salesapplication.Classes.Vendedor;
import com.example.manrique_matus.salesapplication.R;
import com.example.manrique_matus.salesapplication.WebService.WebService;
import com.example.manrique_matus.salesapplication.ventas.Venta;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class RegistroVenta extends AppCompatActivity {
    RecyclerView rv;
    RegistroAdapter ra;
    Vendedor v;
    String TAG="ActivityRegistros";
    ArrayList<Venta> ventas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        rv = findViewById(R.id.registrov);rv.setLayoutManager(new LinearLayoutManager(this));
        v = new Vendedor(1);
        //add();
       //ra=new RegistroAdapter(getApplicationContext(),ventas);
        Log.d(TAG, "onCreate: "+v.getIdVendedor());
        try {
            new WebService(3, this, v, rv, ra).execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
        rv.setAdapter(ra);

    }

    private void add(){
        ventas=new ArrayList<>();
        ventas.add(new Venta(1,"1",10,30,"Jesus"));
        ventas.add(new Venta(2,"1",10,30,"Jose"));
        ventas.add(new Venta(3,"1",10,30,"Judas"));
        ventas.add(new Venta(4,"1",10,30,"Juan"));
    }


}
