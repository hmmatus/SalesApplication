package com.example.manrique_matus.salesapplication.Activities;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.manrique_matus.salesapplication.R;
import com.example.manrique_matus.salesapplication.Session.SessionManager;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Login extends AppCompatActivity {

    // CONNECTION_TIMEOUT and READ_TIMEOUT are in milliseconds

    public static final int CONNECTION_TIMEOUT = 10000;
    public static final int READ_TIMEOUT = 15000;
    private EditText etUser;
    private EditText etPassword;
    private static final String LOGIN_URL = "http://sales-app-com.stackstaging.com/WebServer/login.inc.php";

    // La respuesta del JSON es
    private static final String TAG_SUCCESS = "success";
    private static final String TAG_MESSAGE = "message";


    SessionManager session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        session = new SessionManager(getApplicationContext());

        // Get Reference to variables
        etUser = (EditText) findViewById(R.id.userLogin);
        etPassword = (EditText) findViewById(R.id.passLogin);
    }

    // Triggers when LOGIN Button clicked
    public void checkLogin(View arg0) {

        // Get text from email and passord field
        final String user = etUser.getText().toString();
        final String password = etPassword.getText().toString();
        if (validarTodo()) {
            // Initialize  AsyncLogin() class with email and password
           // new AsyncLogin().execute(user, password);
            LogSin();
        } else
            Toast.makeText(Login.this, "Ingresa tus datos correctamente", Toast.LENGTH_SHORT).show();

    }

    public boolean validarTodo() {
        EditText usuario = (EditText) findViewById(R.id.userLogin);
        EditText passw = (EditText) findViewById(R.id.passLogin);
        String user = usuario.getText().toString();
        String pass = passw.getText().toString();

        if ( validarEsp(user) == true || validarEspP(pass) == true ) {

            return false;
        } else
            return true;


    }

    public boolean validarEsp(String cadena) {
        EditText usua = (EditText) findViewById(R.id.userLogin);
        if (cadena.matches("")) {
            usua.setError("Esta vacio el campo Usuario");
            return true;
        }
        return false;
    }

    public boolean validarEspP(String cadena) {
        EditText usua = (EditText) findViewById(R.id.passLogin);
        if (cadena.matches("")) {
            usua.setError("Esta vacio el campo Contraseña");
            return true;
        }
        return false;
    }

    public boolean Patron(String x) {
        String c = x;
        EditText usu = (EditText) findViewById(R.id.userLogin);
        Pattern pattern = Pattern
                .compile("^[0]{3}[0-9]{3}[0-1]{1}[0-7]{1}$");

        Matcher mather = pattern.matcher(c);

        if (mather.find()) {

            return true;
        } else {
            usu.setError("No son datos válidos");
            return false;
        }

    }


     class AsyncLogin extends AsyncTask<String, String, String> {
        ProgressDialog pdLoading = new ProgressDialog(Login.this);
        HttpURLConnection conn;
        URL url = null;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            //this method will be running on UI thread
            pdLoading.setMessage("\tLoading...");
            pdLoading.setCancelable(false);
            pdLoading.show();

        }

        @Override
        protected String doInBackground(String... params) {
            try {

                // Enter URL address where your php file resides
                url = new URL("http://sales-app-com.stackstaging.com/WebServer/login.inc.php");
                // gamespm-com.stackstaging.com



            } catch (MalformedURLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                return "exception";
            }
            try {
                // Setup HttpURLConnection class to send and receive data from php and mysql
                conn = (HttpURLConnection) url.openConnection();
                conn.setReadTimeout(READ_TIMEOUT);
                conn.setConnectTimeout(CONNECTION_TIMEOUT);
                conn.setRequestMethod("POST");

                // setDoInput and setDoOutput method depict handling of both send and receive
                conn.setDoInput(true);
                conn.setDoOutput(true);

                // Append parameters to URL
                Uri.Builder builder = new Uri.Builder()
                        .appendQueryParameter("user_vendedor", params[0])
                        .appendQueryParameter("clave_vendedor", params[1]);
                String query = builder.build().getEncodedQuery();

                // Open connection for sending data
                OutputStream os = conn.getOutputStream();
                BufferedWriter writer = new BufferedWriter(
                        new OutputStreamWriter(os, "UTF-8"));
                writer.write(query);
                writer.flush();
                writer.close();
                os.close();
                conn.connect();

            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
                return "exception";
            }

            try {

                int response_code = conn.getResponseCode();

                // Check if successful connection made
                if (response_code == HttpURLConnection.HTTP_OK) {

                    // Read data sent from server
                    InputStream input = conn.getInputStream();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(input));
                    StringBuilder result = new StringBuilder();
                    String line;

                    while ((line = reader.readLine()) != null) {
                        result.append(line);
                    }

                    // Pass data to onPostExecute method
                    return (result.toString());

                } else {

                    return ("unsuccessful");
                }

            } catch (IOException e) {
                e.printStackTrace();
                return "exception";
            } finally {
                conn.disconnect();
            }


        }

        @Override
        protected void onPostExecute(String result) {

            //this method will be running on UI thread

            pdLoading.dismiss();

            if (result.equalsIgnoreCase("true")) {
                /* guardar datos de sesion*/
                session.createLoginSession(etUser.getText().toString());

                //Obtiene token para notifiaciones
                //Intent i = new Intent(getApplicationContext(), RegistrationService.class);
                //startService(i);

                Toast.makeText(Login.this, "Inicio de Sesión Perfecto", Toast.LENGTH_SHORT).show();


                Intent intent = new Intent(Login.this, MenuPrincipal.class);
                startActivity(intent);
                Login.this.finish();

            } else if (result.equalsIgnoreCase("false")) {

                // If username and password does not match display a error message
                Toast.makeText(Login.this, "No existe ese usuario", Toast.LENGTH_LONG).show();


            } else if (result.equalsIgnoreCase("exception") || result.equalsIgnoreCase("unsuccessful")) {

                Toast.makeText(Login.this, "Algo sucede con la conexión.", Toast.LENGTH_LONG).show();

            }
             else if ( result.equalsIgnoreCase("unsuccessful")) {

             Toast.makeText(Login.this, "Algo sucede con la conexión.", Toast.LENGTH_LONG).show();

         }
        }


    }

    public void LogSin() {
        Intent reg = new Intent(this, MenuPrincipal.class);
        startActivity(reg);
        Toast.makeText(Login.this,"Sesion iniciada con exito",Toast.LENGTH_LONG).show();

    }
}