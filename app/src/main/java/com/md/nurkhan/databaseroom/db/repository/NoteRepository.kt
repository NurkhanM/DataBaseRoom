package com.md.nurkhan.databaseroom.db.repository

import androidx.lifecycle.LiveData
import com.md.nurkhan.databaseroom.models.NoteModel

interface NoteRepository {
    val allNotes: LiveData<List<NoteModel>>
    suspend fun insertNote(noteModel: NoteModel, onSuccess:() -> Unit)
    suspend fun deleteNote(noteModel: NoteModel, onSuccess:() -> Unit)
}