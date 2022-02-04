package com.md.nurkhan.databaseroom.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.md.nurkhan.databaseroom.db.dao.NoteDao
import com.md.nurkhan.databaseroom.models.NoteModel

@Database(entities = [NoteModel::class], version = 1)
abstract class NoteDataBase: RoomDatabase() {

    abstract fun getNoteDao(): NoteDao


    companion object{
        private var dataBase: NoteDataBase ?= null


        @Synchronized
        fun getInstance(context: Context):NoteDataBase{
            return if (dataBase == null){
                dataBase = Room.databaseBuilder(context, NoteDataBase::class.java, "db").build()
                dataBase as NoteDataBase
            } else {
                dataBase as NoteDataBase
            }
        }
    }
}