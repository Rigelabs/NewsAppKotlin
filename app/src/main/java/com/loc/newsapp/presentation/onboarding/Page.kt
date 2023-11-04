package com.loc.newsapp.presentation.onboarding

import androidx.annotation.DrawableRes
import com.loc.newsapp.R

data class Page(
    val title:String,
    val description:String,
    @DrawableRes val image:Int
)
val pages = listOf(
    Page(
        title = "Welcome page",
        description = "This is the welcome page, feel free to interact with the app",
        image = R.drawable.onboarding1
    ),
    Page(
        title = "Second page",
        description = "This is the second page, feel free to give feedback to the app",
        image = R.drawable.onboarding2
    ),
    Page(
        title = "Last page",
        description = "This is the last page, feel free to close the app any time you like",
        image = R.drawable.onboarding3
    )
)
