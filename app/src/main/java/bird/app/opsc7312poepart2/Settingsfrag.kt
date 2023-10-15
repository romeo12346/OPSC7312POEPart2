package bird.app.opsc7312poepart2

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import androidx.fragment.app.Fragment
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class Settingsfrag : Fragment() {
    private lateinit var auth: FirebaseAuth
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        auth = Firebase.auth
        val fragment_settingsfrag = inflater.inflate(R.layout.fragment_settingsfrag, container, false)

        //Adjusting/Declaring buttons and values
        //val btnkilometres: Button = fragment_settingsfrag.findViewById(R.id.btnkilometres)
        //val btnmiles: Button = fragment_settingsfrag.findViewById(R.id.btnmiles)
        val logout: Button = fragment_settingsfrag.findViewById(R.id.btnLogout)

        //Changed previous buttons to radio buttons
        val btnradiokilometres: RadioButton = fragment_settingsfrag.findViewById(R.id.btnradiokilometres)
        val btnradiomiles: RadioButton = fragment_settingsfrag.findViewById(R.id.btnradiomiles)

        logout.setOnClickListener(){
            auth.signOut()
            val intent = Intent(context, Login::class.java)
            startActivity(intent)
        }
        // Inflate the layout for this fragment
        return fragment_settingsfrag

        //Proper Methods
        //Set App to kilometres -> 1 Km = 0,621371 Miles
        /*btnkilometres.setOnClickListener(){
            //val measurementKm = 1* 0.621371 //may work better as double value
            //Testing out method
            val measurement = 1
            val measurementKm = measurement* 0.621371
        }
        //Set App to Miles -> 1 Mile = 1,60934 Km
        btnmiles.setOnClickListener(){
            //val measurementM = 1* 1.60934 //may work better as double value
            //Testing out method
            val measurement = 1
            val measurementM = measurement* 0.621371
        }*/

        //New Radio buttons methods
        //Set App to kilometres -> 1 Km = 0,621371 Miles
        btnradiokilometres.setOnClickListener(){
            //val measurementKm = 1* 0.621371 //may work better as double value
            //Testing out method
            val measurement = 1
            val measurementKm = measurement* 0.621371
        }
        //Set App to Miles -> 1 Mile = 1,60934 Km
        btnradiomiles.setOnClickListener(){
            //val measurementM = 1* 1.60934 //may work better as double value
            //Testing out method
            val measurement = 1
            val measurementM = measurement* 0.621371
        }
    }
}