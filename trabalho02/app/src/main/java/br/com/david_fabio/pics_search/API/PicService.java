package br.com.david_fabio.pics_search.API;

import br.com.david_fabio.pics_search.model.Pic.Pics;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface PicService {


   // @POST("pic/get_pics.php")
   //Call<Pics> recuperarPic(@Path("next") int next);


    @POST("pic/get_pics.php")
   // Call<Pics> recuperarPic();

    Call<Pics> recuperarPic( @Query("next") String next );

    @POST ("pic/get_pics_por_ubs.php")

    Call<Pics> recuperarPicUbs( @Query("next") String next,
                                @Query("ubs_id") String ubs_id );


    //@POST("pic/get_pics.php?next=0")
    //String.valueOf
    //Call<Pics> recuperarPic();

    // @POST("/ubs/get_ubs_por_distrito.php")
    // Call<GetUBSResponse> getUbs(@PartMap Map<String, RequestBody> params);

}
