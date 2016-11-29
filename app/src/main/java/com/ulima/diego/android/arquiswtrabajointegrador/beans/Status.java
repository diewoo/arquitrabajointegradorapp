package com.ulima.diego.android.arquiswtrabajointegrador.beans;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Diego Renteria on 18/11/2016.
 */

public class Status {
    @SerializedName("cod")
    @Expose
    private Integer cod;
    @SerializedName("msg")
    @Expose
    private String msg;
    @SerializedName("nrosuministro")
    @Expose
    private String nrosuministro;
    @SerializedName("nombre")
    @Expose
    private String nombre;


    public Status() {
    }


    public Integer getCod() {
        return cod;
    }

    public void setCod(Integer cod) {
        this.cod = cod;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getNrosuministro() {
        return nrosuministro;
    }

    public void setNrosuministro(String nrosuministro) {
        this.nrosuministro = nrosuministro;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
