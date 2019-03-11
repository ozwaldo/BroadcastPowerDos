package com.example.broadcastpowerdos;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tvTexto;
    private IntentFilter intentFilter;
    private CargaBoradcastReceiver cargaBoradcastReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private class CargaBoradcastReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            boolean cargando = (action.equals(Intent.ACTION_POWER_CONNECTED));
            showCargando(cargando);
        }
    }

    private void showCargando(boolean cargando) {
        if (cargando) {

        } else {

        }
    }


}
