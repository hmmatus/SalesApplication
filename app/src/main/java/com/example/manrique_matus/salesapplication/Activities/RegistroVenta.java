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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        LinearLayoutManager lManager;
        lManager = new LinearLayoutManager( this);
        rv = (RecyclerView) findViewById(R.id.registrov);
        rv.setLayoutManager(lManager);
        //add();
       //ra=new RegistroAdapter(getApplicationContext(),ventas);
        try {
            new WebService(1, this, rv, ra).execute();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }




}
