package br.com.david_fabio.trabalho01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class TermosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_termos);

        getSupportActionBar().hide();

    }


    public  void abrirTelaMain(View view){

        startActivity(new Intent(this,MainActivity.class));

    }

}
