package com.philexliveprojects.photopicker.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.philexliveprojects.photopicker.utils.PHOTO_TABLE
import kotlinx.coroutines.flow.Flow

@Dao
interface PhotoDao {
    @Query("SELECT * FROM $PHOTO_TABLE")
    fun getAllPhotos(): Flow<List<Photo>>

    @Query("SELECT * FROM $PHOTO_TABLE WHERE id = :id")
    fun getPhoto(id: Long): Flow<Photo>

    @Insert
    suspend fun insert(photo: Photo)

    @Delete
    suspend fun delete(photo: Photo)
}