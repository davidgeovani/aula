package br.com.david_fabio.pics_search;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import br.com.david_fabio.pics_search.activities.ControlActivity;
import br.com.david_fabio.pics_search.activities.LoginActivity;
import br.com.david_fabio.pics_search.activities.TermosActivity;
import br.com.david_fabio.pics_search.util.PersistenciaUtil;

public class MainActivity extends AppCompatActivity {


    private static final String TAG = "Pics Search";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Esta activity não possui layout, apenas redireciona para outras
        // activities do sistema

        boolean estaLogado = PersistenciaUtil.getLogado(this);

        Log.d(TAG, "onCreate: estaLogado = " + estaLogado);

        if (estaLogado) {
            // Redireciona para a home
            Log.d(TAG, "onCreate: redireciona para a home");

            Intent intent = new Intent(this, ControlActivity.class);

            intent.putExtra("oi", "Oi");
            intent.putExtra("numero", 999);

            startActivity(intent);
            finish();

        } else {
            // Redireciona para a tela de login
            Log.d(TAG, "onCreate: redireciona para a tela de login");

            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
            finish();
        }


    }
}