package com.philexliveprojects.photopicker.ui.viewmodels

import android.net.Uri
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.philexliveprojects.photopicker.data.PhotoRepository
import com.philexliveprojects.photopicker.data.Photo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class PhotoPickerViewModel @Inject constructor(
    private val photoRepository: PhotoRepository
) : ViewModel() {
    val uiState = photoRepository.getAllPhotos().map {
        PhotoState(it)
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5_000L),
        initialValue = PhotoState(emptyList())
    )


    suspend fun addPhoto(uri: Uri) = photoRepository.insert(Photo(uri = uri))
    suspend fun deletePhoto(photo: Photo) = photoRepository.delete(photo)
}

data class PhotoState(val list: List<Photo>)
