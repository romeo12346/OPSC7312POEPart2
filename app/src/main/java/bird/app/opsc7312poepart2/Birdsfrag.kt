package bird.app.opsc7312poepart2

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import okhttp3.OkHttpClient
import java.net.HttpURLConnection
import java.net.URL
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit


class Birdsfrag : Fragment() {
    lateinit var birdAdapter: BirdAdapter
    var birdList: List<Bird> = emptyList()
    lateinit var spList: List<String>
    lateinit var birdView: RecyclerView
    var spieces = "show nothing"
    private val CodeDelay: Long = 2000
    lateinit var bar: ProgressBar
    var dataLoaded = false
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val birdsfrag = inflater.inflate(R.layout.fragment_birdsfrag, container, false)
        birdView = birdsfrag.findViewById(R.id.birdRV)
        birdAdapter = BirdAdapter()
        bar = birdsfrag.findViewById(R.id.progressBar)

        if (localID !=null){
            InfoGetterBird()
        }


        // Inflate the layout for this fragment
        return birdsfrag
    }


    override fun onResume() {
        super.onResume()
        if (localID !=null){
            InfoGetterBird()
        }
    }
    private fun Feed() {

        if (birdList.isNotEmpty()) {
            // Only perform the UI update when birdList is not empty
            val feed: RecyclerView = birdView
            feed.apply {
                layoutManager = LinearLayoutManager(context)
                adapter = birdAdapter
            }
            Handler(Looper.getMainLooper()).post {
                birdAdapter.submitList(birdList)
            }
            bar.visibility = View.INVISIBLE
        }

    }

    fun InfoGetterBird() {
        bar.visibility = View.VISIBLE
        val executor = Executors.newSingleThreadExecutor()
        val builder: OkHttpClient.Builder = OkHttpClient().newBuilder()
        builder.readTimeout(10, TimeUnit.SECONDS)
        builder.connectTimeout(5, TimeUnit.SECONDS)

        executor.execute {
            try {
                val url = URL("https://api.ebird.org/v2/product/spplist/$localID")
                val connection = url.openConnection() as HttpURLConnection
                connection.requestMethod = "GET"

                // Add a custom header with key and value
                connection.setRequestProperty("X-eBirdApiToken", "evv4n00sq7m5")

                // Set timeouts and other connection properties if needed
                connection.readTimeout = 10000 // 10 seconds
                connection.connectTimeout = 5000 // 5 seconds

                val responseCode = connection.responseCode

                if (responseCode == HttpURLConnection.HTTP_OK) {
                    // Connection successful, read the response
                    val inputStream = connection.inputStream
                    val sJson = inputStream.bufferedReader().use { it.readText() }
                    spList = Gson().fromJson(sJson, Array<String>::class.java).toList()
                    for (sp in spList) {
                        var i = 0
                        spieces += sp + ","
                        i++
                    }

                    // Process the JSON response (parse it, update UI, etc.)
                    // You can use a JSON library like Gson to parse sJson into your data model.
                } else {
                    // Handle the HTTP response code indicating an error
                    // For example, you can log an error message or update UI accordingly.
                }

                // Disconnect the connection when done
                connection.disconnect()
            } catch (e: Exception) {
                // Handle exceptions, such as network errors or parsing errors
            }

            val url =
                URL("https://api.ebird.org/v2/ref/taxonomy/ebird?species=" + spieces.dropLast(1) + "&version=2023&fmt=json")
            val json = url.readText()

            birdList = emptyList()
            birdList = Gson().fromJson(json, Array<Bird>::class.java).toList()


                Log.d("list", "${birdList.size}")

            Log.d("json", "${json}")

            Handler(Looper.getMainLooper()).post {Feed()}
        }



    }

}



