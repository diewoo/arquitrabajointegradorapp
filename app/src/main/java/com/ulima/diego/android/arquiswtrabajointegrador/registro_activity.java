package com.ulima.diego.android.arquiswtrabajointegrador;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ulima.diego.android.arquiswtrabajointegrador.Conexion.conexion;
import com.ulima.diego.android.arquiswtrabajointegrador.Interfaces.UsuariosService;
import com.ulima.diego.android.arquiswtrabajointegrador.beans.Consumo;
import com.ulima.diego.android.arquiswtrabajointegrador.beans.Consumos;
import com.ulima.diego.android.arquiswtrabajointegrador.beans.Respuesta;
import com.ulima.diego.android.arquiswtrabajointegrador.beans.RespuestaConsumoUsuario;

import cn.pedant.SweetAlert.SweetAlertDialog;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by Diego Renteria on 18/11/2016.
 */

public class registro_activity extends AppCompatActivity {
    EditText eteSuministro;
    EditText eteFecha;
    EditText eteConsumo;
    FloatingActionButton butGuardar;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registro_activity);
        eteSuministro=(EditText)findViewById(R.id.eteSuministro);
        eteFecha=(EditText)findViewById(R.id.etefecha);
        eteConsumo=(EditText)findViewById(R.id.eteconsumo);
        butGuardar=(FloatingActionButton)findViewById(R.id.butGuardar);

        butGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(eteSuministro.getText().toString().equalsIgnoreCase("")||
                   eteFecha.getText().toString().equalsIgnoreCase("")||
                    eteConsumo.getText().toString().equalsIgnoreCase("")){
                    new SweetAlertDialog(registro_activity.this)
                            .setTitleText("Alerta!")
                            .setContentText("Campos vacios, revisar!")
                            .show();
                }else{
                    conexion conexion=new conexion();
                    Retrofit retrofit = conexion.getConexion();
                    UsuariosService usuariosService = retrofit.create(UsuariosService.class);

                    Consumos consumos=new Consumos();
                    consumos.setConsumo(eteConsumo.getText().toString());
                    consumos.setFecha(eteFecha.getText().toString());
                    consumos.setNroSuministro(eteSuministro.getText().toString());


                    Call<Respuesta> consumoUsuarioCall=usuariosService.validarClienteyagregarConsumo(consumos);
                    consumoUsuarioCall.enqueue(new Callback<Respuesta>() {
                        @Override
                        public void onResponse(Call<Respuesta> call, Response<Respuesta> response) {
                            int status = response.code();
                            Respuesta respuesta = response.body();
                            if (respuesta.getStatus().getCod() == 1) {
                                new SweetAlertDialog(registro_activity.this)
                                        .setTitleText("Alerta!")
                                        .setContentText(respuesta.getStatus().getMsg().toString())
                                        .show();


                            } else {
                                new SweetAlertDialog(registro_activity.this)
                                        .setTitleText("Alerta!")
                                        .setContentText(respuesta.getStatus().getMsg().toString())
                                        .show();

                            }
                        }

                        @Override
                        public void onFailure(Call<Respuesta> call, Throwable t) {

                            Toast.makeText(registro_activity.this, "Hubo un error en la conexión", Toast.LENGTH_SHORT).show();

                        }
                    });
                }
            }
        });
    }
}

