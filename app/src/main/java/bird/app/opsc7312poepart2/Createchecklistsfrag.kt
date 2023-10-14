package bird.app.opsc7312poepart2

//Firebase Imports
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.google.firebase.auth.FirebaseAuth
//import com.google.firebase.storage.FirebaseStorage
//import com.google.firebase.storage.ktx.storage

class Createchecklistsfrag : Fragment() {
    //Firebase setup Vars
    private lateinit var auth: FirebaseAuth
    private lateinit var txtcreachecklistname: TextView
    private lateinit var  txtcreachecklistlocation: TextView
    private lateinit var  txtcreachecklistdate: TextView
    //private lateinit var  btncreatechecklist: Button
    /*
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val createchecklistsfrag = inflater.inflate(R.layout.fragment_createchecklistsfrag, container, false)
        // Inflate the layout for this fragment
        return createchecklistsfrag
    }
    //Attempt to add Firebase functions
    storagRef = FirebaseStorage.getInstance("gs://opsc-poe-cd345.appspot.com")
    auth = Firebase.auth
    //Var Declare
    txtcreachecklistname= findViewById(R.id.txtcreachecklistname)
    txtcreachecklistlocation = findViewById(R.id.txtcreachecklistlocation)
    txtcreachecklistdate = findViewById(R.id.txtcreachecklistdate)
    val btncreatechecklist = findViewById(R.id.btncreatechecklist)
    //Var Declare textchanged
    txtcreachecklistname.addTextChangedListener(textWatcher)
    txtcreachecklistlocation.addTextChangedListener(textWatcher)
    txtcreachecklistdate.addTextChangedListener(textWatcher)
    val btncreatechecklist: Button = findViewById(R.id.btncreatechecklist)//

    //Uri
    uri = "".toUri()

    //Accessing the database
    val database = FirebaseDatabase.getInstance("https://opsc-poe-cd345-default-rtdb.europe-west1.firebasedatabase.app/")
    val myRef = database.getReference("Users").child(auth.uid.toString())
    val list : ArrayList<String> = ArrayList()
    val arrayAdapter: ArrayAdapter<String> = ArrayAdapter<String>(this, R.layout.spinner_layout, list)
    arrayAdapter.setDropDownViewResource(R.layout.spinner_layout)
    myRef.addValueEventListener(object: ValueEventListener { //must be adjusted to checklist values

        override fun onDataChange(snapshot: DataSnapshot) {

            for(keys in snapshot.children){
                list.add(keys.key.toString())
            }
            arrayAdapter.notifyDataSetChanged()
        }

        override fun onCancelled(error: DatabaseError) {
            Log.w("Firebase","Failed to read value", error.toException())
        }
    })
    //spincategory
    spincategory.adapter= arrayAdapter
    spincategory.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
        override fun onItemSelected(parent: AdapterView<*>, v: View, position: Int, arg3: Long) {
            val spinnerValue = parent.getItemAtPosition(position).toString()
            Toast.makeText(baseContext, "Selected category $spinnerValue", Toast.LENGTH_SHORT).show()
        }
        override fun onNothingSelected(arg0: AdapterView<*>) {
            // TODO Auto-generated method stub
        }
    }

    //btncreatechecklist
    btncreatechecklist.setOnClickListener{

        val cat = spincategory.selectedItem.toString()
        val time = System.currentTimeMillis().toString()
        if (uri != "".toUri()) {

            storagRef.getReference("images").child(time).putFile(uri).addOnSuccessListener{
                    task -> task.metadata!!.reference!!.downloadUrl.addOnSuccessListener {
                val mapImage = mapOf(
                    "url" to it.toString()
                )
                myRef.child(cat.toString()).child(time).child("Image").setValue(mapImage).addOnSuccessListener {
                    Toast.makeText(this, "Successful" , Toast.LENGTH_SHORT).show()
                } .addOnFailureListener{ error ->
                    Toast.makeText(this, it.toString(),  Toast.LENGTH_SHORT).show()
                }
            }
            }
        }

        val name = txtcreachecklistname.text.toString()
        myRef.child(cat.toString()).child(time).child("Name").setValue(name)
        val location = txtcreachecklistlocation.text.toString()
        myRef.child(cat.toString()).child(time).child("Location").setValue(location)
        val date = txtcreachecklistdate.text.toString()
        myRef.child(cat.toString()).child(time).child("Date").setValue(date)

        Toast.makeText(baseContext, "Sent.", Toast.LENGTH_SHORT).show()
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }*/
}