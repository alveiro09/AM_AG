
package com.app.amejia_agrajales.am_ag;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class actIngresosMensuales extends Activity {
    Button fbtnAceptar;
    EditText fEditTextSueldo;
    EditText fEditTextIngresos;
    String fSueldo, fIngresos;
    private NotificationManager notifyMgr;
    NotificationManager nm;
    Notification notif;
    static String ns = Context.NOTIFICATION_SERVICE;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lytingresosmensuales);
        mCrerObjetos();
        mCrearEventos();
    }

    public void mCrerObjetos()
    {
        fbtnAceptar = (Button)findViewById(R.id.btnGrabar);
        fEditTextSueldo = (EditText)findViewById(R.id.etSueldoNeto);
        fEditTextIngresos = (EditText)findViewById(R.id.etIngresos);
    }


    public void mGuardar(){
        fSueldo : fEditTextSueldo.getText();
        fIngresos : fEditTextIngresos.getText();

// Inicio el servicio de notificaciones accediendo al servicio
        nm = (NotificationManager) getSystemService(ns);

// Realizo una notificacion por medio de un metodo hecho por mi
        notification1(R.drawable.ic_menu_camera, R.drawable.ic_menu_camera,  "Se guardo", "Información Guardada");

// Lanzo la notificacion creada en el paso anterior
        nm.notify(1, notif);
    }

    public  void mCrearEventos()
    {
        fbtnAceptar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                try {
                    mGuardar();
                } catch (Exception ex) {
                    Context context = getApplicationContext();
                    CharSequence text = "Error";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
            }

        });
    }

    public void notification1(int id, int iconId, String titulo, String contenido) {

        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(this)
                        .setSmallIcon(iconId)
                        .setLargeIcon(BitmapFactory.decodeResource(
                                        getResources(),
                                        R.drawable.ic_menu_camera
                                )
                        )
                        .setContentTitle(titulo)
                        .setContentText(contenido)
                        .setColor(getResources().getColor(R.color.colorRojo));


        // Construir la notificación y emitirla
        notifyMgr.notify(id, builder.build());
    }

}
