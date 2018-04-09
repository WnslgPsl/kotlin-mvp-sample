package jo.kotlin.mvpsample.network.retrofit

import jo.kotlin.mvpsample.view.data.PhotoResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Jo on 2018. 4. 2.
 */

interface NetworkCallbackService {

    @GET("rest")
    fun getFlickrSearch(
            @Query("format") format: String,
            @Query("nojsoncallback") nojsoncallback: String,
            @Query("method") method: String,
            @Query("api_key") api_key: String,
            @Query("text") text: String,
            @Query("page") page: Int,
            @Query("per_page") per_page: Int
    ): Call<PhotoResponse>

}