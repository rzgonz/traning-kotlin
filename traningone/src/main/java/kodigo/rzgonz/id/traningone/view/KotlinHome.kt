package kodigo.rzgonz.id.traningone.view

import android.content.DialogInterface
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.view.View
import android.widget.Toast
import kodigo.rzgonz.id.traningone.R
import kodigo.rzgonz.id.traningone.model.CalculateModel
import kodigo.rzgonz.id.traningone.presenter.CalculatePresenter
import kotlinx.android.synthetic.main.activity_kotlin_home.*

class KotlinHome : AppCompatActivity(), CalculateModel {

    override fun Hasil(hasil: Double) {
        var alert = AlertDialog.Builder(this);
        alert.setTitle("Alert")
        alert.setMessage(hasil.toString())

        alert.setPositiveButton("Dismis", DialogInterface.OnClickListener { dialogInterface, i ->
            Toast.makeText(baseContext,"setPositiveButton", Toast.LENGTH_LONG).show()
            dialogInterface.dismiss()
            startActivity(Intent(baseContext, ACT_REC::class.java).putExtra("hasil",hasil.toString()))
        })

        alert.setNegativeButton("Negative", DialogInterface.OnClickListener { dialogInterface, i ->
            Toast.makeText(baseContext,"setNegativeButton", Toast.LENGTH_LONG).show()
            startActivity(Intent(baseContext, ACT_Basic::class.java).putExtra("hasil",hasil.toString()))
            dialogInterface.dismiss()
        })

        alert.setNeutralButton("Natural", DialogInterface.OnClickListener { dialogInterface, i ->
            Toast.makeText(baseContext,"setNeutralButton", Toast.LENGTH_LONG).show()
            startActivity(Intent(baseContext, ACT_LIST::class.java).putExtra("hasil",hasil.toString()))
            dialogInterface.dismiss()
        })

        alert.show()
    }

    override fun Kosong(error: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    lateinit var presenter : CalculatePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin_home)
        tvOne.setText("DJAJJAJAJAJAJJA")
        presenter = CalculatePresenter(this,baseContext)

        btnSave.setOnClickListener {

        }

        btnSave.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                toast(etOne.text.toString().toInt()+etTwo.text.toString().toInt())
            }
        })
    }

    private fun toast(s: Int) {
        Toast.makeText(this,s.toString(),Toast.LENGTH_LONG).show()
        presenter.hitung(s.toString(),s.toString())
    }

}
