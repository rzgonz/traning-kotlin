package kodigo.rzgonz.id.traningtwo

import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.Snackbar
import android.view.View
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.*
import com.google.maps.android.data.geojson.GeoJsonFeature
import com.google.maps.android.data.geojson.GeoJsonPoint
import com.google.maps.android.data.geojson.GeoJsonPointStyle
import kotlinx.android.synthetic.main.activity_actmaps.*
import com.google.maps.android.SphericalUtil
import java.util.*


class ACTNAV : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener, OnMapReadyCallback,GoogleMap.OnMarkerDragListener {

    private var mMap: GoogleMap? = null

    private var pointFeature: GeoJsonFeature? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_actnav)
        val toolbar = findViewById(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)

        val fab = findViewById(R.id.fab) as FloatingActionButton
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

        val drawer = findViewById(R.id.drawer_layout) as DrawerLayout
        val toggle = ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer.setDrawerListener(toggle)
        toggle.syncState()

        val navigationView = findViewById(R.id.nav_view) as NavigationView
        navigationView.setNavigationItemSelectedListener(this)

        val mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)


    }

    override fun onBackPressed() {
        val drawer = findViewById(R.id.drawer_layout) as DrawerLayout
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.actnav, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id = item.itemId


        return if (id == R.id.action_settings) {
            true
        } else super.onOptionsItemSelected(item)

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        val id = item.itemId

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        val drawer = findViewById(R.id.drawer_layout) as DrawerLayout
        drawer.closeDrawer(GravityCompat.START)
        return true
    }
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Add a marker in Sydney and move the camera
        val sydney = LatLng(-34.0, 151.0)
        mMap!!.addMarker(MarkerOptions().position(sydney).title("Marker in Sydney"))

        mMap!!.moveCamera(CameraUpdateFactory.newLatLng(sydney))

        addMarker()
    }

    private var mMarkerA: Marker? = null
    private var mMarkerB: Marker? = null

    private var mPolyline: Polyline? = null

    private fun addMarker() {
        mMarkerA = mMap?.addMarker(MarkerOptions().position(LatLng(-33.9046, 151.155)).draggable(true))
        mMarkerB = mMap?.addMarker(MarkerOptions().position(LatLng(-33.8291, 151.248)).draggable(true))
        mMap!!.moveCamera(CameraUpdateFactory.newLatLng(mMarkerA?.position))
        mPolyline = mMap?.addPolyline(PolylineOptions().geodesic(true))
        showDistance()
    }


    fun updatePolyline() {
        mPolyline?.setPoints(Arrays.asList(mMarkerA?.getPosition(), mMarkerB?.getPosition()));
    }

     fun showDistance() {
        var distance = SphericalUtil.computeDistanceBetween(mMarkerA?.getPosition(), mMarkerB?.getPosition());
        Log.e("The markers are ", formatNumber(distance) + " apart.");
    }


    override fun onMarkerDragEnd(marker: Marker) {
        showDistance()
        updatePolyline()
    }


   override fun onMarkerDrag(marker: Marker) {
        showDistance()
        updatePolyline()
    }
    override fun onMarkerDragStart(p0: Marker?) {

    }


    private fun formatNumber(distance: Double): String {
        var distance = distance
        var unit = "m"
        if (distance < 1) {
            distance *= 1000.0
            unit = "mm"
        } else if (distance > 1000) {
            distance /= 1000.0
            unit = "km"
        }

        return String.format("%4.3f%s", distance, unit)
    }


}
