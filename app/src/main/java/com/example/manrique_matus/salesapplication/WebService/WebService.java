package com.example.manrique_matus.salesapplication.WebService;

import android.content.Context;
import android.os.AsyncTask;

import com.example.manrique_matus.salesapplication.Classes.Cliente;
import com.example.manrique_matus.salesapplication.Classes.Producto;
import com.example.manrique_matus.salesapplication.Classes.Vendedor;
import com.example.manrique_matus.salesapplication.Classes.Venta;

import java.util.ArrayList;

public class WebService extends AsyncTask<Void, Void, String>{
    //Cadena que guardara el JSON
    String response="";

    //Campos extras
    boolean flag=true;
    Context context;
    int condicion;
    Cliente cliente;
    Vendedor vendedor;
    Venta venta;

    //Arreglos de objetos
    ArrayList<Producto> productos=new ArrayList<>();
    ArrayList<Venta> ventas=new ArrayList<>();

    //URL
    String ip="";

    //Constructores

    //Constructor vacio

    public WebService() {
    }

    //Constructor con objeto Vendedor
    public WebService(int condicion,Context context,Vendedor vendedor){
        this.condicion=condicion;
        this.context=context;
        this.vendedor=vendedor;
    }

    //Constructor con objeto Cliente
    public WebService(int condicion,Context context,Cliente cliente){
        this.condicion=condicion;
        this.context=context;
        this.cliente=cliente;
    }

    //Constructor con venta
    public WebService(int condicion,Context context,Venta venta){
        this.condicion=condicion;
        this.context=context;
        this.venta=venta;
    }

    @Override
    protected void onPreExecute(){
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(Void... voids) {
        switch (condicion){
            case 1://Ingresa un cliente

        }

        return null;
    }

    @Override
    protected void onPostExecute(String result){

    }


    //Funcion que ingresa el cliente
    private void IngresarCliente(String url,Cliente cliente){
    }

    //Funcion que ingresa la venta
    private void IngresarVenta(String url,Venta venta){
    }

    //Funcion que recibe JSON de registros
    private String recibirRegistros(String url,Vendedor vendedor){
        StringBuilder constructor=null;
        String result="";

        return result;
    }


}
