package kodigo.rzgonz.id.traningone.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast

import kodigo.rzgonz.id.traningone.R
import kotlinx.android.synthetic.main.activity_act_list.*
import java.util.*

class ACT_LIST : AppCompatActivity() {

    var data = arrayOf("1","2","3","4","5")
    lateinit var adapterRz: ArrayAdapter<String>

    var array : ArrayList<Any>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_act_list)

        array = ArrayList()
        array!!.add("1")
        array!!.add(1)

        array!!.clear()



        adapterRz = ArrayAdapter(this,android.R.layout.simple_list_item_1,data)

        lvOne.adapter = adapterRz

        lvOne.setOnItemClickListener{ adapterView, view, i, l ->

            Toast.makeText(this,i.toString() +" --> "+ l.toString(),Toast.LENGTH_LONG).show()
        }

    }


}
