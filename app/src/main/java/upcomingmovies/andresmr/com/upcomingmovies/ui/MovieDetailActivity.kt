package upcomingmovies.andresmr.com.upcomingmovies.ui

import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import org.jetbrains.anko.*
import upcomingmovies.andresmr.com.upcomingmovies.R
import upcomingmovies.andresmr.com.upcomingmovies.data.entities.Result

class MovieDetailActivity : AppCompatActivity(), AnkoLogger {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)
        val result : Result? = intent.getSerializableExtra("movie") as? Result
        if(result != null) {

            verticalLayout {
                padding = dip(10)
                val name = textView {
                    textColor = Color.BLACK
                    textSize = 20f
                }
                val overview = textView()
                name.text = result.title
                overview.text = result.overview
            }
        }
    }
}
