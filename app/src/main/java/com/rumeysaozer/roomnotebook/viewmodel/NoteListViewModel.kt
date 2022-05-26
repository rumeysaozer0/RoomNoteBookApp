package com.rumeysaozer.roomnotebook.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.rumeysaozer.roomnotebook.model.Note
import com.rumeysaozer.roomnotebook.service.NoteDatabase
import com.rumeysaozer.roomnotebook.service.NoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NoteListViewModel(application: Application): AndroidViewModel(application) {
    val  readAllData: LiveData<List<Note>>
    private val  repository: NoteRepository

init{
    val noteDao = NoteDatabase(getApplication()).noteDao()
    repository = NoteRepository(noteDao)
    readAllData = noteDao.readAlData()
}


    fun addNote(note: Note){
        viewModelScope.launch (Dispatchers.IO){
            repository.addNote(note)
        }
    }
    fun updateNote(note: Note){
        viewModelScope.launch (Dispatchers.IO){
            repository.updateNote(note)
        }
    }
    fun deleteNote(note: Note){
        viewModelScope.launch (Dispatchers.IO){
            repository.deleteNote(note)
        }
    }

}