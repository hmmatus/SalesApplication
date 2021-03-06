package com.example.manrique_matus.salesapplication.Activities;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.manrique_matus.salesapplication.R;
import com.example.manrique_matus.salesapplication.Session.JSONParser;

import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class FormCliente extends AppCompatActivity   {


    //private static final String REGISTER_URL = "http://192.168.0.31:8000/SalesApp/addEvent.php";
    private static final String REGISTER_URL = "http://sales-app-com.stackstaging.com/WebServer/addEvent.php";
    //ids
    private static final String TAG_SUCCESS = "success";
    private static final String TAG_MESSAGE = "message";

    //private EditText nCliente;
    //private EditText aCliente;
    private ProgressDialog pDialog;
    public Button btnagrega;
    // JSON parser class


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_cliente);

        // Get Reference to variables
        //btnagrega = (Button) findViewById(R.id.agregarCliente);
        //nCliente = (EditText) findViewById(R.id.nombrec);
        //aCliente = (EditText) findViewById(R.id.apellidoc);

    }

    JSONParser jsonParser;

    public void agregarCliente(View v) {


            new CrearEvento().execute();

    }

    public class CrearEvento extends AsyncTask<String, String, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(FormCliente.this);
            pDialog.setMessage("Agregando Cliente...");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(true);
            pDialog.show();
            btnagrega = (Button) findViewById(R.id.agregarCliente);

        }

        @Override
        protected String doInBackground(String... args) {
            // TODO Auto-generated method stub
            // Check for success tag
           // int success;
            EditText nCliente = (EditText) findViewById(R.id.nombrec);
            EditText aCliente = (EditText) findViewById(R.id.apellidoc);

            String nombre = nCliente.getText().toString();
            String apellido = aCliente.getText().toString();

            try {
                // Building Parameters
                List params = new ArrayList();
                params.add(new BasicNameValuePair("nombre", nombre));
                params.add(new BasicNameValuePair("apellido", apellido));



                Log.d("request!", "starting");

                //Posting user data to script

                JSONObject json = jsonParser.makeHttpRequest(
                        REGISTER_URL, "POST", params);
                json.toString();


                // full json response
                Log.d("Registering attempt", json.toString());

                // json success element
                int success = json.getInt(TAG_SUCCESS);
                if (success == 1) {
                    Log.d("Cliente Creado!", json.toString());
                    finish();
                    return json.getString(TAG_MESSAGE);
                }else{
                    Log.d("Registering Failure!", json.getString(TAG_MESSAGE));
                    return json.getString(TAG_MESSAGE);

                }
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;

        }

        protected void onPostExecute(String file_url) {
            // dismiss the dialog once product deleted
            pDialog.dismiss();
            if (file_url != null) {
                Toast.makeText(FormCliente.this, file_url, Toast.LENGTH_LONG).show();
            }

        }
    }




}
