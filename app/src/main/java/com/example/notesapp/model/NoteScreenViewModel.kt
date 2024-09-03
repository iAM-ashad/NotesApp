package com.example.notesapp.model

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.notesapp.dataLayer.LocalNotesDataSource
import com.example.notesapp.dataLayer.Note
import com.example.notesapp.repository.NoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import javax.inject.Inject

class NoteScreenViewModel @Inject constructor(private val repository: NoteRepository): ViewModel() {

    private val _notesList = MutableStateFlow<List<Note>>(emptyList())
    val notesList = _notesList.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getAllNotes().distinctUntilChanged()
                .collect {listOfNotes->
                    if (listOfNotes.isEmpty()) {
                        Log.d("empty", "empty list")
                    }
                    else {
                        _notesList.value = listOfNotes
                    }
                }
        }
    }

    fun addNote(note: Note) = viewModelScope.launch { repository.addNote(note) }
    fun removeNote(note: Note) = viewModelScope.launch { repository.deleteNote(note) }
    fun updateNote(note: Note) = viewModelScope.launch { repository.updateNote(note) }

}