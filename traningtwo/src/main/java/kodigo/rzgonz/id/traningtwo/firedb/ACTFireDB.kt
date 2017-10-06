package kodigo.rzgonz.id.traningtwo.firedb

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import com.google.firebase.database.*

import kodigo.rzgonz.id.traningtwo.R
import kotlinx.android.synthetic.main.activity_actfire_db.*
import com.google.firebase.database.DataSnapshot



class ACTFireDB : AppCompatActivity() {
    var data:ArrayList<Barang> = ArrayList()
    lateinit var adapterRz: ArrayAdapter<Barang>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_actfire_db)

        var database = FirebaseDatabase.getInstance().getReference("barang")
       // database.setValue("Hello Kotlin one")
        // Read from the database
        database.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
//                val value = dataSnapshot.getValue(String::class.java)

                if(dataSnapshot!=null){
                        adapterRz.clear()
                    for (snapshot in dataSnapshot.children) {
                        val barang = snapshot.getValue<Barang>(Barang::class.java)
                         adapterRz.add(barang)
                    }

                }

               // Log.d("ACTFireDB", "Value is: " + value)
            }

            override fun onCancelled(error: DatabaseError) {
                // Failed to read value
                Log.w("ACTFireDB", "Failed to read value.", error.toException())
            }
        })


        btnSave.setOnClickListener {
            for (i in 0..data.size){
                var barang = Barang(etOne.text.toString(),etTwo.text.toString().toInt(),(data.size+i).toString())
                var key = database.push().key
                database.child((data.size+i).toString()).setValue(barang)
                Log.d("getdata",getQuery(database).toString())
            }

        }


        adapterRz = ArrayAdapter(this,android.R.layout.simple_list_item_1,data)
        lvOne.adapter = adapterRz
    }

     fun getQuery(databaseReference:DatabaseReference):Query {
        val recentPostsQuery = databaseReference.child("posts").limitToFirst(100)
         return recentPostsQuery
    }


}


class Barang{
    var nama:String? = ""
    var harga:Int? = 0
    var key:String? =""

    constructor(nama: String?, harga: Int?) {
        this.nama = nama
        this.harga = harga
    }

    constructor(nama: String?, harga: Int?, key: String?) {
        this.nama = nama
        this.harga = harga
        this.key = key
    }

    constructor()

    override fun toString(): String {
        return "Barang(nama=$nama, harga=$harga, key=$key)"
    }


}
