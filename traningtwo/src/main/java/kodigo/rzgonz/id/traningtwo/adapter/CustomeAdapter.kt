package kodigo.rzgonz.id.traningtwo.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.google.gson.Gson
import kodigo.rzgonz.id.traningtwo.R

/**
 * Created by rzgonz on 9/18/17.
 */
class CustomeAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder> {

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        if (holder is MyViewHolder) {
//            var gson = items?.get(position)
          //  Log.e("CustomeAdapter",gson.toString()+"-->"+position)
            //holder.tvOne?.setText("--> " + items?.get(position)?.trimEnd())
        }
    }

    var items: ArrayList<String>? = null
    var context: Context? = null


    override fun getItemCount(): Int {
        return items!!.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int):MyViewHolder {

        var view = LayoutInflater.from(context).inflate(R.layout.cell_items,parent,false)

        var holder = MyViewHolder(view)

        return holder

    }

    constructor(context: Context?) : super() {
        this.context = context
        this.items = ArrayList()
    }


    class MyViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        var tvOne = itemView?.findViewById<TextView>(R.id.tvOne)
        var imgOne = itemView?.findViewById<ImageView>(R.id.imgOne)

    }

}