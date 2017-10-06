package kodigo.rzgonz.id.traningtwo

import android.os.Bundle
import android.os.Handler
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kodigo.rzgonz.id.traningtwo.adapter.CustomeAdapter
import kodigo.rzgonz.id.traningtwo.interfaces.ApiCall
import kodigo.rzgonz.id.traningtwo.presenter.ApiPresenter
import kotlinx.android.synthetic.main.fragment_act_tab.*


/**
 * Created by rzgonz on 9/19/17.
 */
/**
 * A placeholder fragment containing a simple view.
 */
class Frag_One : Fragment(),ApiCall {


    private lateinit var adapter: CustomeAdapter

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val rootView = inflater!!.inflate(R.layout.fragment_act_tab, container, false)
        adapter = CustomeAdapter(context)
        Handler().postDelayed(Runnable {
            Log.d("dadar","adasds")
        },10000L)
        return rootView
    }


    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tvSection.text = getString(R.string.section_format, arguments.getInt(ARG_SECTION_NUMBER))
        tvSection.text = "adsasdsad"
        rvOne.adapter = adapter
        rvOne.layoutManager = GridLayoutManager(activity,2)
        ApiPresenter(this).getBarang()
    }
    companion object {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private val ARG_SECTION_NUMBER = "section_number"

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        fun newInstance(sectionNumber: Int): Frag_One {
            val fragment = Frag_One()
            val args = Bundle()
            args.putInt(ARG_SECTION_NUMBER, sectionNumber)
            fragment.arguments = args
            return fragment
        }
    }
    override fun respond(status: Boolean, body: Any, message: String) {
        if(status){
            var result = body as List<String>
            adapter.items?.addAll(result)
            Log.e("Frag_One","status"+status+"body message"+result.size)
            adapter.notifyDataSetChanged()
            tvSection.setText(body.toString())
        }
    }

}