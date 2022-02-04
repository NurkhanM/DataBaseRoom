package com.md.nurkhan.databaseroom.screens.addNote

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.md.nurkhan.databaseroom.REPOSITORY
import com.md.nurkhan.databaseroom.models.NoteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddNoteViewModel: ViewModel() {

    fun insert(noteModel: NoteModel, onSuccess:() -> Unit ) =
        viewModelScope.launch (Dispatchers.IO) {
            REPOSITORY.insertNote(noteModel){
                onSuccess()
            }

        }
}