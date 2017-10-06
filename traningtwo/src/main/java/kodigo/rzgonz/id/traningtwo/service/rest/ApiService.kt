package kodigo.rzgonz.id.traningtwo.service.rest

import retrofit2.Call
import retrofit2.Callback
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

/**
 * Created by rzgonz on 9/19/17.
 */
interface ApiService{

    @FormUrlEncoded
    @POST("DroidListCore/")
    fun sendBarang(@Field("name") nama :String,@Field("harga") harga:Int):Call<Any>

    @GET("DroidListCore/")
    fun getList():Call<Any>
}