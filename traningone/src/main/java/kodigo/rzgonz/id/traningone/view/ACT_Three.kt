package kodigo.rzgonz.id.traningone.view

import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import kodigo.rzgonz.id.traningone.R

class ACT_Three : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_three)
        val toolbar = findViewById(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)

        val fab = findViewById(R.id.fab) as FloatingActionButton
        fab.setOnClickListener { view ->
            Snackbar.make(view,intent.getStringExtra("hasil"), Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }

}
