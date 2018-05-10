package com.example.manrique_matus.salesapplication.WebService;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.manrique_matus.salesapplication.Activities.MenuPrincipal;
import com.example.manrique_matus.salesapplication.Adapter.CantProductoAdapter;
import com.example.manrique_matus.salesapplication.Adapter.RegistroAdapter;
import com.example.manrique_matus.salesapplication.Classes.Cliente;
import com.example.manrique_matus.salesapplication.R;
import com.example.manrique_matus.salesapplication.productos.Producto;
import com.example.manrique_matus.salesapplication.Classes.Vendedor;
import com.example.manrique_matus.salesapplication.ventas.Venta;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
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
    Producto producto;
    Venta venta;
    RecyclerView rv;
    RegistroAdapter adapter;
    CantProductoAdapter adapterprod;
    String url_producto ="http://sales-app-com.stackstaging.com/WebServer/productos.php";
    //Arreglos de objetos
    ArrayList<Producto> productos=new ArrayList<>();
    ArrayList<Venta> ventas=new ArrayList<>();

    //URL
    String ip="http://sales-app-com.stackstaging.com/WebServer/";

    //Constructores

    //Constructor vacio
    public WebService() {
    }
    //Constructor con objeto Producto
    public  WebService(int condicion,Context context, CantProductoAdapter adapterprod, RecyclerView rv){
        this.condicion=condicion;
        this.context=context;
        this.adapterprod=adapterprod;
        this.rv=rv;
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

    //Constructor Registro
    public WebService(int condicion, Context context, Vendedor vendedor, RecyclerView rv, RegistroAdapter adapter){
        this.condicion=condicion;
        this.context=context;
        this.vendedor=vendedor;
        this.rv=rv;
        this.adapter=adapter;
    }


    @Override
    protected void onPreExecute(){
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(Void... voids) {
        switch (condicion){
            case 1://Ingresa un cliente
                break;
            case 2: try {
                response=getInfoWeb(url_producto);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
                break;//para productos
        }

        return null;
    }

    @Override
    protected void onPostExecute(String result) {
        if (response == "") {
            Intent intent = new Intent(context, MenuPrincipal.class);
            context.startActivity(intent);
            Toast.makeText(context, "Se produjo un error de conexion., intente de nuevo mas tarde.", Toast.LENGTH_SHORT).show();
            ((Activity) context).finish();
        } else {
            switch (condicion) {
                case 1:
                    break;
                case 2:
                    try {
                        setProductshop(response);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    break;

            }

        }
    }
    public String getInfoWeb(String url) throws MalformedURLException {
        URL uri = new URL(url);
        String linea ="";
        StringBuilder result = null;
        int respuesta = 0;
        String exit="";
        try {
            // Log.d(TAG, "getInfoWeb: "URL"");
            HttpURLConnection httpCon = (HttpURLConnection)uri.openConnection();
            httpCon.setReadTimeout(20000);
            httpCon.setConnectTimeout(20000);
            httpCon.setDoInput(true);
            httpCon.setDoOutput(true);
            respuesta =httpCon.getResponseCode();
            result = new StringBuilder();
            if (respuesta == HttpURLConnection.HTTP_OK){
                //Log.d(TAG, "getInfoWeb: Funciona");
                InputStream in =new BufferedInputStream(httpCon.getInputStream());
                BufferedReader read = new BufferedReader(new InputStreamReader(in));
                while ((linea=read.readLine())!=null){
                    result.append(linea);
                }
                exit=result.toString();
            }
            else{
                flag=false;

            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        // Log.d(TAG, "getInfoWeb:"+result.toString()+"");
        return exit;
    }
    public void setProductshop(String jsonCad) throws JSONException {
        JSONArray jsonArr=new JSONArray(jsonCad);
        for (int i=0;i<jsonArr.length();i++){
            productos.add(new Producto(jsonArr.getJSONObject(i).getInt("id_producto"),
                    jsonArr.getJSONObject(i).getString("nombre_producto"),
                    jsonArr.getJSONObject(i).getString("desc_producto"),
                    jsonArr.getJSONObject(i).getDouble("precioUnit"),
                    jsonArr.getJSONObject(i).getDouble("largo"),
                    jsonArr.getJSONObject(i).getDouble("ancho"),
                    jsonArr.getJSONObject(i).getDouble("area")
                   ));
        }
        /*Log.d(TAG, "setWorkshop: "+ws.get(0).getNomTaller()+"");
        Log.d(TAG, "setWorkshop: "+ws.get(0).getIdTaller()+"");
        Log.d(TAG, "setWorkshop: "+ws.get(0).getFechaTaller()+"");
        Log.d(TAG, "setWorkshop: "+ws.get(0).getNomCategoria()+"");
        Log.d(TAG, "setWorkshop: "+ws.get(0).getImgTaller()+"");*/

        adapterprod=new CantProductoAdapter(productos,context, R.layout.activity_cantproducto);
        rv.setAdapter(adapterprod);

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
