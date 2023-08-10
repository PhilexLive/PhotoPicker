package com.philexliveprojects.photopicker.data

import android.net.Uri
import androidx.core.net.toUri
import androidx.room.TypeConverter

class PhotoConverter {
    @TypeConverter
    fun uriToString(value: Uri) = value.toString()

    @TypeConverter
    fun stringToUri(value: String) = value.toUri()
}