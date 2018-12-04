package br.com.david_fabio.pics_search.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import br.com.david_fabio.pics_search.API.NetworkManager;
import br.com.david_fabio.pics_search.API.PicService;
import br.com.david_fabio.pics_search.R;
import br.com.david_fabio.pics_search.model.Distrito;
import br.com.david_fabio.pics_search.model.Pic.Pics;

import br.com.david_fabio.pics_search.model.Ubs.Ubs;
import br.com.david_fabio.pics_search.view.PicsAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PicDetailActivity extends AppCompatActivity {

    private PicsAdapter picsAdapter;
    String ubsId;
    int next;
    private ArrayList<Pics> listaPics = new ArrayList<Pics>();
    private ArrayList<Ubs> listaUbs = new ArrayList<Ubs>();
    //private ArrayList<Distrito> listaDistrito = new ArrayList<>();

    private Button btn_recuperar;

    private TextView text_result;

    Retrofit retrofit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pic_detail);

        Bundle dados = getIntent().getExtras();

        ubsId = dados.getString("select");


        //int next=0;
        //String.valueOf(0)
        NetworkManager.picservice().recuperarPicUbs(String.valueOf(0), ubsId).enqueue(new Callback<Pics>() {
            @Override
            public void onResponse(Call<Pics> call, Response<Pics> response) {
                onWebserviceResponse(response.body());
            }

            @Override
            public void onFailure(Call<Pics> call, Throwable t) {

            }
        });


       // btn_recuperar = findViewById(R.id.btn_recuperar);
        text_result = findViewById(R.id.text_result);


        btn_recuperar.setOnClickListener(view -> {


            recuperarPicRetrofit();


        /*
            MyTask task = new MyTask();
            String urlAPI = "http://blockchain.info/ticker";
            task.execute(urlAPI);
           */
        });


    }


    private void recuperarPicRetrofit() {

        PicService PicService = retrofit.create(PicService.class);
        Call<Pics> call = PicService.recuperarPicUbs(String.valueOf(0), ubsId);

        call.enqueue(new Callback<Pics>() {
            @Override
            public void onResponse(Call<Pics> call, Response<Pics> response) {

                if (response.isSuccessful()) {

                    Pics pic = response.body();
                    text_result.setText(pic.getNome());

                }

            }

            @Override
            public void onFailure(Call<Pics> call, Throwable t) {


            }
        });

    }


    private void onWebserviceResponse(Pics body) {
        listaPics.addAll(body.getObject().getArrayM());
        picsAdapter.notifyDataSetChanged();

        if (body.getObject().getNext() > 0 && body.getObject().getNext() != -1) {


            NetworkManager.picservice().recuperarPic(String.valueOf(next)).enqueue(new Callback<Pics>() {
                @Override
                public void onResponse(Call<Pics> call, Response<Pics> response) {
                    onWebserviceResponse(response.body());


                }

                @Override
                public void onFailure(Call<Pics> call, Throwable t) {

                }

            });

            next = next + 5;
        }


    }


}




