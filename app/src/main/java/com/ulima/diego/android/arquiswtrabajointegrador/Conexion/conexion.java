package com.ulima.diego.android.arquiswtrabajointegrador.Conexion;
import com.google.gson.Gson;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Diego Renteria on 17/11/2016.
 */

public class conexion {
    public static final String BASE_URL="http://192.168.56.1:3000/";
    public Retrofit getConexion(){
        Retrofit retrofit=new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                     .build();
        return retrofit;
    }
}
