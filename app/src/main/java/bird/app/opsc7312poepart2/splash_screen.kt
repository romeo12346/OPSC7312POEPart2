package bird.app.opsc7312poepart2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class splash_screen : AppCompatActivity() {
    private val SPLASH_DURATION: Long = 3000 // 3 seconds

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        // Use a handler to delay the splash screen and then start the main activity
        Handler().postDelayed({
            // Start the main activity
            val intent = Intent(this, Login::class.java)
            startActivity(intent)

            // Close the splash activity so the user won't go back to it using the back button
            finish()
        }, SPLASH_DURATION)
        //test

    }
}