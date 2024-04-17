package com.example.topicpreview.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Topic(
    @StringRes val stringResId:Int,
    val amountOfTopic: Int,
    @DrawableRes val imageResId: Int
)
