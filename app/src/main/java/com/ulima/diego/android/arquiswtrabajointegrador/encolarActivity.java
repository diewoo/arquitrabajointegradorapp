package com.ulima.diego.android.arquiswtrabajointegrador;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.ulima.diego.android.arquiswtrabajointegrador.Conexion.conexion;
import com.ulima.diego.android.arquiswtrabajointegrador.Interfaces.UsuariosService;
import com.ulima.diego.android.arquiswtrabajointegrador.beans.Consumos;
import com.ulima.diego.android.arquiswtrabajointegrador.beans.Respuesta;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import cn.pedant.SweetAlert.SweetAlertDialog;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by Diego Renteria on 28/11/2016.
 */

public class encolarActivity extends AppCompatActivity {
    EditText fecha;
    EditText nombre;
    EditText eteconsumo;
    String nro="";
    FloatingActionButton butGuardar;
       String nombreepersona = "";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.encolar_layout);


        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd ");
        Date date = new Date();


        final String strLong = dateFormat.format(date);

        Bundle extras = getIntent().getExtras();
        fecha = (EditText) findViewById(R.id.fecha);
        nombre = (EditText) findViewById(R.id.nombre);
        eteconsumo = (EditText) findViewById(R.id.consumo);
        butGuardar = (FloatingActionButton) findViewById(R.id.butGuardar);
        //final String name=extras.getString("nombre");
        ///nombreepersona=extras.getString("nombre");

            if (extras == null) {
                fecha.setText(strLong);
                nombre.setText(nombreepersona);
            } else {
                fecha.setText(extras.getString("fecha"));
                nombre.setText(extras.getString("nombre"));
                nro=extras.getString("nrosuministro");
            }

        /* String user="";
        user=extras.getString("nombre");
        String fecha="";
        fecha=extras.getString("fecha");*/

            butGuardar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (eteconsumo.getText().toString().equalsIgnoreCase("")) {
                        new SweetAlertDialog(encolarActivity.this)
                                .setTitleText("Alerta!")
                                .setContentText("Campos vacios, revisar!")
                                .show();
                    } else {
                        conexion conexion = new conexion();
                        Retrofit retrofit = conexion.getConexion();
                        UsuariosService usuariosService = retrofit.create(UsuariosService.class);

                        Consumos consumos = new Consumos();
                        consumos.setConsumo(eteconsumo.getText().toString());
                        consumos.setFecha(strLong);
                        consumos.setNroSuministro(nro);


                        Call<Respuesta> consumoUsuarioCall = usuariosService.encolarConsumo(consumos);
                        consumoUsuarioCall.enqueue(new Callback<Respuesta>() {
                            @Override
                            public void onResponse(Call<Respuesta> call, Response<Respuesta> response) {
                                int status = response.code();
                                Respuesta respuesta = response.body();

                                Toast.makeText(encolarActivity.this, "Se agrego a la cola , todo bien!", Toast.LENGTH_SHORT).show();

                                // Intent intent = new Intent(encolarActivity.this, encolarActivity.class);

                                //   Log.i("LOGUEARSE.COM","id"+resultado.getStatus().getCod());
                               // startActivity(intent);


                            }

                            @Override
                            public void onFailure(Call<Respuesta> call, Throwable t) {

                                Toast.makeText(encolarActivity.this, "Hubo un error en la conexión", Toast.LENGTH_SHORT).show();

                            }
                        });
                    }
                }
            });
        }


    }

