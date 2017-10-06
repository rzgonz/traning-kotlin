package kodigo.rzgonz.id.traningtwo.interfaces

/**
 * Created by rzgonz on 9/19/17.
 */
interface ApiCall {
    fun respond(status:Boolean,body:Any,message:String)
}