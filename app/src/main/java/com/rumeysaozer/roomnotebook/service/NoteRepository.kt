package com.rumeysaozer.roomnotebook.service

import androidx.lifecycle.LiveData
import com.rumeysaozer.roomnotebook.model.Note

class NoteRepository(private val noteDAO: NoteDAO) {
    val readAllData: LiveData<List<Note>> = noteDAO.readAlData()

    suspend fun addNote(note: Note){
        noteDAO.addNote(note)
    }
    suspend fun updateNote(note: Note){
        noteDAO.updateNote(note)
    }
    suspend fun deleteNote(note: Note){
        noteDAO.deleteNote(note)
    }

}