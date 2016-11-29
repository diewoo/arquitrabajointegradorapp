package com.ulima.diego.android.arquiswtrabajointegrador.Interfaces;

import com.ulima.diego.android.arquiswtrabajointegrador.beans.Consumos;
import com.ulima.diego.android.arquiswtrabajointegrador.beans.Respuesta;
import com.ulima.diego.android.arquiswtrabajointegrador.beans.RespuestaConsumoUsuario;
import com.ulima.diego.android.arquiswtrabajointegrador.beans.Usuario;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by Diego Renteria on 17/11/2016.
 */

public interface UsuariosService {

    @POST("/usuario/login")
    Call<Respuesta> login(@Body Usuario usuario);
    @POST("/usuario/consumos")
    Call<Respuesta> validarClienteyagregarConsumo(@Body Consumos consumos);
    @POST("/usuario/cola")
    Call<Respuesta> encolarConsumo(@Body Consumos consumos);





}
