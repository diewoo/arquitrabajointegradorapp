package com.ulima.diego.android.arquiswtrabajointegrador.Interfaces;

import com.ulima.diego.android.arquiswtrabajointegrador.beans.Consumo;
import com.ulima.diego.android.arquiswtrabajointegrador.beans.Respuesta;
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
    @GET("/api/consumosusuarios")
    Call<Consumo> getConsumos();




}
