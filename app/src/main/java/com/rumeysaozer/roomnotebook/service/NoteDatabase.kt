package com.rumeysaozer.roomnotebook.service

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.rumeysaozer.roomnotebook.model.Note

@Database(entities = [Note::class],version = 1,exportSchema = false)
abstract class NoteDatabase : RoomDatabase() {
    abstract fun noteDao(): NoteDAO
    companion object{
        @Volatile
        private var instance : NoteDatabase? = null
        private val lock = Any()
        operator fun invoke(context: Context) = instance ?: synchronized(lock){
            instance ?: makeDatabase(context).also {
                instance = it
            }
        }
        private fun makeDatabase(context: Context) =  Room.databaseBuilder(
            context.applicationContext, NoteDatabase::class.java, "database"
        ).build()
    }


}