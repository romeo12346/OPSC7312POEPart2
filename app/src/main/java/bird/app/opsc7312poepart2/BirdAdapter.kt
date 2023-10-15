package bird.app.opsc7312poepart2

import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.PopupWindow
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase

class BirdAdapter : ListAdapter<Bird, BirdAdapter.BirdAdapter>(BirdViewHolder()) {
    private lateinit var auth: FirebaseAuth

    class BirdAdapter(view: View) : RecyclerView.ViewHolder(view) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BirdAdapter {
        val inflater = LayoutInflater.from(parent.context)
        return bird.app.opsc7312poepart2.BirdAdapter.BirdAdapter(
            inflater.inflate(
                R.layout.bird_layout,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: BirdAdapter, position: Int) {
        auth = Firebase.auth
        val database =
            FirebaseDatabase.getInstance("https://opsc-poe-cd345-default-rtdb.europe-west1.firebasedatabase.app/")
        val myRef = database.getReference("Users").child(auth.uid.toString())

        var bird = getItem(position)
        val context = holder.itemView.context
        val layoutInflater = LayoutInflater.from(context)
        holder.itemView.findViewById<TextView>(R.id.text1).text = "Name: " + bird.comName
        holder.itemView.findViewById<TextView>(R.id.text2).text = "Sci Name: " + bird.sciName
        holder.itemView.findViewById<TextView>(R.id.text3).text =
            "Family Name: " + bird.familyComName

        holder.itemView.findViewById<Button>(R.id.buttonBird).setOnClickListener {
            val popup = PopupWindow(context)
            popup.setFocusable(true);
            popup.update();
            val view = layoutInflater.inflate(R.layout.saveobservation_layout, null)
            popup.contentView = view
            val btnSave = view.findViewById<Button>(R.id.btnSave)
            val name = view.findViewById<TextView>(R.id.txtOName)
            val date = view.findViewById<EditText>(R.id.txtODate)
            val time = view.findViewById<EditText>(R.id.txtOTime)
            val loc = view.findViewById<TextView>(R.id.txtOLoc)
            val currentTime = System.currentTimeMillis().toString()
            name.setText(bird.comName)
            loc.setText(localName)
            btnSave.setOnClickListener() {
                if (date.text.toString().isEmpty() || time.text.toString().isEmpty()) {
                    Toast.makeText(
                        context,
                        "Please fill in date and time",
                        Toast.LENGTH_SHORT
                    ).show();
                    return@setOnClickListener
                }
                myRef.child("Observations").child(currentTime).child("Name")
                    .setValue(name.text.toString())
                myRef.child("Observations").child(currentTime).child("Date")
                    .setValue(date.text.toString())
                myRef.child("Observations").child(currentTime).child("Time")
                    .setValue(time.text.toString())
                myRef.child("Observations").child(currentTime).child("Location")
                    .setValue(loc.text.toString())

                Toast.makeText(context, "Observation Saved.", Toast.LENGTH_SHORT).show()
                popup.dismiss()
            }

            popup.showAtLocation(view, Gravity.CENTER, 0, 0)
        }
    }

    class BirdViewHolder : DiffUtil.ItemCallback<Bird>() {
        override fun areContentsTheSame(oldItem: Bird, newItem: Bird): Boolean {
            return areItemsTheSame(oldItem, newItem)
        }

        override fun areItemsTheSame(oldItem: Bird, newItem: Bird): Boolean {
            return oldItem.comName == newItem.comName
        }
    }
}