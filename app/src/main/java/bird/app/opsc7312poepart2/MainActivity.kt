package bird.app.opsc7312poepart2

import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MainActivity : AppCompatActivity(), OnMapReadyCallback {

    private val locationPermissionCode  = 2
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val intent = Intent(this,MenuBar::class.java)
        startActivity(intent)

        val mapFragment = supportFragmentManager.findFragmentById(
            R.id.map
        ) as SupportMapFragment
        mapFragment.getMapAsync(this)

    }

    override fun onMapReady(googleMap: GoogleMap) {
        // Add any map customization or marker placement here
        val coordinates = LatLng(33.9608, -84.3500)
        googleMap.addMarker(MarkerOptions().position(coordinates).title("Your current location"))
        googleMap.animateCamera(CameraUpdateFactory.zoomTo(18.0f))
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(coordinates))
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if(requestCode == locationPermissionCode){
            if(grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                Toast.makeText(this , "Permission Granted" , Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this , "Permission Denied" , Toast.LENGTH_SHORT).show()
            }
        }
    }
}