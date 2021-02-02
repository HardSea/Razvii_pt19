package com.pmacademy.razvii_pt19

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class PostersActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_posters)

        findViewById<Button>(R.id.btn_change_poster).setOnClickListener {
            changePoster()
        }
    }

    private fun changePoster() {
        val poster1 = findViewById<PosterViewGroup>( R.id.poster1)
        val title = R.string.alladin_title
        val genre = Genre.Comedy
        val currency = Currency.USD
        val poster = R.drawable.aladdin_poster
        val price = 10.5f
        val rating = 5

        poster1.changeImage(poster)
        poster1.changeTitle(title)
        poster1.changeGenre(genre)
        poster1.changeCurrency(currency)
        poster1.changePrice(price)
        poster1.changeStars(rating)
    }
}