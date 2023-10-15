package bird.app.opsc7312poepart2

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.ktx.Firebase
import java.util.concurrent.Executors

class Checklistsfrag : Fragment() {
    private lateinit var auth: FirebaseAuth
    lateinit var obAdapter: ObservationAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val checklistsfrag = inflater.inflate(R.layout.fragment_checklistsfrag, container, false)

        val feed: RecyclerView = checklistsfrag.findViewById(R.id.observationRV)
        obAdapter = ObservationAdapter()
        feed.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = obAdapter
        }

        auth = Firebase.auth
        val database =
            FirebaseDatabase.getInstance("https://opsc-poe-cd345-default-rtdb.europe-west1.firebasedatabase.app/")
        val myRef = database.getReference("Users").child(auth.uid.toString())
        val executor = Executors.newSingleThreadExecutor()

        executor.execute {
            val Items = mutableListOf<Observation>()
            myRef.addValueEventListener(object :
                ValueEventListener { //has been adjusted to timesheet values

                override fun onDataChange(snapshot: DataSnapshot) {
                    Items.clear()

                    for (keys in snapshot.children) {
                        for (unique in keys.children) {
                            Items.add(
                                Observation(
                                    Name = "Name: " + unique.child("Name").getValue().toString(),
                                    DateTime = "Date & Time: " + unique.child("Date").getValue().toString() + " " + unique.child("Time").getValue().toString(),
                                    Location = "Location: " + unique.child("Location").getValue().toString()
                                )
                            )
                        }

                    }
                    obAdapter.notifyDataSetChanged()
                }


                override fun onCancelled(error: DatabaseError) { //handles errors
                    Log.w("Firebase", "Failed to read value", error.toException())
                }
            })
            Handler(Looper.getMainLooper()).post {
                obAdapter.submitList(Items)
            }


        }
        return checklistsfrag
    }

}

