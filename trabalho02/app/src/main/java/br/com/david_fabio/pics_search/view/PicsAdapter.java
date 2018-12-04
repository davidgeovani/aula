package br.com.david_fabio.pics_search.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import br.com.david_fabio.pics_search.R;
import br.com.david_fabio.pics_search.model.Pic.Pics;

public class PicsAdapter extends RecyclerView.Adapter<PicsAdapter.MyViewHolder> {

    private ArrayList<Pics> listPics;
    private Context mContext;

    public PicsAdapter(ArrayList<Pics> listPics, Context context) {

        this.listPics = listPics;
        this.mContext = context;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {


        View itemlista = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.adapter_pics, viewGroup, false);

        return new MyViewHolder(itemlista) ;

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

        Pics pics = listPics.get(i);
        myViewHolder.nome.setText(pics.getNome());
        myViewHolder.descricao.setText(pics.getDescricao());

        //myViewHolder.nome.setText("ola");
        //myViewHolder.descricao.setText("troxa");

      /*  if(pics.getFoto()!=null){
            Uri uri = Uri.parse (pics.getFoto());

            Glide.with(mContext).load(uri).into(myViewHolder.foto);
        }
        pics.getFoto();
       */

    }

    @Override
    public int getItemCount() {
        return listPics.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        //ImageView foto;
        TextView nome, descricao;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);


            //foto = itemView.findViewById(R.id.pics_img_foto);
            nome = itemView.findViewById(R.id.pics_txt_nome);
            descricao = itemView.findViewById(R.id.pics_txt_descricao);

        }



    }


}
