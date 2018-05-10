package com.example.manrique_matus.salesapplication.ventas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.example.manrique_matus.salesapplication.Adapter.CantProductoAdapter;
import com.example.manrique_matus.salesapplication.R;
import com.example.manrique_matus.salesapplication.WebService.WebService;

import java.util.concurrent.ExecutionException;

public class cantproducto extends AppCompatActivity {
    RecyclerView rv;
    CantProductoAdapter myadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cantproducto);
        rv = (RecyclerView) (findViewById(R.id.cantproductorecycler));
        try {
            new WebService(2,this, myadapter, rv).execute().get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
