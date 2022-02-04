package com.md.nurkhan.databaseroom.screens.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.md.nurkhan.databaseroom.REPOSITORY
import com.md.nurkhan.databaseroom.models.NoteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailViewModel: ViewModel() {

    fun delete(noteModel: NoteModel, onSuccess:() -> Unit ) =
        viewModelScope.launch (Dispatchers.IO) {
            REPOSITORY.deleteNote(noteModel){
                onSuccess()
            }

        }
}