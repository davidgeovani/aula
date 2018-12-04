package br.com.david_fabio.pics_search.fragment;


import android.Manifest;
import android.app.Activity;
import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.app.Fragment;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;


import java.util.ArrayList;

import br.com.david_fabio.pics_search.API.NetworkManager;
import br.com.david_fabio.pics_search.R;


import br.com.david_fabio.pics_search.activities.PicDetailActivity;
import br.com.david_fabio.pics_search.model.Ubs.Ubs;
import br.com.david_fabio.pics_search.util.Permissoes;
//import br.com.david_fabio.pics_search.util.RecyclerItemClickListener;
import br.com.david_fabio.pics_search.view.UbsAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.databinding.DataBindingUtil.setContentView;
import static com.facebook.FacebookSdk.getApplicationContext;


/**
 * A simple {@link Fragment} subclass.
 */
public class UbsFragment extends Fragment {
    int next=5;
    int pic_id=1;
    //  int value = PicService.class.nextpic;
    private UbsAdapter mUbsAdapter;

    private LocationManager locationManager ;
    private LocationListener locationListener;

    public RecyclerView recyclerView_Ubs;
    public ArrayList<Ubs> mListaUbs = new ArrayList<>();

    public ArrayList<Ubs> mUbsSelect = new ArrayList<>();

    private Context context;
    // private DatabaseReference picsRef;


    //  private RecyclerView mRecyclerView;
    //   private List<Pics> mPics = new ArrayList<>();
    //  private PicsAdapter mAdapter;
//ex





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

       // Bundle bundle = getIntent().getExtras();


        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_ubs, container, false);

        recyclerView_Ubs = view.findViewById(R.id.recyclerView_Ubs);
        mUbsAdapter = new UbsAdapter(mListaUbs,getActivity());

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView_Ubs.setLayoutManager(layoutManager);
        recyclerView_Ubs.setHasFixedSize(true);
        recyclerView_Ubs.setAdapter( mUbsAdapter );



        NetworkManager.ubsService().recuperarUbsByPic(String.valueOf(0), String.valueOf(10)).enqueue(new Callback<Ubs>() {
            @Override
            public void onResponse(Call<Ubs> call, Response<Ubs> response) {
                onWebserviceResponse(response.body());
            }

            @Override
            public void onFailure(Call<Ubs> call, Throwable t) {

            }
        });




        return view;
    }


    /*
       private void recuperarLocalização() {


           locationManager = (LocationManager) this.getSystemService(Context)
           locationListener


       }


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
    private void onWebserviceResponse(Ubs body) {
        mListaUbs.addAll(body.getObject().getArray());
        mUbsAdapter.notifyDataSetChanged();

        if (body.getObject().getNext() > 0 && body.getObject().getNext() != -1) {


            NetworkManager.ubsService().recuperarUbsByPic(String.valueOf(next),String.valueOf(10)).enqueue(new Callback<Ubs>() {
                @Override
                public void onResponse(Call<Ubs> call, Response<Ubs> response) {
                    onWebserviceResponse(response.body());

                }

                @Override
                public void onFailure(Call<Ubs> call, Throwable t) {

                }

            });




            next = next + 5;
        }








    }
}
