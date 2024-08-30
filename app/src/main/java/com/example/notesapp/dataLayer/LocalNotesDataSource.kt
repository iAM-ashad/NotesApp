package com.example.notesapp.dataLayer

class LocalNotesDataSource {
    fun getNotesList(): List<Note> {
        return listOf(
            Note(title = "My First Day", description = "It was good!"),
            Note(title = "My First Day", description = "It was good!"),
            Note(title = "My First Day", description = "It was good!"),
            Note(title = "My First Day", description = "It was good!"),
            Note(title = "My First Day", description = "It was good!"),
            Note(title = "My First Day", description = "It was good!"),
            Note(title = "My First Day", description = "It was good!"),
            Note(title = "My First Day", description = "It was good!"),
            Note(title = "My First Day", description = "It was good!"),
            Note(title = "My First Day", description = "It was good!"),
        )
    }
}