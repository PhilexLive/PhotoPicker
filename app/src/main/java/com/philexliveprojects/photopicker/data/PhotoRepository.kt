package com.philexliveprojects.photopicker.data

import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PhotoRepository @Inject constructor(private val photoDao: PhotoDao) {
    fun getAllPhotos(): Flow<List<Photo>> = photoDao.getAllPhotos()

    fun getPhoto(id: Long): Flow<Photo> = photoDao.getPhoto(id)

    suspend fun insert(photo: Photo) = photoDao.insert(photo)

    suspend fun delete(photo: Photo) = photoDao.delete(photo)
}