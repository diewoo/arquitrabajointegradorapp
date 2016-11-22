package com.ulima.diego.android.arquiswtrabajointegrador;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.ulima.diego.android.arquiswtrabajointegrador.Conexion.conexion;
import com.ulima.diego.android.arquiswtrabajointegrador.Interfaces.UsuariosService;
import com.ulima.diego.android.arquiswtrabajointegrador.beans.Respuesta;
import com.ulima.diego.android.arquiswtrabajointegrador.beans.Usuario;

import cn.pedant.SweetAlert.SweetAlertDialog;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by Diego Renteria on 17/11/2016.
 */

public class LoginActivity extends AppCompatActivity {
    EditText eteusuario,etepassword;
    Button butLogin,butRegistro;
    String userid="";
    String registro="";
    int id=0;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle extras = getIntent().getExtras();
     /*   if (extras != null) {
            registro = extras.getString("registro");
            new SweetAlertDialog(LoginAcitvity.this)
                    .setTitleText("Alerta!")
                    .setContentText(registro)
                    .show();
        }*/
      /*  if(savedInstanceState!=null){
            id=savedInstanceState.getInt("id");
        }*/

        setContentView(R.layout.login_activity);
        eteusuario=(EditText) findViewById(R.id.usuario);
        etepassword=(EditText) findViewById(R.id.password);
        butLogin=(Button) findViewById(R.id.butLogin);

    butLogin.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(eteusuario.getText().toString().equalsIgnoreCase("")||etepassword.getText().toString().equalsIgnoreCase("")){
                new SweetAlertDialog(LoginActivity.this)
                        .setTitleText("Alerta!")
                        .setContentText("Campos vacios, revisar!")
                        .show();
            }else {
                conexion conexion=new conexion();
                Retrofit retrofit = conexion.getConexion();
                UsuariosService usuariosService = retrofit.create(UsuariosService.class);
                Usuario usuario=new Usuario();
                usuario.setUsername(eteusuario.getText().toString());
                usuario.setPassword(etepassword.getText().toString());
                Call<Respuesta> usuarioCall=usuariosService.login(usuario);
                 usuarioCall.enqueue(new Callback<Respuesta>() {
                      @Override
                     public void onResponse(Call<Respuesta> call, Response<Respuesta> response) {
                         Respuesta resultado=response.body();
                         int status=response.code();
                         if(resultado.getStatus().getCod()==1){
                          // userid = resultado.getUser().getId();
                             Intent intent= new Intent(LoginActivity.this,registro_activity.class);
                          //    intent.putExtra("username",id);
                          //   Log.i("LOGUEARSE.COM","id"+resultado.getStatus().getCod());
                             startActivity(intent);

                         }else{
                             new SweetAlertDialog(LoginActivity.this)
                                     .setTitleText("Alerta!")
                                     .setContentText(
                                             resultado.getStatus().getMsg().toString())
                                     .show();
                         }
                         Log.d("MainActivity","STATUS: " + status);

                     }

                     @Override
                     public void onFailure(Call<Respuesta> call, Throwable t) {

                     }
                 });


            }
        }
    });
    }
}
