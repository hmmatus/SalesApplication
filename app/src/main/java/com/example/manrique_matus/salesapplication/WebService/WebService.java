package com.example.manrique_matus.salesapplication.WebService;

import android.os.AsyncTask;

import com.example.manrique_matus.salesapplication.Classes.Cliente;
import com.example.manrique_matus.salesapplication.Classes.Producto;
import com.example.manrique_matus.salesapplication.Classes.Venta;

import java.util.ArrayList;

public class WebService extends AsyncTask<Void, Void, String>{
    //Cadena que guardara el JSON
    String response="";

    //Campos extras
    boolean flag=true;

    //Arreglos de objetos
    ArrayList<Producto> productos=new ArrayList<>();
    ArrayList<Venta> ventas=new ArrayList<>();

    //URL
    String ip="";

    @Override
    protected void onPreExecute(){
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(Void... voids) {
        return null;
    }

    @Override
    protected void onPostExecute(String result){

    }
}
