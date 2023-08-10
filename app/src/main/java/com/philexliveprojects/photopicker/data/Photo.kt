package com.philexliveprojects.photopicker.data

import android.net.Uri
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.philexliveprojects.photopicker.utils.PHOTO_TABLE

@Entity(tableName = PHOTO_TABLE)
data class Photo(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val uri: Uri
)
