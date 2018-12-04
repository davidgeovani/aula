package br.com.david_fabio.pics_search.API;



import br.com.david_fabio.pics_search.model.Ubs.Ubs;
import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface UbsService {


   // @POST("pic/get_pics.php")
   //Call<Pics> recuperarPic(@Path("next") int next);


    @POST("ubs/get_ubs.php")
   // Call<Pics> recuperarPic();

    Call<Ubs> recuperarUbs(@Query("next") String next);



    @POST("ubs/get_ubs_ubs_por_pic.php")
        // Call<Pics> recuperarPic();

    Call<Ubs> recuperarUbsByPic( @Query("next") String next,
                                 @Query("pic_id")String pic_id);



    //@POST("pic/get_pics.php?next=0")
    //String.valueOf
    //Call<Pics> recuperarPic();

    // @POST("/ubs/get_ubs_por_distrito.php")
    // Call<GetUBSResponse> getUbs(@PartMap Map<String, RequestBody> params);

}
