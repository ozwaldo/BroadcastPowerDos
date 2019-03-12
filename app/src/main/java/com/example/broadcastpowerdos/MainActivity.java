package com.example.broadcastpowerdos;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView tvTexto;
    private IntentFilter intentFilter;
    private CargaBoradcastReceiver cargaBoradcastReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvTexto = (TextView) findViewById(R.id.tvTexto);
        cargaBoradcastReceiver =
                new CargaBoradcastReceiver();
        intentFilter = new IntentFilter();
        intentFilter.addAction(
                Intent.ACTION_POWER_CONNECTED);
        intentFilter.addAction(
                Intent.ACTION_POWER_DISCONNECTED);
    }
    private class CargaBoradcastReceiver extends
            BroadcastReceiver {
        @Override
        public void onReceive(Context context,
                              Intent intent) {
            String action = intent.getAction();
            boolean cargando = (action.equals(
                    Intent.ACTION_POWER_CONNECTED));
            showCargando(cargando);
        }
    }

    private void showCargando(boolean cargando) {
        if (cargando) {
            tvTexto.setText("Conectado: Cargando corriente.");
            Toast.makeText(this, "Conectado",
                    Toast.LENGTH_SHORT).show();
        } else {

            tvTexto.setText(
                    "Desconectado: Descargando corriente.");
            Toast.makeText(this, "Desconectado",
                    Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(cargaBoradcastReceiver,
                intentFilter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(cargaBoradcastReceiver);
    }
}
