package com.example.manrique_matus.salesapplication.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.manrique_matus.salesapplication.R;
import com.example.manrique_matus.salesapplication.ventas.RegistroVentas;

public class MenuPrincipal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);
    }

    @Override
    public void onBackPressed(){
        super.onBackPressed();
        this.finish();
    }


    public void onClick(View v){
        Intent intent;
        switch (v.getId()){
            case R.id.cliente:
                intent=new Intent(getApplicationContext(),FormCliente.class);
                startActivity(intent);
                finish();
                break;
            case R.id.info:
                intent=new Intent(getApplicationContext(),Informacion.class);
                startActivity(intent);
                finish();
                break;
            case R.id.registro:
                intent=new Intent(getApplicationContext(),RegistroVentas.class);
                startActivity(intent);
                finish();
            case R.id.comprar:
                intent=new Intent(getApplicationContext(),RegistroVenta.class);
                startActivity(intent);
                finish();

        }
    }
}
