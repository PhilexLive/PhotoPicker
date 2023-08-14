package com.philexliveprojects.photopicker.data

import android.net.Uri
import androidx.room.TypeConverter

class PhotoConverter {
    @TypeConverter
    fun uriToString(value: Uri): String = value.toString()

    @TypeConverter
    fun stringToUri(value: String): Uri = Uri.parse(value)
}