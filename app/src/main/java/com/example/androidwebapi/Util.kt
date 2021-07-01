package com.example.androidwebapi

import android.content.res.Resources
import android.os.Build
import android.text.Html
import android.text.Spanned
import androidx.core.text.HtmlCompat
import com.example.androidwebapi.database.MoviesEntity


fun formatMovies(movies: List<MoviesEntity>, resources: Resources) : Spanned {
    val sb = StringBuilder()
    sb.apply {
        movies.forEach {
            append("<br>")
            append(resources.getString(R.string.title))

        }
    }
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
        return Html.fromHtml(sb.toString(), Html.FROM_HTML_MODE_LEGACY)
    } else {
        return HtmlCompat.fromHtml(sb.toString(), HtmlCompat.FROM_HTML_MODE_LEGACY)
    }
}