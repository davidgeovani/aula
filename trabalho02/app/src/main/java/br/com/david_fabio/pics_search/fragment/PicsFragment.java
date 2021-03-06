package br.com.david_fabio.pics_search.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import java.lang.reflect.Array;
import java.util.ArrayList;

import br.com.david_fabio.pics_search.API.NetworkManager;
import br.com.david_fabio.pics_search.R;
import br.com.david_fabio.pics_search.activities.PicDetailActivity;
import br.com.david_fabio.pics_search.model.Pic.Pics;

import br.com.david_fabio.pics_search.model.Ubs.Ubs;
//import br.com.david_fabio.pics_search.util.RecyclerItemClickListener;
import br.com.david_fabio.pics_search.view.PicsAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.databinding.DataBindingUtil.setContentView;
import static com.facebook.FacebookSdk.getApplicationContext;


/**
 * A simple {@link Fragment} subclass.
 */
public class PicsFragment extends Fragment {
    int next=5;
  //  int value = PicService.class.nextpic;
    private PicsAdapter picsAdapter;

    public RecyclerView recyclerView_Pics;
    public ArrayList<Pics> listaPics = new ArrayList<>();
   // private DatabaseReference picsRef;


  //  private RecyclerView mRecyclerView;
 //   private List<Pics> mPics = new ArrayList<>();
  //  private PicsAdapter mAdapter;
//ex




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_pics, container, false);

        recyclerView_Pics = view.findViewById(R.id.recyclerView_Pics);
        picsAdapter = new PicsAdapter(listaPics,getActivity());

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView_Pics.setLayoutManager(layoutManager);
        recyclerView_Pics.setHasFixedSize(true);
        recyclerView_Pics.setAdapter( picsAdapter );

/*
        recyclerView_Pics.addOnItemTouchListener(
                new RecyclerItemClickListener(
                        this,
                        recyclerView_Pics,
                        new RecyclerItemClickListener.OnItemClickListener(){


                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {



                            }

                            @Override
                            public void onItemClick(View view, int position) {

                                Pics pic =  listaPics.get(position);
                                //String pic_id =pic.id;
                                listaPics.add(pic);

                                Intent it = new Intent(getApplicationContext(),UbsFragment.class);
                                it.putExtra("select",listaPics.get(position).getId());
                                startActivity(it);

                            }

                            @Override
                            public void onLongItemClick(View view, int position) {

                            }
                        }


                )

        );

*/


        //int next=0;
        //String.valueOf(0)
        NetworkManager.picservice().recuperarPic(String.valueOf(0)).enqueue(new Callback<Pics>() {
            @Override
            public void onResponse(Call<Pics> call, Response<Pics> response) {
                onWebserviceResponse(response.body());
            }

            @Override
            public void onFailure(Call<Pics> call, Throwable t) {

            }
        });




        return view;
    }

    /*
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);



         recyclerView_Pics = view.findViewById(R.id.recyclerView_Pics);
        picsAdapter = new PicsAdapter(listaPics,getActivity());

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView_Pics.setLayoutManager(layoutManager);
        recyclerView_Pics.setHasFixedSize(true);
        recyclerView_Pics.setAdapter( picsAdapter );

        NetworkManager.service().recuperarPic(0).enqueue(new Callback<Pics>() {
            @Override
            public void onResponse(Call<Pics> call, Response<Pics> response) {
                onWebserviceResponse(response.body());
            }

            @Override
            public void onFailure(Call<Pics> call, Throwable t) {

            }
        });


    }
*/
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
