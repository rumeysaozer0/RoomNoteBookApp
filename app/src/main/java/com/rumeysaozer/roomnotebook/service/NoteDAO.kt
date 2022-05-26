package com.rumeysaozer.roomnotebook.service

import androidx.lifecycle.LiveData
import androidx.room.*
import com.rumeysaozer.roomnotebook.model.Note

@Dao
interface NoteDAO {
   @Query(value = "SELECT * FROM note ORDER BY id ASC")
   fun readAlData():LiveData<List<Note>>
   @Insert(onConflict = OnConflictStrategy.IGNORE)
   suspend fun addNote(note:Note)
   @Update
   suspend fun updateNote(note: Note)
   @Delete
   suspend fun deleteNote(note: Note)
}