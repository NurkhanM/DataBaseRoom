package com.md.nurkhan.databaseroom.screens.start

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.md.nurkhan.databaseroom.REPOSITORY
import com.md.nurkhan.databaseroom.db.NoteDataBase
import com.md.nurkhan.databaseroom.db.repository.NoteRealization
import com.md.nurkhan.databaseroom.models.NoteModel

class StartViewModel(application: Application): AndroidViewModel(application) {

    val context = application

    fun initDataBase(){
        val daoNote = NoteDataBase.getInstance(context).getNoteDao()
        REPOSITORY = NoteRealization(daoNote)
    }

    fun getAllNotes(): LiveData<List<NoteModel>>{
        return REPOSITORY.allNotes
    }
}