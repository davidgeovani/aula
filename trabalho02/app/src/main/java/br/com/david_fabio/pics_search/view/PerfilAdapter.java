package br.com.david_fabio.pics_search.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import br.com.david_fabio.pics_search.R;
import br.com.david_fabio.pics_search.model.Perfil;

public class PerfilAdapter extends RecyclerView.Adapter<PerfilAdapter.MyViewHolder> {

    private Perfil perfil;
    private Context mContext;

    public PerfilAdapter(Perfil perfil, Context context) {

        this.perfil = perfil;
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

        Perfil mPerfil = perfil;
        myViewHolder.nome.setText(perfil.getNome());
        myViewHolder.email.setText(perfil.getNome());


      /*  if(pics.getFoto()!=null){
            Uri uri = Uri.parse (pics.getFoto());

            Glide.with(mContext).load(uri).into(myViewHolder.foto);
        }
        pics.getFoto();
       */

    }

    @Override
    public int getItemCount() {
        return 0;
    }


    public  class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView foto;
        TextView nome, email;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);


            //foto = itemView.findViewById(R.id.pics_img_foto);
            nome = itemView.findViewById(R.id.pics_txt_nome);
            email = itemView.findViewById(R.id.pics_txt_descricao);

        }



    }


}
