package kodigo.rzgonz.id.traningtwo.presenter

import kodigo.rzgonz.id.traningtwo.interfaces.ApiCall
import kodigo.rzgonz.id.traningtwo.service.InitRetrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by rzgonz on 9/19/17.
 */
class ApiPresenter{
    private var modelApi : ApiCall ? = null

    constructor(modelApi: ApiCall?) {
        this.modelApi = modelApi
    }

    fun Insert(nama : String, harga:Int){

        InitRetrofit().InstantRetrofit().sendBarang(nama,harga).enqueue(object:Callback<Any>{
            override fun onFailure(call: Call<Any>?, t: Throwable?) {
                modelApi?.respond(false,call.toString(),"GAGAL")
            }

            override fun onResponse(call: Call<Any>?, response: Response<Any>?) {
                modelApi!!.respond(true, response?.body().toString(),"success")
            }

        })

    }

    fun getBarang(){
        InitRetrofit().InstantRetrofit().getList().enqueue(object :Callback<Any>{
            override fun onFailure(call: Call<Any>?, t: Throwable?) {
                modelApi?.respond(false,call.toString(),"GAGAL")
            }

            override fun onResponse(call: Call<Any>?, response: Response<Any>?) {
                modelApi?.respond(true, response?.body()!!,"success")
            }
        })
    }
}