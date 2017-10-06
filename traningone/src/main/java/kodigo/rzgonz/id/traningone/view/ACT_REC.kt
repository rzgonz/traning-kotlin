package kodigo.rzgonz.id.traningone.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView

import kodigo.rzgonz.id.traningone.R
import kodigo.rzgonz.id.traningone.adapter.CustomeAdapter
import kotlinx.android.synthetic.main.activity_act_rec.*

class ACT_REC : AppCompatActivity() {

    var images = arrayListOf<Int>(R.drawable.notification_template_icon_low_bg,R.drawable.notify_panel_notification_icon_bg,R.drawable.notification_bg_normal_pressed)
    var data_name = arrayListOf<String>("satu","dua","tiga");
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_act_rec)

        var  adapter = CustomeAdapter(images,data_name,baseContext);

        rcvOne.adapter = adapter

        rcvOne.layoutManager  =  GridLayoutManager(baseContext,1)


    }
}
