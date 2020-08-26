package app.sano.picchi.colorquize

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        resultText.text = score.toString()

        homeButton.setOnClickListener {
            val homeIntent = Intent(this,StartActivity::class.java)
            startActivity(homeIntent)
        }


    }

}