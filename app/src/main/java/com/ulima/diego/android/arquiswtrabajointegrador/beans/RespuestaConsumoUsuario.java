package com.ulima.diego.android.arquiswtrabajointegrador.beans;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Diego Renteria on 17/11/2016.
 */

public class RespuestaConsumoUsuario {
    @SerializedName("cod")
    @Expose
    private Integer cod;
    @SerializedName("msg")
    @Expose
    private String msg;


    public RespuestaConsumoUsuario() {
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

}
