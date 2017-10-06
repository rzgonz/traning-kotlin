package kodigo.rzgonz.id.traningtwo.service

import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit
import com.google.gson.GsonBuilder
import com.google.gson.Gson
import kodigo.rzgonz.id.traningtwo.service.rest.ApiService

/**
 * Created by rzgonz on 9/19/17.
 */
class InitRetrofit{

    fun getClient () :Retrofit {
        var retrofit = Retrofit.Builder()
                .baseUrl("http://bkdroid.bknime.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        return retrofit
    }

    fun InstantRetrofit():ApiService{
        return getClient().create(ApiService::class.java)
    }
}