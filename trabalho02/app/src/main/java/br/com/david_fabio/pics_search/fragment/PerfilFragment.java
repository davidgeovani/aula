package br.com.david_fabio.pics_search.fragment;


import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import br.com.david_fabio.pics_search.R;
import br.com.david_fabio.pics_search.model.Perfil;
import br.com.david_fabio.pics_search.view.PerfilAdapter;


/**
 * A simple {@link Fragment} subclass.
 */
public class PerfilFragment extends Fragment {

    private PerfilAdapter perfilAdapter;
    private Perfil perfil = new Perfil();

    private RecyclerView recyclerView_Perfil;
    //private TextView textPerfil;


    public PerfilFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_perfil, container, false);

        recyclerView_Perfil = view.findViewById(R.id.recyclerView_Perfil);

        perfilAdapter = new PerfilAdapter(perfil,getActivity());

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView_Perfil.setLayoutManager(layoutManager);
        recyclerView_Perfil.setHasFixedSize(true);
        recyclerView_Perfil.setAdapter( perfilAdapter );


        return view;
    }





}
