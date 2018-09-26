package br.com.david_fabio.trabalho01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();

    }


    public  void abrirTelaTermos(View view){

        startActivity(new Intent(this,TermosActivity.class));

    }

}
