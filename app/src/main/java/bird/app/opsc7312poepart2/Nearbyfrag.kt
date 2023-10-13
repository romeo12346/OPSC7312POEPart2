package bird.app.opsc7312poepart2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class Nearbyfrag : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        val fragment_nearbyfrag = inflater.inflate(R.layout.fragment_nearbyfrag, container, false)
        //Adjusting/Declaring buttons and values
        val btnnearbyenter: Button = fragment_nearbyfrag.findViewById(R.id.btnnearbyenter)
        val txtnearbylocation: TextView = fragment_nearbyfrag.findViewById(R.id.txtnearbylocation)
        val txtnearbymaxdist: TextView = fragment_nearbyfrag.findViewById(R.id.txtnearbymaxdist)
        val txthotspotnearest: TextView = fragment_nearbyfrag.findViewById(R.id.txtRegEmail)
        val txthotspotnearestdist: TextView = fragment_nearbyfrag.findViewById(R.id.txtRegPassword)//nearbymapView

        return fragment_nearbyfrag


    }

}