package bird.app.opsc7312poepart2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

//Fragments
val Frag1 = Birdsfrag()
val Frag2 = Checklistsfrag()
val Frag6 = Nearbyfrag()
val Frag8 = Settingsfrag()

class MenuBar : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_bar)

        replaceFrag(Frag6)
        val bottomNav = findViewById<BottomNavigationView>(R.id.NavBar)
        bottomNav.setOnItemSelectedListener{
            when(it.itemId){
                R.id.ic_birdsfrag->replaceFrag(Frag1)
                R.id.ic_checklists->replaceFrag(Frag2)
                R.id.ic_nearbyfrag->replaceFrag(Frag6)
                R.id.ic_settingsfrag->replaceFrag(Frag8)

            }
            true
        }

    }
    private fun replaceFrag(fragment: Fragment){
        if(fragment != null){
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.frameLayout, fragment)
            transaction.commit()
        }
    }
}