package br.com.david_fabio.pics_search.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import br.com.david_fabio.pics_search.util.PersistenciaUtil;

import br.com.david_fabio.pics_search.MainActivity;
import br.com.david_fabio.pics_search.R;

public class TermosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_termos);
    }


    public  void abrirTelaLogin(View view){

        Intent intent = new Intent(this, ControlActivity.class);
        startActivity(intent);
        finish();



    }

    public  void abrirTelaMain(View view){

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
       // finish();//

        PersistenciaUtil.setLogado(this,false);


    }




}
