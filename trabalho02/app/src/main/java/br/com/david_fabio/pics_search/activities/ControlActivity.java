package br.com.david_fabio.pics_search.activities;

import android.Manifest;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.widget.Button;

import com.google.android.gms.maps.GoogleMap;

import br.com.david_fabio.pics_search.R;
import br.com.david_fabio.pics_search.fragment.PerfilFragment;
import br.com.david_fabio.pics_search.fragment.PicsFragment;
import br.com.david_fabio.pics_search.fragment.UbsFragment;
import br.com.david_fabio.pics_search.util.Permissoes;

public class ControlActivity extends AppCompatActivity {
private Button pics_btn, ubs_btn;
    public PicsFragment picsFragment;
    public PerfilFragment perfilFragment;
    public UbsFragment ubsFragment;

    private  String[] permissoes = new String[]{


            Manifest.permission.ACCESS_FINE_LOCATION
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_control);


        Permissoes.validarPermissoes(permissoes,this,1);
        //recuperarLocalização();



        pics_btn = findViewById(R.id.pics_btn);

        ubs_btn = findViewById(R.id.map_btn);


        pics_btn.setOnClickListener(view -> {
            picsFragment = new PicsFragment();

            FragmentTransaction transaction = getFragmentManager().beginTransaction();

            transaction.replace(R.id.frame_control, picsFragment);
            transaction.commit();


        });





        ubs_btn.setOnClickListener(view -> {
            ubsFragment = new UbsFragment();

            FragmentTransaction transaction = getFragmentManager().beginTransaction();

            transaction.replace(R.id.frame_control, ubsFragment);
            transaction.commit();


        });




    }





 //   getApplicationContext()




}
