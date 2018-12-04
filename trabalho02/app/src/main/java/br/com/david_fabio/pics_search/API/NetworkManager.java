package br.com.david_fabio.pics_search.API;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkManager {

    private static final String URL = "http://services.koruthos.com.br/";
    private static NetworkManager sInstance = new NetworkManager();

    private final Retrofit mRetrofit;
    private final PicService mPicService;
    private final UbsService mUbsService;

    private NetworkManager() {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        mRetrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        mPicService = mRetrofit.create(PicService.class);

        mUbsService = mRetrofit.create(UbsService.class);

    }

    public static NetworkManager getInstance() {
        if (sInstance == null) sInstance = new NetworkManager();
        return sInstance;
    }

    public static PicService picservice() {
        return getInstance().mPicService;
    }

    public static UbsService ubsService() {
        return getInstance().mUbsService;
    }

}

