package com.example.basicweatherapp

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.example.basicweatherapp.mapfragment.MapFragmentDirections
import com.example.basicweatherapp.weatherfragment.WeatherFragmentDirections
import com.google.android.gms.maps.model.LatLng
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var navController: NavController
    lateinit var homeItem: MenuItem
    lateinit var locationItem: MenuItem
    private val REQUEST_LOCATION_PERMISSION = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.supportActionBar!!.hide()

        navController = this.findNavController(R.id.myNavHostFragment)

        homeItem = bottom_navigation.menu.findItem(R.id.icon_home)
        locationItem = bottom_navigation.menu.findItem(R.id.icon_location)

        homeItem.isEnabled = false

        bottom_navigation.setOnNavigationItemSelectedListener {
            navigateSelectedItemMenuBar(it, navController, homeItem, locationItem)
        }

        enableMyLocation()
    }

    private fun navigateSelectedItemMenuBar(it: MenuItem, navController: NavController,
                                            homeItem: MenuItem, locationItem: MenuItem): Boolean {
        when (it.itemId) {
            R.id.icon_location -> {
                navController.navigate(WeatherFragmentDirections.actionWeatherFragmentToMapFragment())
                it.isEnabled = false
                homeItem.isEnabled = true
            }
            R.id.icon_home -> {
                navController.navigate(
                    MapFragmentDirections.actionMapFragmentToWeatherFragment(
                        LatLng(1.0, 1.0)
                    )
                )
                it.isEnabled = false
                locationItem.isEnabled = true
            }
        }
        return true
    }

    private fun isPermissionGranted() : Boolean {
        return ContextCompat.checkSelfPermission(
            this,
            Manifest.permission.ACCESS_FINE_LOCATION) === PackageManager.PERMISSION_GRANTED
    }

    private fun enableMyLocation() {
        if (!isPermissionGranted()) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf<String>(Manifest.permission.ACCESS_FINE_LOCATION),
                REQUEST_LOCATION_PERMISSION
            )
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if (requestCode == REQUEST_LOCATION_PERMISSION) {
            if (grantResults.size > 0 && (grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                enableMyLocation()
            }
        }
    }
}