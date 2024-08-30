package com.example.notesapp.model

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.notesapp.dataLayer.LocalNotesDataSource
import com.example.notesapp.dataLayer.Note

class NoteScreenViewModel: ViewModel() {
    private var notesList = mutableStateListOf<Note> ()

    init {
        notesList.addAll(LocalNotesDataSource().getNotesList())
    }

    fun addNote(note: Note) {
        notesList.add(note)
    }
    fun removeNote(note: Note) {
        notesList.remove(note)
    }
    fun getAllNotes(): List<Note> {
        return notesList
    }
}