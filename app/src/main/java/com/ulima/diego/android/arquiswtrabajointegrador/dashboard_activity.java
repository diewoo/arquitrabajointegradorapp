package com.ulima.diego.android.arquiswtrabajointegrador;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import cn.pedant.SweetAlert.SweetAlertDialog;

/**
 * Created by Diego Renteria on 20/11/2016.
 */

public class dashboard_activity  extends AppCompatActivity {
   Button butRegistrarConsumo,butProcesarConsumos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard_activity);
         butRegistrarConsumo= (Button) findViewById(R.id.butRegistrarConsumo);
             butProcesarConsumos = (Button) findViewById(R.id.butProcesarConsumos);

       // Bundle extras = getIntent().getExtras();
        butProcesarConsumos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new SweetAlertDialog(dashboard_activity.this)
                        .setTitleText("Alerta!")
                        .setContentText(
                                "falta implementar")
                        .show();
            }
        });

        butRegistrarConsumo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(dashboard_activity.this,registro_activity.class);

                startActivity(intent);

            }
        });

    }
}
