package bird.app.opsc7312poepart2

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.gson.Gson
import okhttp3.OkHttpClient
import java.net.HttpURLConnection
import java.net.URL
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit


class Birdsfrag : Fragment() {
    lateinit var birdList:List<Bird>
    lateinit var spList:List<String>
    var spieces = ""
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val birdsfrag = inflater.inflate(R.layout.fragment_birdsfrag, container, false)
        // Inflate the layout for this fragment
        InfoGetter()
        return birdsfrag
    }


    private fun InfoGetter() {
        val executor =  Executors.newSingleThreadExecutor()
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
                    for(sp in spList){
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

            val url = URL("https://api.ebird.org/v2/ref/taxonomy/ebird?species=" + spieces.dropLast(1)+ "&version=2023&fmt=json")
            val json = url.readText()
            birdList = Gson().fromJson(json, Array<Bird>::class.java).toList()
            Log.d("json", "${json}")
        }
    }

}



