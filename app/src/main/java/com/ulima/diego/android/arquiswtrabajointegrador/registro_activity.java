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

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

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
    FloatingActionButton butGuardar;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registro_activity);
        eteSuministro=(EditText)findViewById(R.id.eteSuministro);
        butGuardar=(FloatingActionButton)findViewById(R.id.butGuardar);
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd ");
        Date date = new Date();


        final String strLong = dateFormat.format(date);

        butGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(eteSuministro.getText().toString().equalsIgnoreCase("")){
                    new SweetAlertDialog(registro_activity.this)
                            .setTitleText("Alerta!")
                            .setContentText("Campos vacios, revisar!")
                            .show();
                }else{
                    conexion conexion=new conexion();
                    Retrofit retrofit = conexion.getConexion();
                    UsuariosService usuariosService = retrofit.create(UsuariosService.class);

                    Consumos consumos=new Consumos();
                    consumos.setNroSuministro(eteSuministro.getText().toString());


                    Call<Respuesta> consumoUsuarioCall=usuariosService.validarClienteyagregarConsumo(consumos);
                    consumoUsuarioCall.enqueue(new Callback<Respuesta>() {
                        @Override
                        public void onResponse(Call<Respuesta> call, Response<Respuesta> response) {
                            int status = response.code();
                            Respuesta respuesta = response.body();
                            if (respuesta.getStatus().getCod() == 1) {
                                Toast.makeText(registro_activity.this, respuesta.getStatus().getMsg(), Toast.LENGTH_SHORT).show();

                                Intent intent= new Intent(registro_activity.this,encolarActivity.class);
                                   intent.putExtra("fecha",strLong);
                                    intent.putExtra("nombre",respuesta.getStatus().getNombre());
                                intent.putExtra("nrosuministro",respuesta.getStatus().getNrosuministro());
                                //   Log.i("LOGUEARSE.COM","id"+resultado.getStatus().getCod());
                                startActivity(intent);


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

