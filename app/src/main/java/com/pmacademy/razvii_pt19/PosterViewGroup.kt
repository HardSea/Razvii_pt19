package com.pmacademy.razvii_pt19

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.core.content.ContextCompat

class PosterViewGroup @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null
) : LinearLayout(context, attributeSet) {

    private val image: ImageView
    private val title: TextView
    private val genre: TextView
    private val currency: TextView
    private val price: TextView
    private val star1: ImageView
    private val star2: ImageView
    private val star3: ImageView
    private val star4: ImageView
    private val star5: ImageView

    init {
        inflate(context, R.layout.poster_view, this)
        title = findViewById(R.id.title)
        image = findViewById(R.id.image)
        genre = findViewById(R.id.genre)
        currency = findViewById(R.id.currency)
        price = findViewById(R.id.price)
        star1 = findViewById(R.id.star1)
        star2 = findViewById(R.id.star2)
        star3 = findViewById(R.id.star3)
        star4 = findViewById(R.id.star4)
        star5 = findViewById(R.id.star5)

        star1.setImageResource(R.drawable.ic_unrate_star)
        star2.setImageResource(R.drawable.ic_unrate_star)
        star3.setImageResource(R.drawable.ic_unrate_star)
        star4.setImageResource(R.drawable.ic_unrate_star)
        star5.setImageResource(R.drawable.ic_unrate_star)

        val typedArray = context.obtainStyledAttributes(attributeSet, R.styleable.PosterViewGroup)

        val imageDrawable = typedArray.getDrawable(R.styleable.PosterViewGroup_image)
        imageDrawable?.let { changeImage(imageDrawable) }

        val titleString = typedArray.getString(R.styleable.PosterViewGroup_title)
        titleString?.let { changeTitle(titleString) }

        val genreString = Genre.fromId(typedArray.getInt(R.styleable.PosterViewGroup_genre, 0))
        changeGenre(genreString)

        val currencyString =
            Currency.fromId(typedArray.getInt(R.styleable.PosterViewGroup_currency, 0))
        changeCurrency(currencyString)

        val priceValue = typedArray.getFloat(R.styleable.PosterViewGroup_price, 0F)
        changePrice(priceValue)

        val starsCnt = typedArray.getInt(R.styleable.PosterViewGroup_stars, 0)
        setStars(starsCnt)

        typedArray.recycle()
    }

    fun changeTitle(@StringRes stringRes: Int) {
        title.setText(stringRes)
    }

    private fun changeTitle(text: String) {
        title.text = text
    }

    fun changeGenre(genreString: Genre) {
        genre.text = genreString.name
    }

    fun changeCurrency(currencyString: Currency) {
        currency.text = currencyString.name
    }

    fun changePrice(priceValue: Float) {
        price.text = String.format("%.2f", priceValue)
    }

    fun changeStars(stars: Int) {
        setStars(stars)
    }

    private fun changeImage(drawable: Drawable) {
        image.setImageDrawable(drawable)
    }

    fun changeImage(@DrawableRes drawableRes: Int) {
        image.setImageDrawable(
            ContextCompat.getDrawable(
                context,
                drawableRes
            )
        )
    }

    private fun setStars(stars: Int) {
        when (stars) {
            1 -> {
                star1.setImageResource(R.drawable.ic_rate_star)
            }
            2 -> {
                star1.setImageResource(R.drawable.ic_rate_star)
                star2.setImageResource(R.drawable.ic_rate_star)
            }
            3 -> {
                star1.setImageResource(R.drawable.ic_rate_star)
                star2.setImageResource(R.drawable.ic_rate_star)
                star3.setImageResource(R.drawable.ic_rate_star)
            }
            4 -> {
                star1.setImageResource(R.drawable.ic_rate_star)
                star2.setImageResource(R.drawable.ic_rate_star)
                star3.setImageResource(R.drawable.ic_rate_star)
                star4.setImageResource(R.drawable.ic_rate_star)
            }
            5 -> {
                star1.setImageResource(R.drawable.ic_rate_star)
                star2.setImageResource(R.drawable.ic_rate_star)
                star3.setImageResource(R.drawable.ic_rate_star)
                star4.setImageResource(R.drawable.ic_rate_star)
                star5.setImageResource(R.drawable.ic_rate_star)
            }
        }
    }
}























