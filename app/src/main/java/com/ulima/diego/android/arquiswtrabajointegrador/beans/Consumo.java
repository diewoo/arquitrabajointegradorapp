package com.ulima.diego.android.arquiswtrabajointegrador.beans;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Diego Renteria on 20/11/2016.
 */

public class Consumo {

    @SerializedName("fechamedicion")
    @Expose
    private String fecha;
    @SerializedName("consumo")
    @Expose
    private Float consumo;

    public Consumo() {
    }

    public Consumo(String fecha, Float consumo) {
        this.fecha = fecha;
        this.consumo = consumo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Float getConsumo() {
        return consumo;
    }

    public void setConsumo(Float consumo) {
        this.consumo = consumo;
    }
}


