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





    }
}