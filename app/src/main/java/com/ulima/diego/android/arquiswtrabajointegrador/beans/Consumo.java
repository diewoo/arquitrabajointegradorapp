package com.ulima.diego.android.arquiswtrabajointegrador.beans;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Diego Renteria on 17/11/2016.
 */

public class Consumo {
    @SerializedName("usuario")
    @Expose
    private String usuario;
    @SerializedName("nroSuministro")
    @Expose
    private String nroSuministro;
    @SerializedName("consumos")
    @Expose
    private List<Consumo> consumos = new ArrayList<Consumo>();

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getNroSuministro() {
        return nroSuministro;
    }


    public void setNroSuministro(String nroSuministro) {
        this.nroSuministro = nroSuministro;
    }

    public List<Consumo> getConsumos() {
        return consumos;
    }

    public void setConsumos(List<Consumo> consumos) {
        this.consumos = consumos;
    }

}



