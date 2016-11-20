package com.ulima.diego.android.arquiswtrabajointegrador.beans;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Diego Renteria on 20/11/2016.
 */

public class Consumos {

    @SerializedName("usuario")
    @Expose
    private String usuario;
    @SerializedName("nrosuministro")
    @Expose
    private String nroSuministro;
    @SerializedName("fechamedicion")
    @Expose
    private String fecha;
    @SerializedName("consumo")
    @Expose
    private String consumo;
    /*@SerializedName("consumos")

    @Expose
    private List<Consumo> consumos = new ArrayList<Consumo>();*/

    public Consumos() {
    }

    public Consumos(String usuario, String nroSuministro, String fecha, String consumo) {
        this.usuario = usuario;
        this.nroSuministro = nroSuministro;
        this.fecha = fecha;
        this.consumo = consumo;
    }

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

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getConsumo() {
        return consumo;
    }

    public void setConsumo(String consumo) {
        this.consumo = consumo;
    }
}
