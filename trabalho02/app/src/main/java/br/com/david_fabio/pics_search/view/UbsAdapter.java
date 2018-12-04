package br.com.david_fabio.pics_search.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import java.util.ArrayList;


import br.com.david_fabio.pics_search.R;


import br.com.david_fabio.pics_search.model.Ubs.Ubs;

public class UbsAdapter extends RecyclerView.Adapter<UbsAdapter.MyViewHolder> {

    private ArrayList<Ubs> mListUbs;
    private Context mContext;

    public UbsAdapter(ArrayList<Ubs> listUbs, Context context) {

        this.mListUbs = listUbs;
        this.mContext = context;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {


        View itemlista = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.adapter_ubs, viewGroup, false);

        return new MyViewHolder(itemlista) ;

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

        Ubs ubs = mListUbs.get(i);
        myViewHolder.nome.setText(ubs.getNome());
        myViewHolder.endereco.setText(ubs.getEndereco());
        myViewHolder.map.setText(ubs.getMapaUrl());
        myViewHolder.fone.setText(ubs.getTelefone());



    }

    @Override
    public int getItemCount() {
        return mListUbs.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{


        TextView nome, endereco, map, fone;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);


            nome = itemView.findViewById(R.id.ubs_txt_nome);
            endereco = itemView.findViewById(R.id.ubs_txt_endereco);
            map = itemView.findViewById(R.id.ubs_txt_map);
            fone = itemView.findViewById(R.id.ubs_txt_fone);

        }



    }


}
